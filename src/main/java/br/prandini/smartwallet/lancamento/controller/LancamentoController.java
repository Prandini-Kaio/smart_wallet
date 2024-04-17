package br.prandini.smartwallet.lancamento.controller;

/*
 * @author prandini
 * created 4/16/24
 */

import br.prandini.smartwallet.lancamento.domain.dto.LancamentoInputDTO;
import br.prandini.smartwallet.lancamento.domain.dto.LancamentoOutput;
import br.prandini.smartwallet.lancamento.service.LancamentoService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${base.path}/lancamento")
public class LancamentoController {

    @Resource
    private LancamentoService service;

    @GetMapping
    public ResponseEntity<Page<LancamentoOutput>> searchAll(Pageable pageable){
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<LancamentoOutput> criarLancamento(@RequestBody @Valid LancamentoInputDTO input){
        return ResponseEntity.ok().body(service.criarLancamento(input));
    }
}
