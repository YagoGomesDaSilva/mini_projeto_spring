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
            for (int i = 0; i < 10; i++) {
                List<SistemaOperacional> sistemas1 = new ArrayList<>();
                sistemas1.add(SistemaOperacional.OSX);
                sistemas1.add(SistemaOperacional.WINDOWS);

                Curso curso1 = new Curso();
                curso1.setDescricao("Curso " + i);
                cursoRepository.save(curso1);

                // Populando Disciplinas
                Disciplina disciplina1 = new Disciplina();
                disciplina1.setDescricao("Disciplina " + i);
                disciplina1.setCodigo("D00" + i);

                Aluno aluno1 = new Aluno();
                aluno1.setPrimeiroNome("aluno " + i);
                aluno1.setUltimoNome("doe");
                aluno1.setEmail("email" + i + "@test.com");
                aluno1.setSistemasOperacionais(sistemas1);
                aluno1.getAvatar().setNomeFantasia("avatar" + i);
                aluno1.setCurso(curso1);

                alunoRepository.save(aluno1);

                disciplina1.getCursos().add(curso1);
                disciplina1.getAlunos().add(aluno1);
                disciplinaRepository.save(disciplina1);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcAppApplication.class, args);
    }

}
