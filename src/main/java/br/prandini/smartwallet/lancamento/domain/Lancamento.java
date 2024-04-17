package br.prandini.smartwallet.lancamento.domain;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.transacao.domain.Transacao;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LANCAMENTO")
@Getter
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TIPO_LANCAMENTO")
    @Enumerated(value = EnumType.ORDINAL)
    private TipoLancamentoEnum tipoLancamento;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DATA_CRIACAO")
    private LocalDateTime dtCriacao;

    @Column(name = "PARCELAS")
    private int parcelas;

    @ManyToOne
    private Conta conta;

    @OneToMany
    private List<Transacao> transacoes;

    @Column(name = "DESCRICAO")
    private String descricao;
}
