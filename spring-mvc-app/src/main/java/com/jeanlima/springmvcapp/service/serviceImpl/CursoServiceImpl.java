package com.jeanlima.springmvcapp.service.serviceImpl;

import com.jeanlima.springmvcapp.database.MemoryDB;
import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.service.service.CursoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CursoServiceImpl implements CursoService {
    @Override
    public void salvarCurso(Curso curso) {
        System.out.println(curso.toString());
        try{
            MemoryDB.adicionar(curso);
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
    @Override
    public void deletarCurso(Curso curso) {
        MemoryDB.deletar(curso);
    }
    @Override
    public Curso getCursoById(Integer id) {
        return MemoryDB.getById(id ,Curso.class);
    }
    @Override
    public List<Curso> getListaCurso() {
        return MemoryDB.listar(Curso.class);
    }
}
