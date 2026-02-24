package com.moustache.mrmoustache.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

// Uma entidade cuja o nome da tabela será "bar_barbearia"
@Entity
@Table(name = "bar_barbearia")
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bar_id")
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres.")
    @Column(name="bar_nome", nullable = false, length = 30)
    private String nome;

    @NotBlank(message = "O CEP não pode estar em branco.")
    @Size(min = 8, max = 10, message = "O CEP deve ter entre 8 e 10 caracteres.")
    @Column(name = "bar_cep", nullable = false, length = 10)
    private String cep;

    @NotBlank(message = "O endereço não pode estar em branco.")
    @Size(min = 3, max = 255, message = "O endereço deve ter entre 3 e 255 caracteres.")
    @Column(name = "bar_end", nullable = false, length = 255)
    private String endereco;

    @Size(max = 255, message = "O endereço da imagem deve ter no máximo 255 caracteres.")
    @Column(name = "bar_img", length = 255)
    private String imagem;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O email deve ser válido.")
    @Column(name = "bar_email", nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank(message = "O nome do barbeiro não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O nome do barbeiro deve ter entre 3 e 50 caracteres.")
    @Column(name = "bar_nome_barbeiro", nullable = false, length = 50)
    private String nomeBarbeiro;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 6, max = 255, message = "A senha deve ter entre 6 e 255 caracteres.")
    @Column(name = "bar_senha", nullable = false, length = 255)
    private String senha;

    // Construtor vazio
    public Barbearia() {}

    // Construtor completo
    public Barbearia(String nome, String cep, String endereco, String imagem, String email, String nomeBarbeiro, String senha) {
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.imagem = imagem;
        this.email = email;
        this.nomeBarbeiro = nomeBarbeiro;
        this.senha = senha;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNomeBarbeiro() { return nomeBarbeiro; }
    public void setNomeBarbeiro(String nomeBarbeiro) { this.nomeBarbeiro = nomeBarbeiro; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
