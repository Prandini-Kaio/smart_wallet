package br.prandini.smartwallet.conta.repository;

import br.prandini.smartwallet.conta.domain.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author prandini
 * created 4/5/24
 */
@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean findByNomeAndBanco(String nome, String banco);
}
