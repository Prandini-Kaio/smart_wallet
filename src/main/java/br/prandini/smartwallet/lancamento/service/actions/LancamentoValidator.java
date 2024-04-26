package br.prandini.smartwallet.lancamento.service.actions;

import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoInputDTO;
import br.prandini.smartwallet.lancamento.exceptions.LancamentoException;
import br.prandini.smartwallet.lancamento.exceptions.LancamentoExceptionMessages;
import org.springframework.stereotype.Component;

/*
 * @author prandini
 * created 4/26/24
 */

@Component
public class LancamentoValidator {


    public void validarCriacao(LancamentoInputDTO input) {
        if(input.getTipoLancamento() == TipoLancamentoEnum.ENTRADA)
            validarEntrada(input);
    }

    private void validarEntrada(LancamentoInputDTO input){
        if(input.getParcelas() > 1)
            throw new LancamentoException(LancamentoExceptionMessages.entradaComParcelas());
    }
}
