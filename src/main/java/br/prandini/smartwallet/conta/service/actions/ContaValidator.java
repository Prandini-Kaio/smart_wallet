package br.prandini.smartwallet.conta.service.actions;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.domain.dto.ContaInput;
import br.prandini.smartwallet.conta.repository.ContaRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ContaValidator {

    @Resource
    private ContaRepository repository;

    public void validarCriacao(ContaInput input){
        if(repository.findByNomeAndBanco(input.getNome(), input.getBanco()))
            throw new RuntimeException("Já existe conta cadastrada com nome " + input.getNome() + " para este banco.");
    }
}
