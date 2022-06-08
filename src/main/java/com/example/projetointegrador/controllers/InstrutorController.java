package com.example.projetointegrador.controllers;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.service.InstrutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/instrutor")
@RestController
public class InstrutorController {

    final InstrutorServiceImpl instrutorService;


    public InstrutorController(InstrutorServiceImpl instrutorServiceImpl) {
        this.instrutorService = instrutorServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Object> salvarInstrutor(@RequestBody Instrutor instrutor) throws Exception {
        Instrutor response = instrutorService.salvar(instrutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping()
    public void deletarInstrutor(Long id) {
        instrutorService.deletar(id);
    }
    @GetMapping
    public List<Instrutor> findAllinstrutor() {
        return instrutorService.listar();
    }
    @PutMapping
    public void updateInstrutor(@RequestBody Instrutor instrutor) {
        instrutorService.editar(instrutor);
    }

}

