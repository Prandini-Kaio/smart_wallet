package br.prandini.smartwallet.totalizador;

/*
 * @author prandini
 * created 5/10/24
 */

import br.prandini.smartwallet.totalizador.model.TotalizadorBalancoOutput;
import br.prandini.smartwallet.totalizador.service.TotalizadorService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/${base.path}/totalizador")
public class TotalizadorController {

    @Resource
    private TotalizadorService service;

    @GetMapping("/balanco")
    public ResponseEntity<TotalizadorBalancoOutput> getTotalizadorBalanco(){
        return ResponseEntity.ok().body(service.getBalanco());
    }

    @GetMapping("/balanco/{conta}")
    public ResponseEntity<TotalizadorBalancoOutput> getTotalizadorBalancoByConta(String conta){
        return ResponseEntity.ok().body(service.getBalancoByConta(conta));
    }
}
