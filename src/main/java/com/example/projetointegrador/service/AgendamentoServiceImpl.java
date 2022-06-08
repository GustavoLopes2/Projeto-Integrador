package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public Agendamento salvar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public Agendamento editar(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @Override
    public List<Agendamento> listar() {
        return agendamentoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }
}

