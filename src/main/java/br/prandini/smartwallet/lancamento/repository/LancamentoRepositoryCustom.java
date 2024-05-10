package br.prandini.smartwallet.lancamento.repository;

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryCustom {

    List<Lancamento> findByFilter(LancamentoFilter filter);
}
