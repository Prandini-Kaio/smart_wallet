package br.prandini.smartwallet.totalizador.service.actions;

/*
 * @author prandini
 * created 5/10/24
 */

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.conta.repository.ContaRepository;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.lancamento.repository.LancamentoRepository;
import br.prandini.smartwallet.totalizador.model.TotalizadorBalancoOutput;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class TotalizadorGetter {

    @Resource
    private LancamentoRepository lancamentoRepository;

    @Resource
    private ContaRepository contaRepository;

    public TotalizadorBalancoOutput getBalanco() {
        List<Lancamento> lancamentos = lancamentoRepository.findAll();
        return this.montaBalanco(lancamentos);
    }

    public TotalizadorBalancoOutput getBalancoPorConta(String contaStr) {
        Conta conta = contaRepository.getContaByFilter(contaStr);

        List<Lancamento> lancamentos = lancamentoRepository.findAll()
                .stream().filter(f -> f.getConta().equals(conta)).toList();
        return this.montaBalanco(lancamentos);
    }

    private TotalizadorBalancoOutput montaBalanco(List<Lancamento> lancamentos){

        BigDecimal valorEntradas = BigDecimal.ZERO;
        BigDecimal valorSaidas = BigDecimal.ZERO;
        BigDecimal valorTotal = BigDecimal.ZERO;

        for(Lancamento lancamento : lancamentos){
            if(lancamento.getTipoLancamento() == TipoLancamentoEnum.ENTRADA)
                valorEntradas = valorEntradas.add(lancamento.getValor());

            if(lancamento.getTipoLancamento() == TipoLancamentoEnum.SAIDA)
                valorSaidas = valorSaidas.add(lancamento.getValor());
        }

        valorTotal = valorEntradas.subtract(valorSaidas);


        return TotalizadorBalancoOutput.builder()
                .valorEntradas(valorEntradas)
                .valorSaidas(valorSaidas)
                .valorTotal(valorTotal)
                .build();
    }
}
