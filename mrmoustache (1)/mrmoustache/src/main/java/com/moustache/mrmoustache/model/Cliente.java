// Pacote: com.Moustache.MrMoustache.model
package com.moustache.mrmoustache.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Uma entidade cuja o nome da tabela será "cli_cliente"
@Entity
@Table(name = "cli_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O e-mail não pode estar em branco.")
    @Email(message = "O formato do e-mail é inválido.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipocabelo")
    private TipoCabelo tipoCabelo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tiporosto")
    private TipoRosto tipoRosto;

    @NotBlank(message = "O CEP não pode estar em branco.")
    @Size(min = 8, max = 10, message = "O CEP deve ter entre 8 e 10 caracteres.")
    @Column(name = "cli_cep", nullable = false, length = 10)
    private String cep;

    // Construtor vazio (obrigatório pelo JPA)
    public Cliente() {}

    // Construtor completo com os tipos corretos (Enums)
    public Cliente(String nome, String email, String senha, TipoCabelo tipoCabelo, TipoRosto tipoRosto, String cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoCabelo = tipoCabelo;
        this.tipoRosto = tipoRosto;
        this.cep = cep;
    }

    // Getters e Setters com os tipos CORRETOS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public TipoCabelo getTipoCabelo() { return tipoCabelo; }
    public void setTipoCabelo(TipoCabelo tipoCabelo) { this.tipoCabelo = tipoCabelo; }

    public TipoRosto getTipoRosto() { return tipoRosto; }
    public void setTipoRosto(TipoRosto tipoRosto) { this.tipoRosto = tipoRosto; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
