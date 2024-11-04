package com.example.petservices.Controller;

import com.example.petservices.Models.Localizacao;
import com.example.petservices.Service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacoes")
public class LocalizacaoController {
    @Autowired
    private LocalizacaoService localizacaoService;

    @PostMapping
    public Localizacao salvarLocalizacao(@RequestBody Localizacao localizacao) {
        return localizacaoService.salvarLocalizacao(localizacao);
    }

    @GetMapping
    public List<Localizacao> listarLocalizacoes() {
        return localizacaoService.listarLocalizacoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> obterLocalizacaoPorId(@PathVariable Long id) {
        return localizacaoService.obterLocalizacaoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarLocalizacao(@PathVariable Long id) {
        localizacaoService.deletarLocalizacao(id);
    }
}

