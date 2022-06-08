package com.example.projetointegrador.controllers;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.service.CursoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/curso")
public class CursoController {

    final CursoServiceImpl cursoService;

    public CursoController(CursoServiceImpl cursoServiceImpl) {
        this.cursoService = cursoServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Object> salvarCurso(@RequestBody Curso curso) throws Exception {
        Curso response = cursoService.salvar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping()
    public void deletarCurso(Long id) {
        cursoService.deletar(id);
    }

    @GetMapping
    public List<Curso> findAllCurso() {
        return cursoService.listar();
    }
    @PutMapping()
    public void updatecurso(@RequestBody Curso curso) {
        cursoService.editar(curso);
    }
}

