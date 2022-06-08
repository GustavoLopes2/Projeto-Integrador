package com.example.projetointegrador.controllers;


import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.service.AgendamentoService;
import com.example.projetointegrador.service.AgendamentoServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    final AgendamentoServiceImpl agendamentoService;

    public AgendamentoController(AgendamentoServiceImpl agendamentoServiceImpl) {
        this.agendamentoService = agendamentoServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Object> salvarAgendamento(@RequestBody Agendamento agendamento) throws Exception {
        Agendamento response = agendamentoService.salvar(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
    @DeleteMapping()
    public void deletarAgendamento(Long id) {
        agendamentoService.deletar(id);

    }
    @GetMapping
    public ResponseEntity<Object> buscarAgendamento() {
        List<Agendamento> response = agendamentoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body((response));
    }

    @PutMapping
    public void updateAgendamento(@RequestBody Agendamento agendamento) {
        agendamentoService.editar(agendamento);
    }

}
