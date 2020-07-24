package com.algaworks.algamoneyapi.service;

import java.util.List;

import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    
    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarPorId(Long codigo) {
        return lancamentoRepository.findById(codigo)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

	public Lancamento criar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}
}