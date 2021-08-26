package br.com.zupedu.mstransacao.transacao.external;

import br.com.zupedu.mstransacao.transacao.Cartao;
import br.com.zupedu.mstransacao.transacao.Estabelecimento;
import br.com.zupedu.mstransacao.transacao.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoMessage {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoMessage estabelecimento;
    private CartaoMesssage cartao;
    private String efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoMessage getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoMesssage getCartao() {
        return cartao;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao paraTransacao() {
        Estabelecimento estabelecimento = this.estabelecimento.paraEstabelecimento();
        Cartao cartao = this.cartao.paraCartao();
        return new Transacao(id, valor, estabelecimento, cartao, LocalDateTime.parse(efetivadaEm));
    }
}
