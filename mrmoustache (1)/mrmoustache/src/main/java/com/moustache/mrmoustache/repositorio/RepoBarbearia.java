package com.moustache.mrmoustache.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moustache.mrmoustache.model.Barbearia;

public interface RepoBarbearia extends JpaRepository<Barbearia, Long> {
    
        // Métodos essenciais para as validações no Service
    boolean existsById(Long id);
    boolean existsByNome(String nome);
    boolean existsByEmail(String email);

    // Métodos para buscar um cliente (útil para o update e login futuro)
    Optional<Barbearia> findById(Long id);
    Optional<Barbearia> findByNome(String nome);
    Optional<Barbearia> findByEmail(String email);
    Optional<Barbearia> findByEmailAndSenha(String email, String senha);

}
