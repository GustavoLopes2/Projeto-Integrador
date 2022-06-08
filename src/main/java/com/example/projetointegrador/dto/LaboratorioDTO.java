package com.example.projetointegrador.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LaboratorioDTO {

    private String nome;
    private BigDecimal quantidade;
    private String status;
}
