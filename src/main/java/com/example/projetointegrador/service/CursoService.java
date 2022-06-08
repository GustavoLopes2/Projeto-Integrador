package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Curso;

import java.util.List;

public interface CursoService {

    Curso salvar(Curso curso) throws Exception;

    Curso editar(Curso curso);

    List<Curso> listar();

    void deletar(Long id);
}
