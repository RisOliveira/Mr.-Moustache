package com.moustache.mrmoustache.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moustache.mrmoustache.model.Agendamento;

public interface RepoAge extends JpaRepository<Agendamento, Long> {

        boolean existsById(Long id);

        Optional<Agendamento> findById(Long id);
}
