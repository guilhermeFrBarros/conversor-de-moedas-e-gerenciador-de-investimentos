package com.prometheustecnologi.gerenciamentodeinvestimentos.entities.belonging;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.Conversao;
import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.conversao.ConversaoList;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Embeddable
public class Belonging_PK {
    
    @ManyToOne
    @OnDelete( action = OnDeleteAction.CASCADE ) // serve para apagar referencia em outras tablas
    @JoinColumn(name = "convesao_id")
    private Conversao conversao;

    @ManyToOne 
    @JoinColumn(name = "list_id")
    private ConversaoList conversaoList;

    public Belonging_PK() {
    }
    

     public Belonging_PK(Conversao conversao, ConversaoList conversaoList) {
        this.conversao = conversao;
        this.conversaoList = conversaoList;
    }

    public Conversao getConversao() {
        return conversao;
    }

    public void setConversao(Conversao conversao) {
        this.conversao = conversao;
    }

    public ConversaoList getConversaoList() {
        return conversaoList;
    }

    public void setConversaoList(ConversaoList conversaoList) {
        this.conversaoList = conversaoList;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((conversao == null) ? 0 : conversao.hashCode());
        result = prime * result + ((conversaoList == null) ? 0 : conversaoList.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Belonging_PK other = (Belonging_PK) obj;
        if (conversao == null) {
            if (other.conversao != null)
                return false;
        } else if (!conversao.equals(other.conversao))
            return false;
        if (conversaoList == null) {
            if (other.conversaoList != null)
                return false;
        } else if (!conversaoList.equals(other.conversaoList))
            return false;
        return true;
    }
    
    
}


