package br.prandini.smartwallet.totalizador.service;

/*
 * @author prandini
 * created 5/10/24
 */

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.TipoLancamentoEnum;
import br.prandini.smartwallet.lancamento.repository.LancamentoRepository;
import br.prandini.smartwallet.lancamento.service.actions.LancamentoGetter;
import br.prandini.smartwallet.totalizador.model.TotalizadorBalancoOutput;
import br.prandini.smartwallet.totalizador.service.actions.TotalizadorGetter;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TotalizadorService {

    @Resource
    private LancamentoGetter lancamentoGetter;

    @Resource
    private TotalizadorGetter getter;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public TotalizadorBalancoOutput getBalanco() {
        return getter.getBalanco();
    }

    public TotalizadorBalancoOutput getBalancoByConta(String conta) {
        return getter.getBalancoPorConta(conta);
    }

}
