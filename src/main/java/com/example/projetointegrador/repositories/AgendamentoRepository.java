package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
