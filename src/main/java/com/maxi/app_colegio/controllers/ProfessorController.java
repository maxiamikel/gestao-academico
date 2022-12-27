package com.maxi.app_colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.app_colegio.entities.Professor;
import com.maxi.app_colegio.services.ProfessorService;

@RestController
@RequestMapping("api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService service;
    
    @GetMapping("/{id}")
    public Professor findById( @PathVariable Long id){
        return service.findProfessorById(id);
    }

    @GetMapping("/")
    public List<Professor> findAll(){
        return this.service.findAllProfessores();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Professor obj){
        return this.service.createProfessor(obj);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody Professor obj){

        return this.service.updateProfessor(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return this.service.deleteProfessor(id);
    }
}
