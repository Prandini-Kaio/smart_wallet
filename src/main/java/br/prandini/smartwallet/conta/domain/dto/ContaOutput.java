package br.prandini.smartwallet.conta.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import lombok.Builder;

import java.util.List;

@Builder
public class ContaOutput {
    private Long id;
    private String banco;
    private String nome;
    private int totalLancamentos;
}
