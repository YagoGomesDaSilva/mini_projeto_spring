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
/*


            // Recuperar todas as disciplinas e cursos disponíveis do banco de dados
            List<Disciplina> disciplinas = disciplinaRepository.findAll();
            List<Curso> cursos = cursoRepository.findAll();

            // Associar disciplinas aos cursos
            for (Curso curso : cursos) {
                Set<Disciplina> disciplinasDoCurso = new HashSet<>();
                for (int i = 0; i < 3; i++) { // Associar 3 disciplinas a cada curso
                    Disciplina disciplina = disciplinas.get(new Random().nextInt(disciplinas.size()));
                    disciplinasDoCurso.add(disciplina);
                }
                curso.setDisciplina(disciplinasDoCurso);
                cursoRepository.save(curso); // Salvar curso com as disciplinas associadas
            }

            cursos = cursoRepository.findAllFetchCursoWithDisciplinas();

            for (int i = 0; i < cursos.size(); i++) {
                System.out.println(cursos.get(i).getDescricao());
                var disciplnas_do_curso = cursos.get(i).getDisciplina();
                for (int j = 0; j < disciplnas_do_curso.size(); j++){
                    System.out.println(disciplnas_do_curso.get(j).getDescricao());
                    disciplinaRepository.save(disciplnas_do_curso.get(j));
                }
            }
            */


/*


            // Associar cursos às disciplinas
            for (Disciplina disciplina : disciplinas) {
                List<Curso> cursosDaDisciplina = new ArrayList<>();
                for (int i = 0; i < 3; i++) { // Associar 3 cursos a cada disciplina
                    Curso curso = cursos.get(new Random().nextInt(cursos.size()));
                    cursosDaDisciplina.add(curso);
                }
                disciplina.setCursos(cursosDaDisciplina);
                disciplinaRepository.save(disciplina); // Salvar disciplina com os cursos associados
            }
*/

/*
            // Populando Disciplinas
            for (int i = 0; i < 10; i++) {
                Disciplina disciplina = new Disciplina();
                disciplina.setDescricao("Disciplina " + (i + 1) );
                disciplina.setCodigo("D00" + i);
                disciplinaRepository.save(disciplina);
            }
            // Populando Curso
            for (int i = 0; i < 5; i++) {
                Curso curso = new Curso();
                curso.setDescricao("Curso " + (i + 1));
                cursoRepository.save(curso);
            }


            // Recuperar todas as disciplinas e cursos disponíveis do banco de dados
            List<Disciplina> disciplinas = disciplinaRepository.findAll();
            List<Curso> cursos = cursoRepository.findAll();

            // Verificar se há disciplinas e cursos disponíveis
            if (!disciplinas.isEmpty() && !cursos.isEmpty()) {
                // Associar cursos às disciplinas e disciplinas aos cursos
                for (Disciplina disciplina : disciplinas) {
                    Set<Curso> cursosDaDisciplina = new HashSet<>();
                    for (int i = 0; i < 3; i++) { // Associar 3 cursos a cada disciplina (ajuste conforme necessário)
                        Curso curso = cursos.get(new Random().nextInt(cursos.size()));
                        cursosDaDisciplina.add(curso);
                        curso.getDisciplina().add(disciplina); // Associar disciplina ao curso
                        cursoRepository.save(curso); // Salvar curso com a disciplina associada
                    }
                    disciplina.setCursos(cursosDaDisciplina);
                    disciplinaRepository.save(disciplina); // Salvar disciplina com os cursos associados
                }
            }
*/

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
