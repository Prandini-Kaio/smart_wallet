package br.prandini.smartwallet.transacao.service.actions;

/*
 * @author prandini
 * created 4/29/24
 */

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class TransacaoValidator {

    @Resource
    private TransacaoRepository repository;

    public void validarPagament(Long id){
        Transacao transacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada."));

        if(transacao.getStatus() != TransacaoStatusEnum.PENDENTE)
            throw new IllegalStateException("Tentativa de pagamento a uma transação cancelada ou em atraso.");
    }
}
