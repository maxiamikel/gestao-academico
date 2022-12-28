package com.maxi.app_colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome", unique = true)
    private String nome;

    @Column(nullable = false, name = "carga_horario")
    private Integer cargaHorario;

    @ManyToOne()
    @JoinColumn(name="professor_id", nullable = false, updatable = false)
    private Professor professor;

    public Disciplina() {
    }

    public Disciplina(String nome, Integer cargaHorario, Professor professor) {
        this.nome = nome;
        this.cargaHorario = cargaHorario;
        this.professor = professor;
    }

    public Disciplina(Long id, String nome, Integer cargaHorario) {
        this.id = id;
        this.nome = nome;
        this.cargaHorario = cargaHorario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(Integer cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Disciplina other = (Disciplina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    
    
    
}
