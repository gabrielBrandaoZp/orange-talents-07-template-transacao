package br.com.zupedu.mstransacao.transacao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @Deprecated
    private Cartao(){}

    public Cartao(String apiId, String email) {
        this.apiId = apiId;
        this.email = email;
    }
}
