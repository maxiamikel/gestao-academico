package com.maxi.app_colegio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.app_colegio.entities.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    List<Disciplina> findByProfessor_id(Long id);
     /*@Query(value = "SELECT * FROM disciplina t WHERE t.professor_id = :id", nativeQuery =
     true)
     List<Disciplina> findByProfessor_I(@Param("id") Long id);*/
}
