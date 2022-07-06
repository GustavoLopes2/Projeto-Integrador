package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Instrutor;

import java.util.List;

public interface InstrutorService {

    Instrutor salvar (Instrutor instrutor) throws Exception;

    Instrutor editar (Instrutor instrutor);

    List<Instrutor> listar();

    void deletar(Long id);

    Instrutor buscarInstrutorPorEmail(Instrutor instrutor) throws Exception;
}
