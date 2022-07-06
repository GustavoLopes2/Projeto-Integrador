package com.example.projetointegrador.repositories;

import com.example.projetointegrador.models.Agendamento;
import com.example.projetointegrador.models.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    @Query(value = "SELECT * FROM instrutor u WHERE u.email = email",
            nativeQuery = true)
        Instrutor findByEmailInstrutor(@Param("email") String email);
}
