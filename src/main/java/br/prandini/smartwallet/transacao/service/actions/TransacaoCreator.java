package br.prandini.smartwallet.transacao.service.actions;

/*
 * @author prandini
 * created 4/16/24
 */

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoCreator {

    @Resource
    private TransacaoRepository repository;

    public List<Transacao> criarTransacoes(Lancamento lancamento){

        List<Transacao> transacoes = new ArrayList<>();

        int parcelas = lancamento.getParcelas();

        BigDecimal valorPorParcela = lancamento.getValor().divide(BigDecimal.valueOf(parcelas), RoundingMode.CEILING);

        for(int i = 0; i < lancamento.getParcelas(); i++){
            transacoes.add(Transacao.builder()
                            .valor(valorPorParcela)
                            .dtVencimento(calcularDataVencimento(transacoes))
                            .lancamento(lancamento)
                    .build());
        }

        repository.saveAll(transacoes);

        return transacoes;
    }

    private LocalDateTime calcularDataVencimento(List<Transacao> transacoes){
        if(transacoes.size() < 1)
            return LocalDateTime.now();

        LocalDateTime dtTime = transacoes.get(transacoes.size()-1).getDtVencimento();

        if(dtTime.getMonth().getValue() == 12){
            dtTime = dtTime.plusYears(1);
        }

        dtTime = dtTime.plusMonths(1);

        return dtTime;
    }
}
