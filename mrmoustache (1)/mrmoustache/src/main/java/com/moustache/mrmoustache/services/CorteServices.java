package com.moustache.mrmoustache.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moustache.mrmoustache.model.Corte;
import com.moustache.mrmoustache.repositorio.RepoCorte;

@Service
public class CorteServices {

	private final RepoCorte repo;

	public CorteServices(RepoCorte repo) {
		this.repo = repo;
	}

	// Retorna os primeiros N cortes
	public List<Corte> listarPrimeiros(int n) {
		return repo.findAll(PageRequest.of(0, n)).getContent();
	}

	// Salva um corte
	public Corte save(Corte corte) {
		return repo.save(corte);
	}

	// Busca por id
	public Optional<Corte> findById(Long id) {
		return repo.findById(id);
	}

    // Busca por id
	public Optional<Corte> findByIdBar(Long idBarbearia) {
		return repo.findById(idBarbearia);
	}

	// Busca por nome
	public Optional<Corte> findByNome(String nome) {
		return repo.findByNome(nome);
	}
}
