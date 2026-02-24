package com.moustache.mrmoustache.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moustache.mrmoustache.model.Agendamento;
import com.moustache.mrmoustache.repositorio.RepoAge;


@Service
public class AgeServices {
    
    private final RepoAge repoAge;

    public AgeServices(RepoAge repoAge) {
        this.repoAge = repoAge;
    }

    // Retorna os primeiros N agendamentos usando PageRequest para eficiência
    public List<Agendamento> listarPrimeiros(int quantidade) {
        return repoAge.findAll(PageRequest.of(0, quantidade)).getContent();
    }

    public Optional<Agendamento> findById(Long id) {
        return repoAge.findById(id);
    }

    public Agendamento save(Agendamento agendamento) {
        return repoAge.save(agendamento);
    }

    public Agendamento update(Long id, Agendamento agendamento) {
        return repoAge.findById(id).map(existing -> {
            agendamento.setId(id);
            return repoAge.save(agendamento);
        }).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
    }

    public void delete(Long id) {
        repoAge.deleteById(id);
    }

    public List<Agendamento> listarTodos() {
        return repoAge.findAll();
    }
}