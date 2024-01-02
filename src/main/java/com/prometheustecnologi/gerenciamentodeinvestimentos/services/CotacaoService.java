package com.prometheustecnologi.gerenciamentodeinvestimentos.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.cotacao.Cotacao;

@Service
public class CotacaoService {

    private final HttpClient httpClient;

    public CotacaoService() {
        this.httpClient = HttpClient.newBuilder()
                .version(Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(8))
                .followRedirects(Redirect.NORMAL)
                .build();
    }

    public Cotacao getExchangeRate(String shortName) {


        JSONObject obj = requestForQuoteAPI(shortName);

        String currencyConversionCode = shortName.replaceAll("-", "");
        JSONObject objConversao = obj.getJSONObject(currencyConversionCode);

        String nome = objConversao.getString("name");
        Double maximumPrice = objConversao.getDouble("high");
        Double minimumPrice = objConversao.getDouble("low");
        Double salePrice = objConversao.getDouble("ask");
        Double buyPrice = objConversao.getDouble("bid");

        Cotacao cotacao = new Cotacao(nome, shortName, maximumPrice,
         minimumPrice, salePrice, buyPrice);

        return cotacao;
    }

//refatorar para  melhorar o desempenho com outras bibliotecas
    private JSONObject requestForQuoteAPI(String shortName) {
        String url = "https://economia.awesomeapi.com.br/last/" + shortName;

        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create(url))
                .timeout(Duration.ofSeconds(6))
                .build();

        HttpResponse<String> response;
        try {
            response = this.httpClient.send(request, BodyHandlers.ofString());
            JSONObject obj = new JSONObject(response.body());
            return obj;
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("Ocorreu um erro = " + e.getMessage());
        }
    }
}
