package com.biofarma.api.dto;

import java.time.LocalDateTime;

import com.biofarma.api.model.Orcamento;
import com.biofarma.api.model.StatusOrcamento;

public record OrcamentoResponse(
        Long id,
        String nomeCliente,
        String telefone,
        String descricao,
        StatusOrcamento status,
        LocalDateTime criadoEm
) {

    public static OrcamentoResponse from(Orcamento orcamento) {
        return new OrcamentoResponse(
                orcamento.getId(),
                orcamento.getNomeCliente(),
                orcamento.getTelefone(),
                orcamento.getDescricao(),
                orcamento.getStatus(),
                orcamento.getCriadoEm()
        );
    }
}