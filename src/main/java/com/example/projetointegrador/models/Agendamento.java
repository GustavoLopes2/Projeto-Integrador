package com.example.projetointegrador.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "agendamento")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id_agendamento")
@Data
public class Agendamento {

    @Id
    @Column(name = "id_agendamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "agendamento_instrutor",
                joinColumns = @JoinColumn(name = "id_instrutor"),
                inverseJoinColumns = @JoinColumn(name = "id_agendamento"))
    private Instrutor instrutor;

    @Column(name = "nomeDoInstrutor")
    private String nomeDoInstrutor;

    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    @Column(name = "dataFim")
    private LocalDate dataFim;

    @Column(name = "horarioInicio")
    private LocalTime horarioInicio;

    @Column(name = "horarioFim")
    private LocalTime horarioFim;

    @Column(name = "numeroDoLaboratorio")
    private String numeroDoLaboratorio;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "agendamento_curso",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_agendamento"))
    private Curso curso;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    @JoinTable(name = "agendamento_laboratorio",
            joinColumns = @JoinColumn(name = "id_laboratorio"),
            inverseJoinColumns = @JoinColumn(name = "id_agendamento"))
    private Laboratorio laboratorio;
}

