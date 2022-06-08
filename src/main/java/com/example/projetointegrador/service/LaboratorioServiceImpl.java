package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Curso;
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
    public Laboratorio salvar(Laboratorio laboratorio) throws Exception {
        List<Laboratorio> nome = laboratorioRepository.findLaboratorioBynome(laboratorio.getNome());
        if(nome != null && nome.size() > 0) {
            throw new Exception("O Nome do laboratorio " + laboratorio.getNome() + " já foi registrado.");
        }
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
