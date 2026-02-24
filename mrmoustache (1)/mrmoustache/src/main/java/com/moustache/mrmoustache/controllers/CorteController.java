package com.moustache.mrmoustache.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moustache.mrmoustache.model.Corte;
import com.moustache.mrmoustache.services.CorteServices;

@RestController
@RequestMapping("/api/cortes")
public class CorteController {
    
        private final CorteServices corteServices;

    public CorteController(CorteServices corteServices) {
        this.corteServices = corteServices;
    }

    @GetMapping("/listarcortes")
    public ResponseEntity<List<Corte>> listarCortes() {
        List<Corte> primeiros = corteServices.listarPrimeiros(9);
        return new ResponseEntity<>(primeiros, HttpStatus.OK);
    }

    // GET /api/cortes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Corte> getCorteById(@PathVariable Long id) {
        Optional<Corte> opt = corteServices.findById(id);
        return opt.map(corte -> new ResponseEntity<>(corte, HttpStatus.OK))
                  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET /api/cortes/{id}
    @GetMapping("/barbearias/{idBarbearia}")
    public ResponseEntity<Corte> getCorteByIdBar(@PathVariable Long idBarbearia) {
        Optional<Corte> opt = corteServices.findByIdBar(idBarbearia);
        return opt.map(corte -> new ResponseEntity<>(corte, HttpStatus.OK))
                  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST /api/cortes
    // Corpo: Corte (todos os campos do modelo Corte)
    @PostMapping
    public ResponseEntity<Corte> criarCorte(@Valid @RequestBody Corte corte) {
        Corte salvo = corteServices.save(corte);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

}
