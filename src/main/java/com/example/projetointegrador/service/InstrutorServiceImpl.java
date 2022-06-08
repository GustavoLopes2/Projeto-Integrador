package com.example.projetointegrador.service;

import com.example.projetointegrador.models.Curso;
import com.example.projetointegrador.models.Instrutor;
import com.example.projetointegrador.repositories.InstrutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrutorServiceImpl implements InstrutorService{

    final InstrutorRepository instrutorRepository;

    public InstrutorServiceImpl(InstrutorRepository instrutorRepository) {
        this.instrutorRepository = instrutorRepository;
    }

    @Override
    public Instrutor salvar(Instrutor instrutor) throws Exception {

        List<Instrutor> email = instrutorRepository.findInstrutorByemail(instrutor.getEmail());
        if(email != null && email.size() > 0) {
            throw new Exception("O Email " + instrutor.getEmail() + " já foi cadastrado.");
        }
        return instrutorRepository.save(instrutor);
    }

    @Override
    public Instrutor editar(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @Override
    public List<Instrutor> listar() {
        return instrutorRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        instrutorRepository.deleteById(id);
    }
}
