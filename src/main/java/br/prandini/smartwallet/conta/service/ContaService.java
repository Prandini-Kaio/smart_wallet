package br.prandini.smartwallet.conta.service;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.converter.ContaConverter;
import br.prandini.smartwallet.conta.domain.dto.ContaInput;
import br.prandini.smartwallet.conta.domain.dto.ContaOutput;
import br.prandini.smartwallet.conta.repository.ContaRepository;
import br.prandini.smartwallet.conta.service.actions.ContaCreator;
import br.prandini.smartwallet.conta.service.actions.ContaGetter;
import br.prandini.smartwallet.conta.service.actions.ContaValidator;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Resource
    private ContaRepository repository;

    @Resource
    private ContaCreator creator;

    @Resource
    private ContaGetter getter;

    @Resource
    private ContaValidator validator;

    public Page<ContaOutput> getAll(Pageable pageable){
        return getter.getAll(pageable).map(ContaConverter::toOutput);
    }

    public ContaOutput create(ContaInput input){
//        validator.validarCriacao(input);
        return ContaConverter.toOutput(creator.criarConta(input));
    }
}
