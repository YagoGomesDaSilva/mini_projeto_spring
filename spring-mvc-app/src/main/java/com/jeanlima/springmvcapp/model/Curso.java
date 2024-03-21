package com.jeanlima.springmvcapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Curso {
    private Integer id;
    private String descricao;
    private List<Aluno> alunos = new ArrayList<>();


    public Curso() {
        this.id = new Random().nextInt(10000);
    }

    public Curso(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(descricao, curso.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }

    @Override
    public String toString() {
        return "Curso[" + "id=" + id +", descricao='" + descricao + '\'' + ']';
    }
}
