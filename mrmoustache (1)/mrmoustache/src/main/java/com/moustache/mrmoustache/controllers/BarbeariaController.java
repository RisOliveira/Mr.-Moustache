package com.moustache.mrmoustache.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.moustache.mrmoustache.model.Barbearia;
import com.moustache.mrmoustache.services.BarbeariaServices;

@RestController
@RequestMapping("/api/barbearias")
public class BarbeariaController {
    
    private final BarbeariaServices barbService;

    public BarbeariaController(BarbeariaServices barbService) {
        this.barbService = barbService;
    }

    // Endpoint para listar as 3 primeiras barbearias
    // Cada Barbearia contém: id, nome, cep, endereco, imagem, email, nomeBarbeiro
    // URL: GET http://localhost:8080/api/barbearias/lista3
    @GetMapping("/lista3")
    public ResponseEntity<List<Barbearia>> listarTresBarbearias() {
        List<Barbearia> primeiros = barbService.listarPrimeiros(3);
        return new ResponseEntity<>(primeiros, HttpStatus.OK);
    }

    // Endpoint para buscar uma barbearia pelo ID
    // Retorna 200 com a Barbearia completa ou 404 se não existir
    // URL: GET http://localhost:8080/api/barbearias/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Barbearia> buscarBarbeariaById(@PathVariable Long id) {
        Optional<Barbearia> opt = barbService.findById(id);
        return opt
                .map(barbearia -> new ResponseEntity<>(barbearia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
public ResponseEntity<Long> loginBarbearia(@RequestBody Barbearia barbearia) {

    Barbearia encontrada = barbService.findByEmailAndSenha(
            barbearia.getEmail(),
            barbearia.getSenha()
    );

    if (encontrada != null) {
        return ResponseEntity.ok(encontrada.getId());
    }

    return ResponseEntity.ok(0L);
}


    // GET /api/barbearias/nome/{nome}
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Barbearia> buscarBarbeariaByNome(@PathVariable String nome) {
        Optional<Barbearia> opt = barbService.findByNome(nome);
        return opt
                .map(barbearia -> new ResponseEntity<>(barbearia, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para criar uma nova barbearia
    // Requer: nome, cep, endereco, imagem, email, nomeBarbeiro, senha
    // URL: POST http://localhost:8080/api/barbearias
    @PostMapping
    public ResponseEntity<Barbearia> criarBarbearia(@Valid @RequestBody Barbearia barbearia) {
        Barbearia criada = barbService.save(barbearia);
        return new ResponseEntity<>(criada, HttpStatus.CREATED);
    }
    
}
