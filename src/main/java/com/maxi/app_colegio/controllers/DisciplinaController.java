
package com.maxi.app_colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.app_colegio.entities.Disciplina;
import com.maxi.app_colegio.services.DisciplinaService;

@RestController
@RequestMapping("api/disciplinas")
@CrossOrigin(origins = "*")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;
    
    @GetMapping("/{id}")
    public Disciplina findById( @PathVariable Long id){
        return service.findDisciplinaById(id);
    }

    @GetMapping("/")
    public List<Disciplina> findAll(){
        return this.service.findAllDisciplinas();
    }

    @GetMapping("/professor/{id}")
    public List<Disciplina> findAllDisciplinasProfessor(@PathVariable Long id){
        return this.service.findDisciplinasProfessor(id);
    }

/* 
    @GetMapping("/pro/dis/{id}")
    public List <Disciplina> listar(@PathVariable Long id){
        return this.service.getDisciplinasPorProfessor(id);
    }
    */


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Disciplina obj){
        return this.service.createDisciplina(obj);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Disciplina obj){

        return this.service.updateDisciplina(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return this.service.deleteDisciplina(id);
    }
}
