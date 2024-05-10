package br.prandini.smartwallet.totalizador.model;

/*
 * @author prandini
 * created 5/10/24
 */

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TotalizadorBalancoOutput {

    private BigDecimal valorTotal;

    private BigDecimal valorEntradas;

    private BigDecimal valorSaidas;
}
