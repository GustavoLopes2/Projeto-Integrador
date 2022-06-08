package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

    List<Instrutor> findInstrutorByemail(String email);
}
