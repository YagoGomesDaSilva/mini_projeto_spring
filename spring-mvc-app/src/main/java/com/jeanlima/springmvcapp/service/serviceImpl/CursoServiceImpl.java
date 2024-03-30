package com.jeanlima.springmvcapp.Service.serviceImpl;

import com.jeanlima.springmvcapp.Model.Curso;
import com.jeanlima.springmvcapp.Repository.CursoRepository;
import com.jeanlima.springmvcapp.Service.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void salvarCurso(Curso curso) {
        cursoRepository.save(curso);
    }
    @Override
    public void deletarCurso(Curso curso) {
        cursoRepository.delete(curso);
    }
    @Override
    public Curso getCursoById(Integer id) {
        return cursoRepository.findById(id).orElseThrow(()->null);
    }
    @Override
    public List<Curso> getListaCurso() {
        return cursoRepository.findAll();
    }
    @Override
    public List<Curso> getListaCursoWithDiciplina() {
        return cursoRepository.findAllFetchCursoWithDisciplinas();
    }
    @Override
    public Curso getCursoByIdWithDiciplina(Integer id) {
        return cursoRepository.findFetchCursoByIdWithDisciplinas(id);
    }


}
