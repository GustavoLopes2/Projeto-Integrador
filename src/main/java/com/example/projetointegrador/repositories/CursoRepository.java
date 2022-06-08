package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findCursoByNomeDoCurso(String nome);
}
