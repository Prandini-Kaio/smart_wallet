package br.prandini.smartwallet.conta.controller;

/*
 * @author prandini
 * created 4/5/24
 */

import br.prandini.smartwallet.conta.domain.dto.ContaInput;
import br.prandini.smartwallet.conta.domain.dto.ContaOutput;
import br.prandini.smartwallet.conta.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${base.path}/conta")
public class ContaController {

    @Resource
    private ContaService service;

    @GetMapping
    @Operation(summary = "Retorna todas as contas.")
    public ResponseEntity<Page<ContaOutput>> findAll(Pageable pageable){
        return ResponseEntity.ok().body(service.getAll(pageable));
    }

    @PostMapping
    @Operation(summary = "Cria uma conta")
    public ResponseEntity<ContaOutput> create(@RequestBody ContaInput input){
        return ResponseEntity.ok().body(service.create(input));
    }
}
