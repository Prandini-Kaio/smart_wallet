package br.prandini.smartwallet.transacao.service.actions;

/*
 * @author prandini
 * created 4/29/24
 */

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.TransacaoFilter;
import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransacaoGetter {

    @Resource
    private TransacaoRepository repository;

    public List<Transacao> findByMonth(Integer month){
        return repository.findByVencimento(month);
    }

    public List<Transacao> findByFilter(TransacaoFilter filter){
        return repository.findByFilter(filter.getStatus(), filter.getMes());
    }

    public List<Transacao> findByStringFilter(String filter){
        return repository.findByStringFilter(filter);
    }
}
