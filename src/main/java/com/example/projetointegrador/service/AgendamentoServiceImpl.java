package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
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

        List<Agendamento> horarioInicio = agendamentoRepository.findAgendamentoByHorarioInicio(agendamento.getHorarioInicio());
        List<Agendamento> dataInicio = agendamentoRepository.findAgendamentoByDataInicio(agendamento.getDataInicio());
        List<Agendamento> dataFim = agendamentoRepository.findAgendamentoByDataFim(agendamento.getDataFim());
        List<Agendamento> horarioFim = agendamentoRepository.findAgendamentoByHorarioFim(agendamento.getHorarioFim());

        String[] horaInicio = agendamento.getHorarioInicio().split(":");
        String[] horaFim = agendamento.getHorarioFim().split(":");

        Integer horararioInicio = Integer.parseInt(horaInicio[0]);

        Integer horararioFim = Integer.parseInt(horaFim[0]);

        if(dataInicio != null && dataInicio.size() > 0) {
            if(horarioInicio != null && horarioInicio.size() > 0)

            throw new Exception("Este horário inicial já foi registrado para esse dia!");
        }

        if(dataFim != null && dataFim.size() > 0) {
            if(horarioFim != null && horarioFim.size() > 0)

                throw new Exception("Este horário final já foi registrado para esse dia!");
        }

        if(agendamento.getDataFim().isBefore(agendamento.getDataInicio()) ) {
            throw new Exception("Não é possível realizar um agendamento com a data de termino menor que a data de inicio");
        }

        if(horararioFim < horararioInicio) {
            throw new Exception("Não é possível realizar um agendamento com horario final menor que o horario de inicio");
        }

        if ((agendamento.getHorarioInicio().equals(agendamento.getHorarioFim())) ) {
            throw new Exception ("Não é possível salvar um agendamento com a hora inicio igual a hora de termino");
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

