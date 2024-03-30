package com.jeanlima.springmvcapp.Model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descricao", length = 50)
    private String descricao;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
    private List<Aluno> alunos ;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "curso_disciplina",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private List<Disciplina> disciplina;

    public Curso() {
    }

    public Curso(String descricao, List<Aluno> alunos, List<Disciplina> disciplina) {
        this.descricao = descricao;
        this.alunos = alunos;
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(List<Disciplina> disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(descricao, curso.descricao) && Objects.equals(alunos, curso.alunos) && Objects.equals(disciplina, curso.disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, alunos, disciplina);
    }


}
