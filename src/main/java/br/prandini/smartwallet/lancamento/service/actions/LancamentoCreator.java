package br.prandini.smartwallet.lancamento.service.actions;

import br.prandini.smartwallet.conta.domain.Conta;
import br.prandini.smartwallet.conta.service.actions.ContaGetter;
import br.prandini.smartwallet.conta.service.actions.ContaUpdater;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoInputDTO;
import br.prandini.smartwallet.lancamento.repository.LancamentoRepository;
import br.prandini.smartwallet.transacao.service.actions.TransacaoCreator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
 * @author prandini
 * created 4/16/24
 */

@Component
public class LancamentoCreator {

    @Resource
    private LancamentoRepository repository;

    @Resource
    private ContaGetter contaGetter;

    @Resource
    private ContaUpdater contaUpdater;

    @Resource
    private TransacaoCreator transacaoCreator;

    public Lancamento criarLancamento(LancamentoInputDTO input) {

        Conta conta = contaGetter.getContaByFilter(input.getConta());

        Lancamento lancamento = repository.save(buildLancamento(input, conta));

        transacaoCreator.criarTransacoes(lancamento);

        if(input.getTipoLancamento() == TipoLancamentoEnum.SAIDA)
            contaUpdater.atualizaLancamentoSaida(conta.getId(), lancamento);
        else{
            contaUpdater.atualizaLancamentoEntrada(conta.getId(), lancamento.getValor());
        }

        return lancamento;
    }

    private Lancamento buildLancamento(LancamentoInputDTO input, Conta conta){
        return Lancamento.builder()
                .tipoLancamento(input.getTipoLancamento())
                .valor(input.getValor())
                .dtCriacao(LocalDateTime.now())
                .parcelas(input.getParcelas())
                .conta(conta)
                .descricao(input.getDescricao())
                .build();

    }

}
