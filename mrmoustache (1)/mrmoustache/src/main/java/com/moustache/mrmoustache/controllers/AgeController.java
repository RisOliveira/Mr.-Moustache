package com.moustache.mrmoustache.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moustache.mrmoustache.model.Agendamento;
import com.moustache.mrmoustache.services.AgeServices;

@RestController
@RequestMapping("/api/ages")
public class AgeController {
    
    private final AgeServices ageServices;

    public AgeController(AgeServices ageServices) {
        this.ageServices = ageServices;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Agendamento>> listarAges() {
        List<Agendamento> primeiros = ageServices.listarPrimeiros(9);
        return new ResponseEntity<>(primeiros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarAgePorId(@PathVariable Long id) {
        return ageServices.findById(id)
                   .map(age -> new ResponseEntity<>(age, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
public ResponseEntity<Agendamento> create(@RequestBody Agendamento agendamento) {
    return ResponseEntity.status(HttpStatus.CREATED).body(ageServices.save(agendamento));
}

@PutMapping("/{id}")
public ResponseEntity<Agendamento> update(@PathVariable Long id, @RequestBody Agendamento agendamento) {
    return ResponseEntity.ok(ageServices.update(id, agendamento));
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
    ageServices.delete(id);
    return ResponseEntity.noContent().build();
}
}
