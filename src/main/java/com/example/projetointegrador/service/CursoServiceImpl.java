package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso salvar(Curso curso) {
        List<Curso> t = cursoRepository.findCursoByNomeDoCurso(curso.getNomeDoCurso());
        return cursoRepository.save(curso);

    }

    @Override
    public Curso editar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        cursoRepository.deleteById(id);

    }
}

