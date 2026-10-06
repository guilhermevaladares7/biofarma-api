package com.biofarma.api.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsappService {

    private static final String MENSAGEM_PADRAO = "Olá! Vim pelo site da Biofarma e gostaria de mais informações.";

    private final String numero;

    public WhatsappService(@Value("${biofarma.whatsapp.numero}") String numero) {
        this.numero = numero;
    }

    public String gerarLink(String mensagem) {
        String texto;
        if (mensagem == null || mensagem.isBlank()) {
            texto = MENSAGEM_PADRAO;
        } else {
            texto = mensagem;
        }
        String textoCodificado = URLEncoder.encode(texto, StandardCharsets.UTF_8).replace("+", "%20");
        return "https://wa.me/" + numero + "?text=" + textoCodificado;
    }
}