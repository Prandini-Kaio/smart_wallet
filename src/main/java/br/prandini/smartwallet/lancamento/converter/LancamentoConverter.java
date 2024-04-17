package br.prandini.smartwallet.lancamento.converter;

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.transacao.converter.TransacaoConverter;

/*
 * @author prandini
 * created 4/16/24
 */
public class LancamentoConverter {

    public static LancamentoOutput toOutput(Lancamento lancamento){
        return LancamentoOutput.builder()
                .id(lancamento.getId())
                .tipoLancamento(lancamento.getTipoLancamento())
                .valor(lancamento.getValor())
                .dtCriacao(lancamento.getDtCriacao())
                .parcelas(lancamento.getParcelas())
                .descricao(lancamento.getDescricao())
                .build();
    }
}
