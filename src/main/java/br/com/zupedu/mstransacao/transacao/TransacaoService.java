package br.com.zupedu.mstransacao.transacao;

import br.com.zupedu.mstransacao.transacao.external.TransacaoMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    private final Logger logger = LoggerFactory.getLogger(TransacaoService.class);

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoMessage transacaoMessage) {
        Transacao transacao = transacaoMessage.paraTransacao();
        transacaoRepository.save(transacao);
        logger.info("Transação de id: {}, efetuada com sucesso!", transacaoMessage.getId());
    }
}
