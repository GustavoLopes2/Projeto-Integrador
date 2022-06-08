package com.example.projetointegrador.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO {

    private String nomeDoCurso;
    private Integer quantidadeDeAlunos;
}
