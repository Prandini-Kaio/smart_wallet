package br.prandini.smartwallet.transacao.repository;

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.TransacaoFilter;

import java.util.List;

public interface TransacaoRepositoryCustom {

    List<Transacao> findByFilter(TransacaoFilter filter);
}
