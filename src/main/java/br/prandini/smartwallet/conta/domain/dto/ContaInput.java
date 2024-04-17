package br.prandini.smartwallet.conta.domain.dto;

/*
 * @author prandini
 * created 4/5/24
 */

import lombok.Getter;

@Getter
public class ContaInput {

    private Long id;

    private String banco;

    private String nome;

}
