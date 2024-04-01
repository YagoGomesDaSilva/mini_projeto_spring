package com.jeanlima.springmvcapp;

import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import com.jeanlima.springmvcapp.Repository.AlunoRepository;
import com.jeanlima.springmvcapp.Repository.AvatarRepository;
import com.jeanlima.springmvcapp.Repository.CursoRepository;
import com.jeanlima.springmvcapp.Repository.DisciplinaRepository;
import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.model.Avatar;
import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class SpringMvcAppApplication {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            
            // Criar cursos
            List<Curso> cursos = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Curso curso = new Curso();
                curso.setDescricao("Curso " + (i + 1));
                cursos.add(curso);
            }
            cursoRepository.saveAll(cursos);

            // Criar disciplinas
            List<Disciplina> disciplinas = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Disciplina disciplina = new Disciplina();
                disciplina.setDescricao("Disciplina " + (i + 1));
                disciplina.setCodigo("D00" + (i + 1));
                disciplinas.add(disciplina);
            }
            disciplinaRepository.saveAll(disciplinas);

            // Associar disciplinas aos cursos
            for (Disciplina disciplina : disciplinas) {
                for (int i = 0; i < 2; i++) { // Associar cada disciplina a 2 cursos
                    Curso curso = cursos.get(new Random().nextInt(cursos.size()));
                    disciplina.getCursos().add(curso);
                    curso.getDisciplina().add(disciplina);
                }
            }

            // Associar alunos às disciplinas
            List<Aluno> alunos = new ArrayList<>();
            for (int i = 0; i < 50; i++) {
                Aluno aluno = new Aluno();
                aluno.setPrimeiroNome("Aluno " + (i + 1));
                aluno.setUltimoNome("Sobrenome " + (i + 1));
                aluno.setEmail("aluno" + (i + 1) + "@exemplo.com");

                Curso cursoDoAluno = cursos.get(new Random().nextInt(cursos.size()));
                aluno.setCurso(cursoDoAluno);

                alunoRepository.save(aluno);
                alunos.add(aluno);
            }

            for (Aluno aluno : alunos) {
                for (int i = 0; i < 3; i++) { // Associar cada aluno a 3 disciplinas
                    Disciplina disciplina = disciplinas.get(new Random().nextInt(disciplinas.size()));
                    aluno.getDisciplinas().add(disciplina);
                    disciplina.getAlunos().add(aluno);
                }
            }

            // Salvar todas as alterações no banco de dados
            alunoRepository.saveAll(alunos);
            disciplinaRepository.saveAll(disciplinas);




        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcAppApplication.class, args);
    }
}
