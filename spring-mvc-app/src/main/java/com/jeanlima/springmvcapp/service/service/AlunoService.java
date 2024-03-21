package com.jeanlima.springmvcapp.service.service;

import java.util.List;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import org.springframework.stereotype.Service;
import com.jeanlima.springmvcapp.model.Aluno;

@Service
public interface AlunoService {

    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(Integer id);
    public List<Aluno> getListaAluno();
    public List<Aluno> getAlunosPorCursos(String curso);
    public List<Aluno> getAlunosPorLP(LinguagemDeProgramacao lp);
    public List<Aluno> getAlunosPorSO(SistemaOperacional os);
}
