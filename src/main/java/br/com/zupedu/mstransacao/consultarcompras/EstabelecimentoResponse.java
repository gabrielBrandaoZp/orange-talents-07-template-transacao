package br.com.zupedu.mstransacao.consultarcompras;

import br.com.zupedu.mstransacao.transacao.Estabelecimento;

public class EstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(Estabelecimento estabelecimento) {
        this.nome = estabelecimento.getNome();
        this.cidade = estabelecimento.getCidade();
        this.endereco = estabelecimento.getEndereco();
    }

    public static EstabelecimentoResponse converter(Estabelecimento estabelecimento) {
        return new EstabelecimentoResponse(estabelecimento);
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
