package com.maxi.app_colegio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.maxi.app_colegio.entities.Disciplina;
import com.maxi.app_colegio.entities.Professor;
import com.maxi.app_colegio.entities.exceptions.ObjetoNaoEncontradoException;
import com.maxi.app_colegio.repositories.DisciplinaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repo;

    @Autowired
    private ObjetoNaoEncontradoException exc;

    @Autowired
    private ProfessorService professorService;

    public Disciplina findDisciplinaById(Long id){
        return this.repo.findById(id).orElseThrow( () -> new RuntimeException("Id ["+id+"] nao encontrado da classe"+repo.getClass().getSimpleName()));
    }
    

    public List<Disciplina> findAllDisciplinas(){
        return this.repo.findAll();
    }

    public List<Disciplina> findDisciplinasProfessor(Long id){
        Professor professor = this.professorService.findProfessorById(id);
        List<Disciplina> disciplinas = this.repo.findByProfessor_id(professor.getId());
        return disciplinas;
    }

    @Validated
    public ResponseEntity<?> createDisciplina(Disciplina obj){
        if(obj.getNome().length() <= 0){
            exc.setMsg("Informe um nome válido");
            return new ResponseEntity<ObjetoNaoEncontradoException >(exc, HttpStatus.BAD_REQUEST);
        }else{
            obj.setId(null);
            Professor professor = this.professorService.findProfessorById(obj.getProfessor().getId());
            Disciplina novo = new Disciplina();
            novo.setProfessor(professor);
            novo = this.repo.save(obj);
            return new ResponseEntity<Disciplina>(novo, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> updateDisciplina(Disciplina obj){
        Disciplina novo = this.findDisciplinaById(obj.getId());
        novo.setNome(obj.getNome());
        novo.setCargaHorario(obj.getCargaHorario());
        novo.setProfessor(obj.getProfessor());

        novo = this.repo.saveAndFlush(novo);

        return new ResponseEntity<Disciplina>(novo, HttpStatus.OK);
    }

    public ResponseEntity<?> deleteDisciplina(Long id){
        Disciplina obj = this.findDisciplinaById(id);
        this.repo.deleteById(obj.getId());
        exc.setMsg("Cadastro apagado com sucesso");
        return new ResponseEntity<ObjetoNaoEncontradoException>(exc, HttpStatus.OK);
    }
}
