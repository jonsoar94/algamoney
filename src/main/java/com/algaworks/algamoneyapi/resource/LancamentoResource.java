package com.algaworks.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.algaworks.algamoneyapi.event.RecursoCriadoEvent;
import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.service.LancamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
    
    @Autowired
    private LancamentoService LancamentoService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public List<Lancamento> listar() {
        return LancamentoService.listar();
    }

    @GetMapping("/{codigo}")
    public Lancamento buscar(@PathVariable Long codigo) {
        return LancamentoService.buscarPorId(codigo);
    }

    @PostMapping
    public Lancamento criar(@RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalvo =  LancamentoService.criar(lancamento);
        applicationEventPublisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return lancamentoSalvo;
    }
}