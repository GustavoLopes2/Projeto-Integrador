package com.example.projetointegrador.dto;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Laboratorio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AgendamentoDTO {
    private String nomeDoInstrutor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String horarioInicio;
    private String horarioFim;
    private Integer numeroDoLaboratorio;
    private Curso curso;
    private Laboratorio laboratorio;

}
