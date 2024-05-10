package br.prandini.smartwallet.lancamento.domain.dto;

import br.prandini.smartwallet.lancamento.domain.CategoriaLancamentoEnum;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

/*
 * @author prandini
 * created 4/16/24
 */
@Getter
public class LancamentoInputDTO {

    @NotNull
    private TipoLancamentoEnum tipoLancamento;

    @NotNull
    private CategoriaLancamentoEnum categoriaLancamento;

    @NotNull
    private boolean debito;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private int parcelas;

    @NotEmpty
    private String conta;

    private String descricao;
}
