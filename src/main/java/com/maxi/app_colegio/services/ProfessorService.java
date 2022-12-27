package com.maxi.app_colegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.maxi.app_colegio.entities.Professor;
import com.maxi.app_colegio.entities.exceptions.ObjetoNaoEncontradoException;
import com.maxi.app_colegio.repositories.ProfessorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProfessorService {

    @Autowired
    private ProfessorRepository repo;

    @Autowired
    private ObjetoNaoEncontradoException exc;

    public Professor findProfessorById(Long id){
        return this.repo.findById(id).orElseThrow( () -> new RuntimeException("Id ["+id+"] nao encontrado da classe"+repo.getClass().getSimpleName()));
    }
    

    public List<Professor> findAllProfessores(){
        return this.repo.findAll();
    }

    @Validated
    public ResponseEntity<?> createProfessor(Professor obj){
        if(obj.getCpf().length() <= 0){
            exc.setMsg("Informe um cpf válido");
            return new ResponseEntity<ObjetoNaoEncontradoException >(exc, HttpStatus.BAD_REQUEST);
        }else{
            obj.setId(null);
            obj.setCpf(obj.getCpf());

            Professor novo = this.repo.save(obj);
            return new ResponseEntity<Professor>(novo, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> updateProfessor(Professor obj){
        Professor novo = this.findProfessorById(obj.getId());
        novo.setCelular(obj.getCelular());
        novo.setCpf(obj.getCpf());
        novo.setNome(obj.getNome());
        novo.setEmail(obj.getEmail());
        novo.setSalario(obj.getSalario());

        novo = this.repo.saveAndFlush(novo);

        return new ResponseEntity<Professor>(novo, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteProfessor(Long id){
        Professor obj = this.findProfessorById(id);
        this.repo.deleteById(obj.getId());
        exc.setMsg("Cadastro apagado com sucesso");
        return new ResponseEntity<ObjetoNaoEncontradoException>(exc, HttpStatus.OK);
    }
}
