package com.example.petservices.Controller;

import com.example.petservices.Models.Vacina;
import com.example.petservices.Service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {
    @Autowired
    private VacinaService vacinaService;

    @PostMapping
    public Vacina salvarVacina(@RequestBody Vacina vacina) {
        return vacinaService.salvarVacina(vacina);
    }

    @GetMapping
    public List<Vacina> listarVacinas() {
        return vacinaService.listarVacinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable Long id) {
        return vacinaService.obterVacinaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarVacina(@PathVariable Long id) {
        vacinaService.deletarVacina(id);
    }
}

