package br.prandini.smartwallet.lancamento.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.domain.dto.ContaOutput;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class LancamentoOutput {
    private Long id;
    private TipoLancamentoEnum tipoLancamento;
    private BigDecimal valor;
    private String conta;
    private LocalDateTime dtCriacao;
    private int parcelas;
    private String descricao;
}
