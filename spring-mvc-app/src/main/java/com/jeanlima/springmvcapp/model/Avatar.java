package com.jeanlima.springmvcapp.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "avatar")
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @OneToOne(mappedBy = "avatar")
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    public Avatar() {
    }

    public Avatar(String nomeFantasia, Aluno aluno) {
        this.nomeFantasia = nomeFantasia;
        this.aluno = aluno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return Objects.equals(id, avatar.id) && Objects.equals(nomeFantasia, avatar.nomeFantasia) && Objects.equals(aluno, avatar.aluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFantasia, aluno);
    }

}
