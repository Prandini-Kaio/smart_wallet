package br.prandini.smartwallet.transacao.service;

import br.prandini.smartwallet.transacao.converter.TransacaoConverter;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/*
 * @author prandini
 * created 4/17/24
 */
@Service
public class TransacaoService {

    @Resource
    private TransacaoRepository repository;

    public Page<TransacaoOutput> findByFilter(String filter){
        return new PageImpl<>(repository.findByFilter(filter)).map(TransacaoConverter::toOutput);
    }
}
