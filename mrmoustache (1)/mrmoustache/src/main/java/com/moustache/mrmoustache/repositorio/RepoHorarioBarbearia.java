package com.moustache.mrmoustache.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moustache.mrmoustache.model.HorarioBarbearia;

public interface RepoHorarioBarbearia extends JpaRepository<HorarioBarbearia, Long> {
	// Lista todos os horários de uma barbearia
	List<HorarioBarbearia> findByIdBarbearia(Long idBarbearia);
}
