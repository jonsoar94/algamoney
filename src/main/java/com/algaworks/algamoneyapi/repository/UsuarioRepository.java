package com.algaworks.algamoneyapi.repository;

import java.util.Optional;

import com.algaworks.algamoneyapi.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByEmail(String email);
    
}