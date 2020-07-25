package com.algaworks.algamoneyapi.service;

import java.util.List;
import java.util.Optional;

import com.algaworks.algamoneyapi.exception.PessoaInexistenteOuInativaException;
import com.algaworks.algamoneyapi.model.Lancamento;
import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.LancamentoRepository;
import com.algaworks.algamoneyapi.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
    
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    public Lancamento buscarPorId(Long codigo) {
        return lancamentoRepository.findById(codigo)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

	public Lancamento criar(Lancamento lancamento) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
        if (!pessoa.isPresent() || pessoa.get().isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

		return lancamentoRepository.save(lancamento);
	}
}