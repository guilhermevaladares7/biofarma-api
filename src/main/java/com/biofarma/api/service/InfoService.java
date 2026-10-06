package com.biofarma.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.biofarma.api.dto.InfoFarmacia;

@Service
public class InfoService {

    private final String nome;
    private final String endereco;
    private final List<String> telefones;
    private final String horario;
    private final WhatsappService whatsappService;

    public InfoService(
            @Value("${biofarma.nome}") String nome,
            @Value("${biofarma.endereco}") String endereco,
            @Value("${biofarma.telefones}") List<String> telefones,
            @Value("${biofarma.horario}") String horario,
            WhatsappService whatsappService) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefones = telefones;
        this.horario = horario;
        this.whatsappService = whatsappService;
    }

    public InfoFarmacia buscarInfo() {
        String linkWhatsapp = whatsappService.gerarLink(null);
        return new InfoFarmacia(nome, endereco, telefones, horario, linkWhatsapp);
    }
}