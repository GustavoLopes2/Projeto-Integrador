package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public Curso salvar(Curso curso) throws Exception {

        List<Curso> listaDeCursos = cursoRepository.findCursoByNomeDoCurso(curso.getNomeDoCurso());
        if(listaDeCursos != null && listaDeCursos.size() > 0) {

            throw new Exception("O curso " + curso.getNomeDoCurso() + " já foi registrado.");
        }

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

