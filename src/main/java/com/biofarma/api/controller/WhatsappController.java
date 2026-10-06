package com.biofarma.api.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biofarma.api.service.WhatsappService;

@RestController
@RequestMapping("/api/whatsapp")
public class WhatsappController {

    private final WhatsappService whatsappService;

    public WhatsappController(WhatsappService whatsappService) {
        this.whatsappService = whatsappService;
    }

    @GetMapping
    public ResponseEntity<Void> abrir(@RequestParam(required = false) String mensagem) {
        String link = whatsappService.gerarLink(mensagem);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link)).build();
    }
}
