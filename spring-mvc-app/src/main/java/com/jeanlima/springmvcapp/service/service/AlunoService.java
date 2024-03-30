package com.jeanlima.springmvcapp.service.service;

import com.jeanlima.springmvcapp.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlunoService {
    public void salvarAluno(Aluno aluno);
    public void deletarAluno(Aluno aluno);
    public Aluno getAlunoById(Integer id);
    public List<Aluno> getListaAluno();
    public List<Aluno> getListaAlunoWithDiciplina();
    public Aluno getAlunoByIdWithDiciplina(Integer id);

}
