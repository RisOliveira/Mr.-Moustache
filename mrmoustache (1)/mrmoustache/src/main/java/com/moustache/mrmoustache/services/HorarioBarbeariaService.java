package com.moustache.mrmoustache.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.moustache.mrmoustache.model.HorarioBarbearia;
import com.moustache.mrmoustache.repositorio.RepoHorarioBarbearia;

@Service
public class HorarioBarbeariaService {

	private final RepoHorarioBarbearia repo;

	public HorarioBarbeariaService(RepoHorarioBarbearia repo) {
		this.repo = repo;
	}

	public HorarioBarbearia save(HorarioBarbearia horario) {
		return repo.save(horario);
	}

	public Optional<HorarioBarbearia> findById(Long id) {
		return repo.findById(id);
	}

	public List<HorarioBarbearia> findByIdBarbearia(Long idBarbearia) {
		return repo.findByIdBarbearia(idBarbearia);
	}
}
