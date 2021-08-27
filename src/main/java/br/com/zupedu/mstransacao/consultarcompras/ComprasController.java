package br.com.zupedu.mstransacao.consultarcompras;

import br.com.zupedu.mstransacao.transacao.Cartao;
import br.com.zupedu.mstransacao.transacao.Transacao;
import br.com.zupedu.mstransacao.transacao.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/compras")
public class ComprasController {
    private final Logger logger = LoggerFactory.getLogger(ComprasController.class);

    private final CartaoRepository cartaoRepository;
    private final TransacaoRepository transacaoRepository;

    public ComprasController(CartaoRepository cartaoRepository, TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping("/{id}/transacoes")
    public ResponseEntity<Page<TransacaoResponse>> consultarTransacoes(@PathVariable String id,
                                                                    @PageableDefault(sort = "efetivadaEm", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable){

        logger.info("method=consultarTransacoes, msg=Buscando transações do cartão: {}", id);
        Optional<Cartao> possivelCartao = cartaoRepository.findById(UUID.fromString(id));
        if(possivelCartao.isPresent()) {
            Cartao cartao = possivelCartao.get();
            Page<Transacao> transacaosPaginadas = transacaoRepository.findByCartaoApiId(cartao.getApiId(), pageable);
            Page<TransacaoResponse> response = TransacaoResponse.converter(transacaosPaginadas);
            return ResponseEntity.ok(response);
        }

        logger.error("method=consultarTransacoes, msg=Cartão de id: {} não encontrado", id);
        return ResponseEntity.notFound().build();
    }
}
