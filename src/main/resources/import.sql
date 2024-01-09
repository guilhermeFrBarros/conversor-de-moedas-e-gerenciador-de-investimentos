INSERT INTO usuarios (email, senha, telefone) VALUES ( 'guilhermeg@gmail.com', '123456', '3528-0000' );

INSERT INTO Tb_consversion_list (name) VALUES ( 'Dolar Americano/Real Brasileiro' );
INSERT INTO Tb_consversion_list (name) VALUES ( 'Euro/Real Brasileiro' );


INSERT INTO TB_CONVERCAO (nome, SHORT_NAME, amount, BUY_PRICE, SALE_PRICE, MAXIMUM_PRICE, MINIMUM_PRICE, img_url,data_da_cotacao, long_description, usuario_pk) VALUES ('Dolar Americano/Real Brasileiro', 'USD-BRL', 1.0, 4.7375, 4.738, 4.7378, 4.7366,'https://conteudo.imguol.com.br/c/noticias/02/2022/01/14/notas-dolar-real-1642179381190_v2_4x3.jpg', '2023-07-15', 'Cotação em dia normal onde o brasil pasa por uma redução do risco brasil', 1);
INSERT INTO TB_CONVERCAO (nome, SHORT_NAME, amount, BUY_PRICE, SALE_PRICE, MAXIMUM_PRICE, MINIMUM_PRICE, img_url, data_da_cotacao, long_description, usuario_pk) VALUES ('Euro/Real Brasileiro', 'EUR-BRL', 1.0,  5.2487, 45.2567, 5.2532, 5.2499,'https://www.remessaonline.com.br/blog/wp-content/uploads/2022/05/real-e-euro-1170x780.png', '2023-07-15', 'Cotação em dia normal onde o brasil pasa por uma redução do risco brasil', 1);
INSERT INTO TB_CONVERCAO (nome, SHORT_NAME, amount, BUY_PRICE, SALE_PRICE, MAXIMUM_PRICE, MINIMUM_PRICE, img_url, data_da_cotacao, long_description, usuario_pk) VALUES ('Euro/Real 2 Brasileiro', 'EUR-BRL', 1.0, 5.2487, 45.2567, 5.2532, 5.2499,'https://www.remessaonline.com.br/blog/wp-content/uploads/2022/05/real-e-euro-1170x780.png', '2023-07-15', 'Cotação em dia normal onde o brasil pasa por uma redução do risco brasil', 1);

INSERT INTO tb_belonging (list_id, convesao_id, position) VALUES (1, 1, 0);
INSERT INTO tb_belonging (list_id, convesao_id, position) VALUES (2, 2, 1);
INSERT INTO tb_belonging (list_id, convesao_id, position) VALUES (2, 3, 2);


