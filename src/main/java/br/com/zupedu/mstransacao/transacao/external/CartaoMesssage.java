package br.com.zupedu.mstransacao.transacao.external;

import br.com.zupedu.mstransacao.transacao.Cartao;

public class CartaoMesssage {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao paraCartao() {
        return new Cartao(id, email);
    }
}
