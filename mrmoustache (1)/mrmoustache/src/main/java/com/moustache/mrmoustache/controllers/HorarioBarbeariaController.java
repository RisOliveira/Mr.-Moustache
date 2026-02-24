package com.moustache.mrmoustache.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.moustache.mrmoustache.model.HorarioBarbearia;
import com.moustache.mrmoustache.services.HorarioBarbeariaService;

@RestController
@RequestMapping("/api/horarios")
public class HorarioBarbeariaController {

	private final HorarioBarbeariaService horarioService;

	public HorarioBarbeariaController(HorarioBarbeariaService horarioService) {
		this.horarioService = horarioService;
	}

	// POST /api/horarios
	// Corpo: HorarioBarbearia (idBarbearia, diaSemana, horaInicio, horaFim)
	@PostMapping
	public ResponseEntity<HorarioBarbearia> criarHorario(@Valid @RequestBody HorarioBarbearia horario) {
		HorarioBarbearia criado = horarioService.save(horario);
		return new ResponseEntity<>(criado, HttpStatus.CREATED);
	}

	// GET /api/horarios/{id} - obter um horário por seu id
	@GetMapping("/{id}")
	public ResponseEntity<HorarioBarbearia> getHorarioById(@PathVariable Long id) {
		Optional<HorarioBarbearia> opt = horarioService.findById(id);
		return opt.map(h -> new ResponseEntity<>(h, HttpStatus.OK))
				  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// GET /api/horarios/barbearia/{idBarbearia} - listar horários de uma barbearia
	@GetMapping("/barbearia/{idBarbearia}")
	public ResponseEntity<List<HorarioBarbearia>> getHorariosByBarbearia(@PathVariable Long idBarbearia) {
		List<HorarioBarbearia> lista = horarioService.findByIdBarbearia(idBarbearia);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
