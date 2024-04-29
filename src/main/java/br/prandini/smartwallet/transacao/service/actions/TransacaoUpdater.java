package br.prandini.smartwallet.transacao.service.actions;

/*
 * @author prandini
 * created 4/29/24
 */

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TransacaoUpdater {

    @Resource
    private TransacaoRepository repository;

    public Transacao pagarTransacao(Long id) {
        Transacao transacao = repository.getReferenceById(id);

        transacao.setStatus(TransacaoStatusEnum.PAGO);

        return repository.save(transacao);
    }
}
