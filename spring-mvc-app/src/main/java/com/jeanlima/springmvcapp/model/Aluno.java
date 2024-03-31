package com.jeanlima.springmvcapp.model;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    @Column(name = "ultimo_nome")
    private String ultimoNome;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Enumerated(EnumType.STRING)
    private LinguagemDeProgramacao linguagem;

    @ElementCollection(targetClass = SistemaOperacional.class)
    @CollectionTable(
            name = "aluno_sistemas_operacionais",
            joinColumns = @JoinColumn(name = "aluno_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "sistema_operacional")
    private List<SistemaOperacional> sistemasOperacionais;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private Set<Disciplina> disciplinas;

    public Aluno() {
        this.avatar = new Avatar();
        this.disciplinas = new HashSet<>();


    }

    public Aluno(String primeiroNome, String ultimoNome, String email, Avatar avatar, Curso curso, LinguagemDeProgramacao linguagem, List<SistemaOperacional> sistemasOperacionais, Set<Disciplina> disciplinas) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
        this.avatar = avatar;
        this.curso = curso;
        this.linguagem = linguagem;
        this.sistemasOperacionais = sistemasOperacionais;
        this.disciplinas = disciplinas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LinguagemDeProgramacao getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(LinguagemDeProgramacao linguagem) {
        this.linguagem = linguagem;
    }

    public List<SistemaOperacional> getSistemasOperacionais() {
        return sistemasOperacionais;
    }

    public void setSistemasOperacionais(List<SistemaOperacional> sistemasOperacionais) {
        this.sistemasOperacionais = sistemasOperacionais;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(primeiroNome, aluno.primeiroNome) && Objects.equals(ultimoNome, aluno.ultimoNome) && Objects.equals(email, aluno.email) && Objects.equals(avatar, aluno.avatar) && Objects.equals(curso, aluno.curso) && linguagem == aluno.linguagem && Objects.equals(sistemasOperacionais, aluno.sistemasOperacionais) && Objects.equals(disciplinas, aluno.disciplinas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, primeiroNome, ultimoNome, email, avatar, curso, linguagem, sistemasOperacionais, disciplinas);
    }

}
