package com.jeanlima.springmvcapp.service.serviceImpl;

import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.Repository.AlunoRepository;
import com.jeanlima.springmvcapp.service.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public void salvarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
    @Override
    public void deletarAluno(Aluno aluno) {
        alunoRepository.delete(aluno);
    }
    @Override
    public Aluno getAlunoById(Integer id) {
        return alunoRepository.findById(id).orElseThrow(()->null);
    }
    @Override
    public List<Aluno> getListaAluno() {
        return alunoRepository.findAll();
    }

    @Override
    public List<Aluno> getListaAlunoWithDiciplina(){
        return alunoRepository.findAllFetchAlunoWithDisciplinas();
    }
    @Override
    public Aluno getAlunoByIdWithDiciplina(Integer id){
        return alunoRepository.findFetchAlunoByIdWithDisciplinas(id);
    }

}
