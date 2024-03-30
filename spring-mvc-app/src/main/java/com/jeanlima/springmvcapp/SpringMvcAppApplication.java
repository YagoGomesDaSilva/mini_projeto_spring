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

import java.util.ArrayList;
import java.util.List;

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
            List<SistemaOperacional> sistemas1 = new ArrayList<>();
            sistemas1.add(SistemaOperacional.OSX);
            sistemas1.add(SistemaOperacional.WINDOWS);

            Curso curso1 = new Curso();
            curso1.setDescricao("BTI");
            cursoRepository.save(curso1);

            // Populando Disciplinas
            Disciplina disciplina1 = new Disciplina();
            disciplina1.setDescricao("Disciplina 1");
            disciplina1.setCodigo("D001");

            Aluno aluno1 = new Aluno();
            aluno1.setPrimeiroNome("quarema");
            aluno1.setUltimoNome("Biel");
            aluno1.setEmail("asnijcniauscdnicdas@adhnbhdasci");
            aluno1.setSistemasOperacionais(sistemas1);
            aluno1.getAvatar().setNomeFantasia("avatar");
            aluno1.setCurso(curso1);

            alunoRepository.save(aluno1);

            disciplina1.getCursos().add(curso1);
            disciplina1.getAlunos().add(aluno1);
            disciplinaRepository.save(disciplina1);
        };

/*
			for (int i = 0; i < 10; i++) {
				// Populando Avatar
				Avatar avatar = new Avatar("Avatar " + (i + 1), null);
				avatarRepository.save(avatar);

				// Populando Curso
				Curso curso = new Curso("Curso " + (i + 1), null, null);
				cursoRepository.save(curso);

				// Populando Disciplina
				Disciplina disciplina = new Disciplina("Disciplina " + (i + 1), "D00" + (i + 1), null, null);
				disciplinaRepository.save(disciplina);

				// Populando Aluno
				Aluno aluno = new Aluno("Nome" + (i + 1), "Sobrenome" + (i + 1), "email" + (i + 1) + "@example.com",
						avatar, curso, LinguagemDeProgramacao.Java, Arrays.asList(SistemaOperacional.OSX, SistemaOperacional.WINDOWS), null);
				alunoRepository.save(aluno);

				// Associando Aluno, Curso e Disciplina
				aluno.setDisciplinas(Collections.singletonList(disciplina));
				alunoRepository.save(aluno);
				curso.setAlunos(Set.of(aluno));
				cursoRepository.save(curso);
				disciplina.setAlunos(Collections.singletonList(aluno));
				disciplinaRepository.save(disciplina);
			}

		};*/
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcAppApplication.class, args);
    }

}
