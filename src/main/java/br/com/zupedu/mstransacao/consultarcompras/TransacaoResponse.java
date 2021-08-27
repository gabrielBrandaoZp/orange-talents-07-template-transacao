package br.com.zupedu.mstransacao.consultarcompras;

import br.com.zupedu.mstransacao.transacao.Transacao;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(Transacao transacao) {
        this.id = transacao.getId().toString();
        this.valor = transacao.getValor();
        this.estabelecimento = EstabelecimentoResponse.converter(transacao.getEstabelecimento());
        this.cartao = CartaoResponse.converter(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public static Page<TransacaoResponse> converter(Page<Transacao> transacaosPaginadas) {
        return transacaosPaginadas.map(TransacaoResponse::new);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
