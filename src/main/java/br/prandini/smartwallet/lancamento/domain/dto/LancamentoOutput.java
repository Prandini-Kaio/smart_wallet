package br.prandini.smartwallet.lancamento.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.lancamento.domain.CategoriaLancamentoEnum;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.lancamento.domain.TipoPagamentoEnum;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class LancamentoOutput {

    private Long id;

    private TipoLancamentoEnum tipoLancamento;

    private CategoriaLancamentoEnum categoriaLancamento;

    private TipoPagamentoEnum tipoPagamento;

    private BigDecimal valor;

    private String conta;

    private String dtCriacao;

    private int parcelas;

    private String descricao;

}
