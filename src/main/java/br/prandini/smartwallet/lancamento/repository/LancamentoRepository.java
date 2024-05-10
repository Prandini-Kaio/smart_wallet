package br.prandini.smartwallet.lancamento.repository;


import br.prandini.smartwallet.lancamento.domain.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryCustom {

    @Query("SELECT l FROM Lancamento l WHERE MONTH(l.dtCriacao) = :mes")
    List<Lancamento> findByDtCriacao(Integer mes);
}
