package br.prandini.smartwallet.lancamento.domain.dto;

import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import lombok.Getter;

import java.math.BigDecimal;

/*
 * @author prandini
 * created 4/16/24
 */
@Getter
public class LancamentoInputDTO {

    private TipoLancamentoEnum tipoLancamento;

    private BigDecimal valor;

    private int parcelas;

    private String conta;

    private String descricao;
}
