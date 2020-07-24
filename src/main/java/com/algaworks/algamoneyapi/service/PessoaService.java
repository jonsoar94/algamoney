package com.algaworks.algamoneyapi.service;

import java.util.Optional;

import com.algaworks.algamoneyapi.model.Pessoa;
import com.algaworks.algamoneyapi.repository.PessoaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    private Pessoa buscarPeloCodigo(Long codigo) {
        return pessoaRepository.findById(codigo)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public Pessoa atualizar(Pessoa pessoa, Long codigo) {
        Pessoa pessoaSalva = buscarPeloCodigo(codigo);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
        Pessoa pessoaSalva = buscarPeloCodigo(codigo);
        pessoaSalva.setAtivo(ativo);
        pessoaRepository.save(pessoaSalva);
	}
}