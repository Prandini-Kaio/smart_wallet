package br.prandini.smartwallet.transacao.converter;

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;

import java.util.List;

/*
 * @author prandini
 * created 4/16/24
 */
public class TransacaoConverter {

    public static List<TransacaoOutput> toListOutputs(List<Transacao> transacoes){
        return transacoes.stream().map(TransacaoConverter::toOutput).toList();
    }

    public static TransacaoOutput toOutput(Transacao transacao){
        return TransacaoOutput.builder()
                .id(transacao.getId())
                .status(transacao.getStatus())
                .valor(transacao.getValor())
                .dtVencimento(transacao.getDtVencimento().toLocalDate())
                .descricao(transacao.getDescricao())
                .build();
    }
}
