package br.prandini.smartwallet.conta.domain;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CONTA")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BANCO")
    private String banco;

    @Column(name = "NOME")
    private String nome;

    @OneToMany
    private List<Lancamento> lancamentos;
}
