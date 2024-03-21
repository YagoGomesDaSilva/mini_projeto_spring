package com.jeanlima.springmvcapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import com.jeanlima.springmvcapp.database.MemoryDB;
import com.jeanlima.springmvcapp.service.service.AlunoService;
import org.springframework.stereotype.Component;

import com.jeanlima.springmvcapp.model.Aluno;

@Component
public class AlunoServiceImpl implements AlunoService {
    @Override
    public void salvarAluno(Aluno aluno) {
        System.out.println(aluno.toString());
        try{
            //this.alunos.add(aluno);
            MemoryDB.adicionar(aluno);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    @Override
    public void deletarAluno(Aluno aluno) {
        MemoryDB.deletar(aluno);
    }
    @Override
    public Aluno getAlunoById(Integer id) {
         return MemoryDB.getById(id, Aluno.class);
    }
    @Override
    public List<Aluno> getListaAluno() {
        return MemoryDB.listar(Aluno.class);
    }
    @Override
    public List<Aluno> getAlunosPorCursos(String curso) {
        List<Aluno> alunosPorCurso = new ArrayList<>();
        for(Aluno aluno : MemoryDB.listar(Aluno.class)){
            if(Objects.equals(aluno.getCurso(), curso)){
                alunosPorCurso.add(aluno);
            }
        }
        return alunosPorCurso;
    }

    @Override
    public List<Aluno> getAlunosPorLP(LinguagemDeProgramacao lp) {
        List<Aluno> alunosPorLp = new ArrayList<>();
        for(Aluno aluno : MemoryDB.listar(Aluno.class)){
            if(Objects.equals(aluno.getLinguagem(), lp.name())){
                alunosPorLp.add(aluno);
            }
        }
        return alunosPorLp;
    }

    @Override
    public List<Aluno> getAlunosPorSO(SistemaOperacional os) {
        List<Aluno> alunosPorSO = new ArrayList<>();
        for(Aluno aluno : MemoryDB.listar(Aluno.class)){
            if(aluno.getSistemasOperacionas().contains(os.name())){
                alunosPorSO.add(aluno);
            }
        }
        return alunosPorSO;
    }


}
