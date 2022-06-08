package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    List<Agendamento> findAgendamentoByHorarioInicio(String horarioInicio);
    List<Agendamento> findAgendamentoByDataInicio(LocalDate DataInicio);
}
