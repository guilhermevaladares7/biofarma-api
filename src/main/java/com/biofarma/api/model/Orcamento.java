package com.biofarma.api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamentos")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nomeCliente;

    @Column(nullable = false, length = 11)
    private String telefone;

    @Column(nullable = false, length = 1000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusOrcamento status;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    protected Orcamento() {
    }

    public Orcamento(String nomeCliente, String telefone, String descricao) {
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.descricao = descricao;
        this.status = StatusOrcamento.NOVO;
        this.criadoEm = LocalDateTime.now();
    }

    public void alterarStatus(StatusOrcamento novoStatus) {
        this.status = novoStatus;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public StatusOrcamento getStatus() {
        return status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}