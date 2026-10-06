package com.biofarma.api.dto;

import java.util.List;

public record InfoFarmacia(
        String nome,
        String endereco,
        List<String> telefones,
        String horario,
        String linkWhatsapp
) {
}