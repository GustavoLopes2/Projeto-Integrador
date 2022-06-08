package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, Long> {

    List<Laboratorio> findLaboratorioBynome(String nome);
}
