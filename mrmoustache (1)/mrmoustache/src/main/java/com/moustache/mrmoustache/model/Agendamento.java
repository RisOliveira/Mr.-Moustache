package com.moustache.mrmoustache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Uma entidade cuja o nome da tabela será "age_agendamento"
@Entity
@Table(name = "age_agendamento") 
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age_data_hora", nullable = false, length = 50)
    private String dataHora;

    @Column(name = "age_cliente_id", nullable = false)
    private Long clienteId;

    @Column(name = "age_corte_id", nullable = false)
    private Long corteId;

    @Column(name = "age_barbearia_id", nullable = false)
    private Long barbeariaId;

    @Column(name = "age_status", nullable = false, length = 20)
    private String status;

    // Construtor vazio
    public Agendamento() {}

    // Construtor completo
    public Agendamento(String dataHora, Long clienteId, Long corteId, Long barbeariaId, String status) {
        this.dataHora = dataHora;
        this.clienteId = clienteId;
        this.corteId = corteId;
        this.barbeariaId = barbeariaId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getCorteId() {
        return corteId;
    }

    public void setCorteId(Long corteId) {
        this.corteId = corteId;
    }

    public Long getBarbeariaId() {
        return barbeariaId;
    }

    public void setBarbeariaId(Long barbeariaId) {
        this.barbeariaId = barbeariaId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
