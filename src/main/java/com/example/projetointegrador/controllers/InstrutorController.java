package com.example.projetointegrador.controllers;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.service.InstrutorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api")
@RestController
@CrossOrigin
public class InstrutorController {

    final InstrutorServiceImpl instrutorService;


    public InstrutorController(InstrutorServiceImpl instrutorService) {
        this.instrutorService = instrutorService;
    }

    @PostMapping("/salvarUsuario")
    public ResponseEntity<Object> salvarInstrutor(@RequestBody Instrutor instrutor) throws Exception {
        Instrutor response = instrutorService.salvar(instrutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PostMapping("/v2/login")
    public ResponseEntity<Object> sessao(@RequestBody Instrutor instrutor) throws Exception {
        Instrutor response = instrutorService.buscarInstrutorPorEmail(instrutor);
        return ResponseEntity.status(HttpStatus.OK).body(HttpStatus.CREATED);
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

