package br.prandini.smartwallet.transacao.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
public class TransacaoOutput {
    private Long id;

    private BigDecimal valor;

    private LocalDateTime dtVencimento;
}
