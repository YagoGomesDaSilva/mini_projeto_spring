package com.jeanlima.springmvcapp.database;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.model.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MemoryDB {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();

    static {

        cursos.add(new Curso( 0, "BTI"));
        cursos.add(new Curso( 1, "CienComp"));
        cursos.add(new Curso( 2, "EngComp"));
        cursos.add(new Curso( 3, "EngSoft"));

        alunos.add(new Aluno("Yago","Gomes",cursos.get(0),LinguagemDeProgramacao.C_Sharp,"god@gmail.com"));
        alunos.add(new Aluno("LordYago","God",cursos.get(1),LinguagemDeProgramacao.Java,"god@gmail.com"));
        alunos.add(new Aluno("LordYagoD","ygs",cursos.get(2),LinguagemDeProgramacao.Python,"god@gmail.com"));
        alunos.add(new Aluno("Tobizao","GDL",cursos.get(3),LinguagemDeProgramacao.JavaScrypt,"god@gmail.com"));
        alunos.add(new Aluno("Guilherme","kramis",cursos.get(0),LinguagemDeProgramacao.C_Sharp,"ygs@gmail.com"));
        alunos.add(new Aluno("JAO","Tutu",cursos.get(1),LinguagemDeProgramacao.Java,"JAO@gmail.com"));
        alunos.add(new Aluno("Quarema","Gabriel",cursos.get(2),LinguagemDeProgramacao.Python,"codimina@gmail.com"));
        alunos.add(new Aluno("Torbas","Zerbas",cursos.get(3),LinguagemDeProgramacao.JavaScrypt,"zerbas@gmail.com"));

        for (Aluno aluno : alunos) {
            for (Curso curso : cursos) {
                if (aluno.getCurso().getDescricao().equals(curso.getDescricao())) {
                    curso.getAlunos().add(aluno);
                    break;
                }
            }
        }

    }

    public static <T> void adicionar(T item) {
        if (item instanceof Aluno ) {
            alunos.add((Aluno) item);
        }
        else if(item instanceof Curso){
            cursos.add((Curso) item);
        }
        else {
            throw new IllegalArgumentException("Tipo inválido. Apenas Aluno ou Curso são permitidos.");
        }
    }
    public static <T> void deletar(T item) {
        if (item instanceof Aluno ) {
            alunos.remove((Aluno) item);
        }
        else if(item instanceof Curso){
            cursos.remove((Curso) item);
        }
        else {
            throw new IllegalArgumentException("Tipo inválido. Apenas Aluno ou Curso são permitidos.");
        }
    }
    public static <T> List<T> listar(Class<T> classtype) {
        if (classtype == Aluno.class) {
            return (List<T>) alunos;
        } else if (classtype == Curso.class) {
            return (List<T>) cursos;
        } else {
            throw new IllegalArgumentException("Classe inválida. Apenas Aluno ou Curso são permitidos.");
        }
    }

    public static <T> T getById(Integer id, Class<T> classtype) {
        if (classtype == Aluno.class) {
            for (Aluno aluno : alunos) {
                if (Objects.equals(aluno.getId(), id)) {
                    return classtype.cast(aluno);
                }
            }
        } else if (classtype == Curso.class) {
            for (Curso curso : cursos) {
                if (Objects.equals(curso.getId(), id)) {
                    return classtype.cast(curso);
                }
            }
        } else {
            throw new IllegalArgumentException("Classe inválida. Apenas Aluno ou Curso são permitidos.");
        }
        return null;
    }
}
