package com.moustache.mrmoustache.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

// Uma entidade cuja o nome da tabela será "bar_corte"
@Entity
@Table(name = "bar_corte")
public class Corte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cor_id")
	private Long id;

	@NotBlank(message = "O nome do corte não pode estar em branco.")
	@Size(min = 2, max = 100)
	@Column(name = "cor_nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "cor_preco")
	private Double preco;

	@NotNull(message = "A duração é obrigatória (em minutos).")
	@Column(name = "cor_duracao", nullable = false)
	private Integer duracao; // minutos

	@Size(max = 500)
	@Column(name = "cor_descricao", length = 500)
	private String descricao;

	@Size(max = 255)
	@Column(name = "cor_img", length = 255)
	private String imagem;

	@NotNull(message = "O id da barbearia é obrigatório.")
	@Column(name = "cor_id_barbearia", nullable = false)
	private Long idBarbearia;

	// Construtor vazio
	public Corte() {}

	// Construtor completo
	public Corte(String nome, Double preco, Integer duracao, String descricao, String imagem, Long idBarbearia) {
		this.nome = nome;
		this.preco = preco;
		this.duracao = duracao;
		this.descricao = descricao;
		this.imagem = imagem;
		this.idBarbearia = idBarbearia;
	}

	// Getters / Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public Double getPreco() { return preco; }
	public void setPreco(Double preco) { this.preco = preco; }

	public Integer getDuracao() { return duracao; }
	public void setDuracao(Integer duracao) { this.duracao = duracao; }

	public String getDescricao() { return descricao; }
	public void setDescricao(String descricao) { this.descricao = descricao; }

	public String getImagem() { return imagem; }
	public void setImagem(String imagem) { this.imagem = imagem; }

	public Long getIdBarbearia() { return idBarbearia; }
	public void setIdBarbearia(Long idBarbearia) { this.idBarbearia = idBarbearia; }
}
