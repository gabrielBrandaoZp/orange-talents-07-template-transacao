package br.com.zupedu.mstransacao.transacao.external;

import br.com.zupedu.mstransacao.transacao.Estabelecimento;

public class EstabelecimentoMessage {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento paraEstabelecimento() {
        return new Estabelecimento(nome, cidade, endereco);
    }
}
