package br.prandini.smartwallet.transacao.controller;

import br.prandini.smartwallet.transacao.converter.TransacaoConverter;
import br.prandini.smartwallet.transacao.domain.dto.TransacaoOutput;
import br.prandini.smartwallet.transacao.repository.TransacaoRepository;
import br.prandini.smartwallet.transacao.service.TransacaoService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author prandini
 * created 4/17/24
 */
@RestController
@RequestMapping("/${base.path}/transacao")
public class TransacaoController {

    @Resource
    private TransacaoService service;

    @Resource
    private TransacaoRepository repository;

    @GetMapping
    public ResponseEntity<Page<TransacaoOutput>> searchAll(Pageable pageable){
        return ResponseEntity.ok().body(
                repository.findAll(pageable).map(TransacaoConverter::toOutput)
        );
    }

    @GetMapping("/filter")
    public ResponseEntity<Page<TransacaoOutput>> searchByFilter(@RequestParam String filter){
        return ResponseEntity.ok().body(service.findByFilter(filter));
    }
}
