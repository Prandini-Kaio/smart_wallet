package br.prandini.smartwallet.transacao.service;

import br.prandini.smartwallet.transacao.converter.TransacaoConverter;
import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import br.prandini.smartwallet.transacao.service.actions.TransacaoGetter;
import br.prandini.smartwallet.transacao.service.actions.TransacaoUpdater;
import br.prandini.smartwallet.transacao.service.actions.TransacaoValidator;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * @author prandini
 * created 4/17/24
 */
@Service
public class TransacaoService {

    @Resource
    private TransacaoGetter getter;

    @Resource
    private TransacaoUpdater updater;

    @Resource
    private TransacaoValidator validator;

    @Resource
    private TransacaoRepository repository;

    public TransacaoOutput pagarTransacao(Long id) {
        validator.validarPagament(id);
        return TransacaoConverter.toOutput(updater.pagarTransacao(id));
    }

    public Page<TransacaoOutput> findByMonth(Integer month){
        return new PageImpl<>(getter.findByMonth(month))
                .map(TransacaoConverter::toOutput);
    }

    public Page<TransacaoOutput> findByFilter(String filter){
        return new PageImpl<>(getter.findByFilter(filter))
                .map(TransacaoConverter::toOutput);
    }

    public Page<TransacaoOutput> findByStatus(TransacaoStatusEnum status){
        return new PageImpl<>(getter.findByStatus(status))
                .map(TransacaoConverter::toOutput);
    }


}
