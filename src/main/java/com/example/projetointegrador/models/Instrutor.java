package com.example.projetointegrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "instrutor")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_instrutor")
public class Instrutor {

    @Id
    @Column(name = "id_instrutor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
