package br.prandini.smartwallet.lancamento.converter;

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.transacao.converter.TransacaoConverter;
import br.prandini.smartwallet.utils.LocalDateConverter;

/*
 * @author prandini
 * created 4/16/24
 */
public class LancamentoConverter {

    public static LancamentoOutput toOutput(Lancamento lancamento){
        return LancamentoOutput.builder()
                .id(lancamento.getId())
                .tipoLancamento(lancamento.getTipoLancamento())
                .categoriaLancamento(lancamento.getCategoriaLancamento())
                .tipoPagamento(lancamento.getTipoPagamento())
                .valor(lancamento.getValor())
                .dtCriacao(LocalDateConverter.toBrazilianDateTimeString(lancamento.getDtCriacao()))
                .conta(lancamento.getConta().getBanco() + " - " + lancamento.getConta().getNome())
                .parcelas(lancamento.getParcelas())
                .descricao(lancamento.getDescricao())
                .build();
    }
}
