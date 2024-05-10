package br.prandini.smartwallet.lancamento.service.actions;

/*
 * @author prandini
 * created 5/10/24
 */

import br.prandini.smartwallet.lancamento.domain.Lancamento;
import br.prandini.smartwallet.lancamento.repository.LancamentoRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.nio.channels.FileChannel;
import java.util.List;

@Component
public class LancamentoGetter {

    @Resource
    private LancamentoRepository repository;

    public Page<Lancamento> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Lancamento> getListAll(){
        return repository.findAll();
    }
}
