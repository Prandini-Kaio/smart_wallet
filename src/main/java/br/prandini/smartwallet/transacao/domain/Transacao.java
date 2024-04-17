package br.prandini.smartwallet.transacao.domain;

import jakarta.persistence.*;
import lombok.Getter;

import javax.annotation.processing.Generated;
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
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @Column(name = "DATA_VENCIMENTO")
    private LocalDateTime dtVencimento;
}
