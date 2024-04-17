package br.prandini.smartwallet.lancamento.repository;


import br.prandini.smartwallet.lancamento.domain.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
