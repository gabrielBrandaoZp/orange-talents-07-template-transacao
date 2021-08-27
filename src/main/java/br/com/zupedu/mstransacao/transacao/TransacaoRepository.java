package br.com.zupedu.mstransacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

    Page<Transacao> findByCartaoApiId(String apiId, Pageable paginacao);
}
