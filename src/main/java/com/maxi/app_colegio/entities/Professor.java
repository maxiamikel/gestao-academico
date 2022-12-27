package com.maxi.app_colegio.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="salario", nullable = false)
    private float salario;

    @Column(name ="data_contratacao", nullable = false)
    private Date dataContratacao;

    @Column(name = "cpf", nullable= false, unique = true)
    private String cpf;

    @Column(name = "email", nullable= false, unique = true)
    private String email;

    @Column(name = "celular", nullable= false, unique = true)
    private String celular;

    @OneToMany(mappedBy= "professor", fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;

    

    public Professor() {
        
    }

 

    public Professor(String nome,float salario, Date dataContratacao, String cpf, String email, String celular) {
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.nome = nome;
    }


    public Professor(Long id,String nome, float salario, Date dataContratacao, String cpf, String email, String celular) {
        this.id = id;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.nome = nome;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((celular == null) ? 0 : celular.hashCode());
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
        Professor other = (Professor) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (celular == null) {
            if (other.celular != null)
                return false;
        } else if (!celular.equals(other.celular))
            return false;
        return true;
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


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }



    @Override
    public String toString() {
        return "Professor [id=" + id +", nome "+nome+ ", salario=" + salario + ", dataContratacao=" + dataContratacao + ", cpf=" + cpf
                + ", email=" + email + ", celular=" + celular + "]";
    }
  
}
