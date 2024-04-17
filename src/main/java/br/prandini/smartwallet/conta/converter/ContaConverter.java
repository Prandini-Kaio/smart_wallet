package br.prandini.smartwallet.conta.converter;

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.conta.domain.dto.ContaOutput;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;

import java.util.List;
import java.util.Optional;

/*
 * @author prandini
 * created 4/5/24
 */
public class ContaConverter {

    public static ContaOutput toOutput(Conta conta){
        return ContaOutput.builder()
                .id(conta.getId())
                .banco(conta.getBanco())
                .nome(conta.getNome())
                .totalLancamentos(conta.getLancamentos() == null ? 0 : conta.getLancamentos().size())
                .build();
    }
}
