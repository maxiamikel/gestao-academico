package com.maxi.app_colegio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.app_colegio.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    //List<Professor> findByName(String nome);

    //Professor findByCpf(String cpf);
    
}
