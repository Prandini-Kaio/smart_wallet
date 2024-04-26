package br.prandini.smartwallet.conta.converter;

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.conta.domain.dto.ContaOutput;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/*
 * @author prandini
 * created 4/5/24
 */
public class ContaConverter {

    public static ContaOutput toOutput(Conta conta){

        BigDecimal totalLancamentos = BigDecimal.ZERO;
        if(conta.getLancamentos() != null)
            totalLancamentos = conta.getLancamentos().stream()
                .map(Lancamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return ContaOutput.builder()
                .id(conta.getId())
                .banco(conta.getBanco())
                .nome(conta.getNome())
                .saldoParcial(conta.getSaldoParcial())
                .totalLancamentos(totalLancamentos)
                .build();
    }
}
