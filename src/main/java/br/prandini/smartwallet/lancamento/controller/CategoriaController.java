package br.prandini.smartwallet.lancamento.controller;

/*
 * @author prandini
 * created 5/3/24
 */

import br.prandini.smartwallet.lancamento.domain.CategoriaLancamentoEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/${base.path}/lancamento/categoria")
public class CategoriaController {

    @GetMapping
    public ResponseEntity<List<CategoriaLancamentoEnum>> getAll(){
        return ResponseEntity.ok().body(List.of(CategoriaLancamentoEnum.values()));
    }
}
