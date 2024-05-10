package br.prandini.smartwallet.transacao.repository;

import br.prandini.smartwallet.transacao.domain.Transacao;
import br.prandini.smartwallet.transacao.domain.TransacaoFilter;
import br.prandini.smartwallet.transacao.domain.TransacaoStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long>, TransacaoRepositoryCustom {

    @Query("SELECT t FROM Transacao t WHERE MONTH(t.dtVencimento) = :month")
    List<Transacao> findByVencimento(Integer month);

    @Query("SELECT t FROM Transacao t JOIN t.lancamento l JOIN l.conta c WHERE lower(c.banco) LIKE CONCAT('%', LOWER(:filter),'%') OR l.descricao LIKE CONCAT('%', LOWER(:filter), '%') OR c.nome LIKE CONCAT('%', LOWER(:filter), '%')")
    List<Transacao> findByStringFilter(String filter);

    @Query("SELECT t FROM Transacao t  WHERE t.status = :status AND MONTH(t.dtVencimento) = :month")
    List<Transacao> findByFilter(TransacaoStatusEnum status, Integer month);
}
