package br.com.zupedu.mstransacao.consultarcompras;

import br.com.zupedu.mstransacao.transacao.Cartao;

public class CartaoResponse {

    private String id;
    private String email;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getId().toString();
        this.email = cartao.getEmail();
    }

    public static CartaoResponse converter(Cartao cartao) {
        return new CartaoResponse(cartao);
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
