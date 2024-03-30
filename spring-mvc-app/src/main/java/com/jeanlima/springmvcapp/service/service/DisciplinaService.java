package com.jeanlima.springmvcapp.service.service;

import com.jeanlima.springmvcapp.model.Disciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DisciplinaService {

    public void salvarDisciplina(Disciplina disciplina);
    public void deletarDisciplina(Disciplina disciplina);
    public Disciplina getDisciplinaById(Integer id);
    public List<Disciplina> getListaDisciplina();


    List<Disciplina> findAllFetchDisciplinasWithAlunos();
    Disciplina findFetchDisciplinaByIdWithAlunos(Integer disciplinaId);

    List<Disciplina> findAllFetchDisciplinasWithCursos();
    Disciplina findFetchDisciplinaByIdWithCursos(Integer disciplinaId);

    List<Disciplina> findAllFetchDisciplinasWithAlunosAndCursos();
    Disciplina findAllFetchDisciplinasWithAlunosAndCursos(Integer disciplinaId);

}
