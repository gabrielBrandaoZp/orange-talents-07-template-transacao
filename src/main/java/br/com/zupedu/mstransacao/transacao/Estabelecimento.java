package br.com.zupedu.mstransacao.transacao;

import javax.persistence.Embeddable;

@Embeddable
public class Estabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    private Estabelecimento(){}

    public Estabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
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
