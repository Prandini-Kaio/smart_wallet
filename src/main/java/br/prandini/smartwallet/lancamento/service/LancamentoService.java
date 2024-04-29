package br.prandini.smartwallet.lancamento.service;

/*
 * @author prandini
 * created 4/16/24
 */

import br.prandini.smartwallet.lancamento.converter.LancamentoConverter;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoInputDTO;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.lancamento.repository.LancamentoRepository;
import br.prandini.smartwallet.lancamento.service.actions.LancamentoCreator;
import br.prandini.smartwallet.lancamento.service.actions.LancamentoValidator;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class LancamentoService {

    @Resource
    private LancamentoCreator creator;

    @Resource
    LancamentoValidator validator;

    @Resource
    private LancamentoRepository repository;

    public Page<LancamentoOutput> findAll(Pageable pageable){
        return repository.findAll(pageable).map(LancamentoConverter::toOutput);
    }

    public LancamentoOutput criarLancamento(LancamentoInputDTO input) {
        validator.validarCriacao(input);
        return LancamentoConverter.toOutput(creator.criarLancamento(input));
    }

    public List<LancamentoOutput> findByVencimento(Integer mes) {
        return repository.findByDtCriacao(mes).stream().map(LancamentoConverter::toOutput).toList();
    }
}
