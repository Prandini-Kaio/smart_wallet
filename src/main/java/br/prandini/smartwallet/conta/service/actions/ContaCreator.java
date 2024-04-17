package br.prandini.smartwallet.conta.service.actions;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.conta.domain.dto.ContaInput;
import br.prandini.smartwallet.conta.repository.ContaRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ContaCreator {

    @Resource
    private ContaRepository repository;

    public Conta criarConta(ContaInput input){
        Conta conta = new Conta();

        conta.setBanco(input.getBanco());
        conta.setNome(input.getNome());

        return repository.save(conta);
    }
}
