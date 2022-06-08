package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{

    final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }


    @Override
    public Agendamento salvar(Agendamento agendamento) throws Exception {
        List<Agendamento> Horario = agendamentoRepository.findAgendamentoByHorarioInicio(agendamento.getHorarioInicio());
        List<Agendamento> Data = agendamentoRepository.findAgendamentoByDataInicio(agendamento.getDataInicio());


        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = formato.format(Data.get(0).getDataInicio());

        if (Horario != null && Horario.size() > 0) {
            throw new Exception("O horario " + agendamento.getHorarioInicio() + " já foi registrado.");
        }

        if (Data != null && Data.size() > 0) {
            throw new Exception("A data " + agendamento.getDataInicio() + " já foi registrada.");
            }

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

