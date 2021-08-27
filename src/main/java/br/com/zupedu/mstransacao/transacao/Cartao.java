package br.com.zupedu.mstransacao.transacao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String apiId;
    private String email;

    @OneToMany(mappedBy = "cartao")
    private List<Transacao> transacoes;

    @Deprecated
    private Cartao(){}

    public Cartao(String apiId, String email) {
        this.apiId = apiId;
        this.email = email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public UUID getId() {
        return id;
    }

    public String getApiId() {
        return apiId;
    }

    public String getEmail() {
        return email;
    }
}
