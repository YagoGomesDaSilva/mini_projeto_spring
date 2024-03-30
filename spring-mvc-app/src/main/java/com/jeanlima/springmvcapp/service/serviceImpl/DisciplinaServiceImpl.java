package com.jeanlima.springmvcapp.Service.serviceImpl;

import com.jeanlima.springmvcapp.Model.Disciplina;
import com.jeanlima.springmvcapp.Repository.DisciplinaRepository;
import com.jeanlima.springmvcapp.Service.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DisciplinaServiceImpl implements DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Override
    public void salvarDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }
    @Override
    public void deletarDisciplina(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }
    @Override
    public Disciplina getDisciplinaById(Integer id) {
        return disciplinaRepository.findById(id).orElseThrow(()->null);
    }
    @Override
    public List<Disciplina> getListaDisciplina() {
        return disciplinaRepository.findAll();
    }

    @Override
    public List<Disciplina> findAllFetchDisciplinasWithAlunos() {
        return disciplinaRepository.findAllFetchDisciplinasWithAlunos();
    }

    @Override
    public Disciplina findFetchDisciplinaByIdWithAlunos(Integer disciplinaId) {
        return disciplinaRepository.findFetchDisciplinaByIdWithAlunos(disciplinaId);
    }

    @Override
    public List<Disciplina> findAllFetchDisciplinasWithCursos() {
        return disciplinaRepository.findAllFetchDisciplinasWithCursos();
    }

    @Override
    public Disciplina findFetchDisciplinaByIdWithCursos(Integer disciplinaId) {
        return disciplinaRepository.findFetchDisciplinaByIdWithCursos(disciplinaId);
    }

    @Override
    public List<Disciplina> findAllFetchDisciplinasWithAlunosAndCursos() {
        return disciplinaRepository.findAllFetchDisciplinasWithAlunosAndCursos();
    }

    @Override
    public Disciplina findAllFetchDisciplinasWithAlunosAndCursos(Integer disciplinaId) {
        return disciplinaRepository.findAllFetchDisciplinasWithAlunosAndCursos(disciplinaId);
    }


}
