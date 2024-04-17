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
                .totalLancamentos(conta.getLancamentos().size())
                .build();
    }

//    private static LancamentoOutput toLancamentoOutput(Lancamento lancamento){
//        return LancamentoOutput.builder()
//                .id(lancamento.getId())
//                .tipoLancamento(lancamento.getTipoLancamento())
//                .valor(lancamento.getValor())
//                .dtCriacao(lancamento.getDtCriacao())
//                .parcelas(lancamento.getParcelas())
//                .transacoes(lancamento.getTransacoes()
//                        .stream()
//                        .map(ContaConverter::toTransacaoOutput)
//                        .toList())
//                .descricao(lancamento.getDescricao())
//                .build();
//    }
//
//    private static TransacaoOutput toTransacaoOutput(Transacao transacao){
//        return TransacaoOutput.builder()
//                .id(transacao.getId())
//                .valor(transacao.getValor())
//                .dtVencimento(transacao.getDtVencimento())
//                .build();
//    }
}
