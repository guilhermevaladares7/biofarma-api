package com.biofarma.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record OrcamentoRequest(
        @NotBlank(message = "Informe seu nome")
        @Size(max = 100, message = "O nome pode ter no máximo 100 caracteres")
        String nomeCliente,

        @NotBlank(message = "Informe seu telefone")
        @Pattern(regexp = "\\d{10,11}", message = "Telefone com DDD, só números")
        String telefone,

        @NotBlank(message = "Descreva o que você precisa manipular")
        @Size(max = 1000, message = "A descrição pode ter no máximo 1000 caracteres")
        String descricao
) {
}