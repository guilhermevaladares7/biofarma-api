package com.biofarma.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biofarma.api.dto.OrcamentoCriadoResponse;
import com.biofarma.api.dto.OrcamentoRequest;
import com.biofarma.api.dto.OrcamentoResponse;
import com.biofarma.api.service.OrcamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    public ResponseEntity<OrcamentoCriadoResponse> criar(@RequestBody @Valid OrcamentoRequest request) {
        OrcamentoCriadoResponse criado = orcamentoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @GetMapping
    public List<OrcamentoResponse> listar() {
        return orcamentoService.listar();
    }

    @GetMapping("/{id}")
    public OrcamentoResponse buscarPorId(@PathVariable Long id) {
        return orcamentoService.buscarPorId(id);
    }
}