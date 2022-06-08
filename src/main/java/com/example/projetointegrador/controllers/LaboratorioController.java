package com.example.projetointegrador.controllers;


import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.models.Laboratorio;
import com.example.projetointegrador.service.LaboratorioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "laboratorio")
public class LaboratorioController {
    final LaboratorioServiceImpl laboratorioService;


    public LaboratorioController(LaboratorioServiceImpl laboratorioServiceimpl) {
        this.laboratorioService = laboratorioServiceimpl;
    }
    @PostMapping
    public ResponseEntity<Object> salvarLaboratorio(@RequestBody Laboratorio laboratorio) {
        Laboratorio response = laboratorioService.salvar(laboratorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping()
    public void deletarLaboratorio(Long id) {
        laboratorioService.deletar(id);
    }
    @GetMapping
    public List<Laboratorio> findAllLaboratorio() {
        return laboratorioService.listar();
    }
    @PutMapping
    public void updateLaboratorio(@RequestBody Laboratorio laboratorio) {
        laboratorioService.editar(laboratorio);
    }
}

