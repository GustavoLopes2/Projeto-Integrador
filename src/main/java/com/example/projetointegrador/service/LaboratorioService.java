package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Laboratorio;

import java.util.List;

public interface LaboratorioService {

    Laboratorio salvar(Laboratorio laboratorio);

    Laboratorio editar(Laboratorio laboratorio);

    List<Laboratorio> listar ();

    void deletar(Long id);
}
