package br.prandini.smartwallet.transacao.domain;

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * @author prandini
 * created 4/5/24
 */
@Entity
@Table(name = "TRANSACAO")
@SequenceGenerator(name = "SEQ_TRNS")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dtVencimento;

    @Enumerated
    @Column(name = "STATUS")
    private TransacaoStatusEnum status;

    @JoinColumn(name = "LANCAMENTO_ID")
    @ManyToOne
    private Lancamento lancamento;

    @Column(name = "DESCRICAO")
    private String descricao;
}
