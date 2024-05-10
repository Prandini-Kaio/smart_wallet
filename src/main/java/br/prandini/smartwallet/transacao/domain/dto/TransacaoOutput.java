package br.prandini.smartwallet.transacao.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class TransacaoOutput {
    private Long id;

    private BigDecimal valor;

    private TransacaoStatusEnum status;

    private String dtVencimento;

    private String descricao;
}
