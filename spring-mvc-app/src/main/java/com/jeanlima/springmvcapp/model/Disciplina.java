package com.jeanlima.springmvcapp.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descricao", length = 50)
    private String descricao;

    @Column(name = "codigo",length = 7)
    private String codigo;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE})
    @JoinTable(
            name="disciplina_aluno",
            joinColumns=@JoinColumn(name="disciplina_id"),
            inverseJoinColumns=@JoinColumn(name="aluno_id"))
    private List<Aluno> alunos;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "disciplina_curso",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos;

    public Disciplina() {
        this.alunos = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public Disciplina(String descricao, String codigo, List<Aluno> alunos, List<Curso> cursos) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.alunos = alunos;
        this.cursos = cursos;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> curso) {
        this.cursos = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(codigo, that.codigo) && Objects.equals(alunos, that.alunos) && Objects.equals(cursos, that.cursos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, codigo, alunos, cursos);
    }


}
