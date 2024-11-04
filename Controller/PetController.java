package com.example.petservices.Controller;

import com.example.petservices.Models.Pet;
import com.example.petservices.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    // Método corrigido para chamar salvarPet corretamente
    @PostMapping
    public Pet salvarPet(@RequestBody Pet pet) {
        return petService.salvarPet(pet);
    }

    // Método para listar todos os Pets
    @GetMapping
    public List<Pet> listarPets() {
        return petService.listarPets();
    }

    // Método para obter um Pet por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> obterPetPorId(@PathVariable Long id) {
        return petService.obterPetPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Método para deletar um Pet pelo ID
    @DeleteMapping("/{id}")
    public void deletarPet(@PathVariable Long id) {
        petService.deletarPet(id);
    }
}

