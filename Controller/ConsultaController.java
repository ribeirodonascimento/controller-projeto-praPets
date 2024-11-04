package com.example.petservices.Controller;

import com.example.petservices.Models.Consulta;
import com.example.petservices.Service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public Consulta salvarConsulta(@RequestBody Consulta consulta) {
        return consultaService.salvarConsulta(consulta);
    }

    @GetMapping
    public List<Consulta> listarConsultas() {
        return consultaService.listarConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> obterConsultaPorId(@PathVariable Long id) {
        return consultaService.obterConsultaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
    }
}

