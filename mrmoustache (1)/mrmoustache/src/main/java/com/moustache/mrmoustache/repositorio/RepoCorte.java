package com.moustache.mrmoustache.repositorio;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moustache.mrmoustache.model.Corte;

public interface RepoCorte extends JpaRepository<Corte, Long> {
    
    boolean existsById(Long id);
    boolean existsByNome(String nome);

    Optional<Corte> findByIdBarbearia(Long idBarbearia);
    Optional<Corte> findByNome(String nome);
    
}
