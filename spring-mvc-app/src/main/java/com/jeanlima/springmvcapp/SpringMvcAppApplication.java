package com.jeanlima.springmvcapp;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import com.jeanlima.springmvcapp.Model.Aluno;
import com.jeanlima.springmvcapp.Model.Avatar;
import com.jeanlima.springmvcapp.Model.Curso;
import com.jeanlima.springmvcapp.Model.Disciplina;
import com.jeanlima.springmvcapp.Repository.AlunoRepository;
import com.jeanlima.springmvcapp.Repository.AvatarRepository;
import com.jeanlima.springmvcapp.Repository.CursoRepository;
import com.jeanlima.springmvcapp.Repository.DisciplinaRepository;
import com.jeanlima.springmvcapp.config.HibernateAnnotationUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class SpringMvcAppApplication {

	@Autowired
	private  AlunoRepository alunoRepository;

	@Autowired
	private AvatarRepository avatarRepository;

	@Autowired
	private  CursoRepository cursoRepository;

	@Autowired
	private  DisciplinaRepository disciplinaRepository;

	@Bean
	public CommandLineRunner init(){
		return args -> {


			SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();

			// Populando Avatar
			//Avatar avatar1 = new Avatar("Avatar 1", );
			//avatarRepository.save(avatar1);

			// Populando Cursos
			Curso curso1 = new Curso();
			curso1.setDescricao("BTI");
			//cursoRepository.save(curso1);

			// Populando Disciplinas
			//Disciplina disciplina1 = new Disciplina("Disciplina 1", "D001", null, null);
			//disciplinaRepository.save(disciplina1);

			// Populando Alunos
			//List<SistemaOperacional> sistemas1 = new ArrayList<>();
			//sistemas1.add(SistemaOperacional.OSX);
			//sistemas1.add(SistemaOperacional.WINDOWS);

			Aluno aluno1 = new Aluno();
			aluno1.setPrimeiroNome("quarema");
			aluno1.setUltimoNome("Biel");
			aluno1.setEmail("asnijcniauscdnicdas@adhnbhdasci");


			List<Aluno> alunos = new ArrayList<>();
			alunos.add(aluno1);
			curso1.setAlunos(alunos);

			try{
				Transaction tx = session.beginTransaction();

				session.save(curso1);
				session.save(aluno1);

				tx.commit();

			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			finally {
				if (!sessionFactory.isClosed()) {
					sessionFactory.close();
				}
			}

			//alunoRepository.save(aluno1);
			// Associando Aluno, Curso e Disciplina
		    // aluno1.setDisciplinas(List.of(disciplina1));
		    // alunoRepository.save(aluno1);
		    // curso1.setAlunos(Set.of(aluno1));
		    // cursoRepository.save(curso1);
			// disciplina1.setAlunos(List.of(aluno1));
		    // disciplinaRepository.save(disciplina1);
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
