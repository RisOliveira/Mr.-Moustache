package com.moustache.mrmoustache.controllers;

import java.util.List;
import java.util.Optional;

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

import com.moustache.mrmoustache.model.Cliente;
import com.moustache.mrmoustache.services.ClienteServices;

@RestController // Anotação que define esta classe como um controller REST
@RequestMapping("/api/clientes") // Define o caminho base para todos os endpoints nesta classe
public class ClienteController {

    private final ClienteServices clienteServices;

    // Injeta a camada de serviço que criamos
    public ClienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    // Endpoint para CADASTRAR um novo cliente
    // URL: POST http://localhost:8080/api/clientes
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteServices.salvar(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // Endpoint para BUSCAR um cliente pelo ID
    // URL: GET http://localhost:8080/api/clientes/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteServices.findById(id)
                   .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/login")
public ResponseEntity<Long> loginCliente(@RequestBody Cliente cliente) {

    Optional<Cliente> encontradoOpt = Optional.of(clienteServices.findByEmailAndSenha(
            cliente.getEmail(),
            cliente.getSenha()
    ));

    if (encontradoOpt.isPresent()) {
        return ResponseEntity.ok(encontradoOpt.get().getId());
    }

    return ResponseEntity.ok(0L);
}


    

    // Endpoint para ATUALIZAR um cliente existente
    // URL: PUT http://localhost:8080/api/clientes/1
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizado = clienteServices.update(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }

    // Endpoint para DELETAR um cliente
    // URL: DELETE http://localhost:8080/api/clientes/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clienteServices.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna sucesso sem corpo na resposta
    }

    // Endpoint de exemplo: retorna os 5 primeiros clientes presentes no banco de dados
    // URL: GET http://localhost:8080/api/clientes/lista5
    @GetMapping("/lista5")
    public ResponseEntity<List<Cliente>> listarCincoClientes() {
        List<Cliente> primeiros = clienteServices.listarPrimeiros(4);
        return new ResponseEntity<>(primeiros, HttpStatus.OK);
    }

}

