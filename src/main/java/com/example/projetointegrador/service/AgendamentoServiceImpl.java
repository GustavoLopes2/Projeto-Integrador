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

        LocalTime horario = null;
        LocalTime horarioFinal = null;
        String dataFormatada = null;
        String dataFormatadaFim = null;

        List<Agendamento> Horario = agendamentoRepository.findAgendamentoByHorarioInicio(agendamento.getHorarioInicio());
        List<Agendamento> HorarioFim = agendamentoRepository.findAgendamentoByHorarioFim(agendamento.getHorarioFim());
        List<Agendamento> Data = agendamentoRepository.findAgendamentoByDataInicio(agendamento.getDataInicio());
        List<Agendamento> DataFim = agendamentoRepository.findAgendamentoByDataFim(agendamento.getDataFim());

        for (Agendamento horarioInicio : Horario) {
            horario = (horarioInicio.getHorarioInicio());
        }
        for (Agendamento horarioFim : Horario) {
            horarioFinal = (horarioFim.getHorarioFim());
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Agendamento data : Data) {
            dataFormatada = formato.format(data.getDataInicio());
        }

        for (Agendamento dataFim : DataFim) {
            dataFormatadaFim = formato.format(dataFim.getDataFim());
        }

        if (Horario.size() > 0) {
            throw new Exception("O horario inicio " + agendamento.getHorarioInicio() + " já foi registrado.");
        }

        if (HorarioFim.size()> 0) {
            throw new Exception(("O horario fim " +agendamento.getHorarioFim() + " já foi registrado"));
        }

        if (Data.size() > 0) {
            throw new Exception ("A data " + (dataFormatada) + " já foi registrada.");
        }

        if (agendamento.getDataInicio() != null && agendamento.getDataFim() != null) {
            agendamento.getDataFim().isBefore(agendamento.getDataInicio());
            throw new Exception("A data inicio " + formato.format(agendamento.getDataInicio()) + " Tem que ser antes da data final " + formato.format(agendamento.getDataFim()) + ".");

        }
        if (agendamento.getHorarioInicio() != null && agendamento.getHorarioFim() != null) {
            agendamento.getHorarioFim().isBefore(agendamento.getHorarioInicio());
            throw new Exception ("O horario " + agendamento.getHorarioInicio() + " Tem que ser antes do " + agendamento.getHorarioFim() + ".");
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

