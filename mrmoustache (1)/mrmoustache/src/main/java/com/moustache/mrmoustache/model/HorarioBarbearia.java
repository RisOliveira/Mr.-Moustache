package com.moustache.mrmoustache.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// Uma entidade cuja o nome da tabela será "bar_horario_barbearia"
@Entity
@Table(name = "bar_horario_barbearia")
public class HorarioBarbearia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hor_id")
	private Long id;

	@NotNull(message = "O ID da barbearia não pode ser nulo.")
	@Column(name = "hor_id_barbearia", nullable = false)
	private Long idBarbearia;

	@NotNull(message = "O dia da semana não pode ser nulo.")
	@Enumerated(EnumType.STRING)
	@Column(name = "hor_dia_semana", nullable = false, length = 15)
	private DiaSemana diaSemana;

	@NotNull(message = "A hora de início não pode ser nula.")
	@Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "A hora de início deve estar no formato HH:mm")
	@Column(name = "hor_hora_inicio", length = 5)
	private String horaInicio;

	@NotNull(message = "A hora de fim não pode ser nula.")
	@Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$", message = "A hora de fim deve estar no formato HH:mm")
	@Column(name = "hor_hora_fim", length = 5)
	private String horaFim;

	// Construtor vazio
	public HorarioBarbearia() {}

	// Construtor completo
	public HorarioBarbearia(Long idBarbearia, DiaSemana diaSemana, String horaInicio, String horaFim) {
		this.idBarbearia = idBarbearia;
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	// Getters e Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Long getIdBarbearia() { return idBarbearia; }
	public void setIdBarbearia(Long idBarbearia) { this.idBarbearia = idBarbearia; }

	public DiaSemana getDiaSemana() { return diaSemana; }
	public void setDiaSemana(DiaSemana diaSemana) { this.diaSemana = diaSemana; }

	public String getHoraInicio() { return horaInicio; }
	public void setHoraInicio(String horaInicio) { this.horaInicio = horaInicio; }

	public String getHoraFim() { return horaFim; }
	public void setHoraFim(String horaFim) { this.horaFim = horaFim; }
}
