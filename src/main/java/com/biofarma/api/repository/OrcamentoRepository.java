package com.biofarma.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biofarma.api.model.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    List<Orcamento> findAllByOrderByCriadoEmDesc();
}