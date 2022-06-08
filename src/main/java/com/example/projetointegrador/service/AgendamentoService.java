package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Agendamento;

import java.util.List;

public interface AgendamentoService {

    Agendamento salvar(Agendamento agendamento) throws Exception;

    Agendamento editar(Agendamento agendamento);

    List<Agendamento> listar();

    void deletar(Long id);
}
