package br.prandini.smartwallet.lancamento.service.actions;

import br.prandini.smartwallet.conta.service.actions.ContaGetter;
import br.prandini.smartwallet.lancamento.domain.Lancamento;
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
    private TransacaoCreator transacaoCreator;

    public Lancamento criarLancamento(LancamentoInputDTO input) {
        Lancamento lancamento = new Lancamento();

        lancamento.setTipoLancamento(input.getTipoLancamento());
        lancamento.setValor(input.getValor());

        lancamento.setDtCriacao(LocalDateTime.now());
        lancamento.setParcelas(input.getParcelas());

        // Procura por qualquer conta parecida com o input
        lancamento.setConta(contaGetter.getContaByFilter(input.getConta()));

        lancamento.setDescricao(input.getDescricao());

        lancamento = repository.save(lancamento);

        transacaoCreator.criarTransacoes(lancamento);

        return repository.save(lancamento);
    }

}
