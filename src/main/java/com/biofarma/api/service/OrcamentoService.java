package com.biofarma.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.biofarma.api.dto.OrcamentoCriadoResponse;
import com.biofarma.api.dto.OrcamentoRequest;
import com.biofarma.api.dto.OrcamentoResponse;
import com.biofarma.api.model.Orcamento;
import com.biofarma.api.repository.OrcamentoRepository;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;
    private final WhatsappService whatsappService;

    public OrcamentoService(OrcamentoRepository orcamentoRepository, WhatsappService whatsappService) {
        this.orcamentoRepository = orcamentoRepository;
        this.whatsappService = whatsappService;
    }

    public OrcamentoCriadoResponse criar(OrcamentoRequest request) {
        Orcamento orcamento = new Orcamento(request.nomeCliente(), request.telefone(), request.descricao());
        Orcamento salvo = orcamentoRepository.save(orcamento);
        String linkWhatsapp = whatsappService.gerarLink(montarMensagem(salvo));
        return new OrcamentoCriadoResponse(salvo.getId(), linkWhatsapp);
    }

    public List<OrcamentoResponse> listar() {
        List<OrcamentoResponse> resposta = new ArrayList<>();
        for (Orcamento orcamento : orcamentoRepository.findAllByOrderByCriadoEmDesc()) {
            resposta.add(OrcamentoResponse.from(orcamento));
        }
        return resposta;
    }

    public OrcamentoResponse buscarPorId(Long id) {
        return OrcamentoResponse.from(buscarEntidade(id));
    }

    private Orcamento buscarEntidade(Long id) {
        Optional<Orcamento> encontrado = orcamentoRepository.findById(id);
        if (encontrado.isPresent()) {
            return encontrado.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orçamento " + id + " não encontrado");
        }
    }

    private String montarMensagem(Orcamento orcamento) {
        return "Olá! Acabei de pedir um orçamento pelo site (pedido #" + orcamento.getId() + ").\n"
                + "Nome: " + orcamento.getNomeCliente() + "\n"
                + "O que preciso: " + orcamento.getDescricao();
    }
}