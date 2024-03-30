package com.jeanlima.springmvcapp.Service.service;

import com.jeanlima.springmvcapp.Model.Aluno;
import com.jeanlima.springmvcapp.Model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CursoService {

    public void salvarCurso(Curso curso);
    public void deletarCurso(Curso curso);
    public Curso getCursoById(Integer id);
    public List<Curso> getListaCurso();
    public List<Curso> getListaCursoWithDiciplina();
    public Curso getCursoByIdWithDiciplina(Integer id);

}
