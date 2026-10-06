package com.biofarma.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biofarma.api.dto.InfoFarmacia;
import com.biofarma.api.service.InfoService;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public InfoFarmacia buscar() {
        return infoService.buscarInfo();
    }
}