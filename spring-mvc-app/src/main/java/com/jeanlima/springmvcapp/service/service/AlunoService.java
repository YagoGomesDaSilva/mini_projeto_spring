package com.jeanlima.springmvcapp.Service.service;

import java.util.List;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import com.jeanlima.springmvcapp.Model.Curso;
import org.springframework.stereotype.Service;
import com.jeanlima.springmvcapp.Model.Aluno;

@Service
public interface AlunoService {
    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(Integer id);
    public List<Aluno> getListaAluno();
    public List<Aluno> getListaAlunoWithDiciplina();
    public Aluno getAlunoByIdWithDiciplina(Integer id);

}
