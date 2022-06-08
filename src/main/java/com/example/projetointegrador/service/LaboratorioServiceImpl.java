package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Laboratorio;
import com.example.projetointegrador.repositories.LaboratorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratorioServiceImpl implements LaboratorioService{

    final LaboratorioRepository laboratorioRepository;

    public LaboratorioServiceImpl(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Override
    public Laboratorio salvar(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public Laboratorio editar(Laboratorio laboratorio) {
        return laboratorioRepository.save(laboratorio);
    }

    @Override
    public List<Laboratorio> listar() {
        return laboratorioRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        laboratorioRepository.deleteById(id);

    }
}
