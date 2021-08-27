package br.com.zupedu.mstransacao.consultarcompras;

import br.com.zupedu.mstransacao.transacao.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
}
