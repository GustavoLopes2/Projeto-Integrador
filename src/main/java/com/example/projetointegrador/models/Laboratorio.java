package com.example.projetointegrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "laboratorio")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_laboratorio")
public class Laboratorio {

    @Id
    @Column(name = "id_laboratorio")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade")
    private String quantidade;

    @Column(name = "status")
    private String status;
}
