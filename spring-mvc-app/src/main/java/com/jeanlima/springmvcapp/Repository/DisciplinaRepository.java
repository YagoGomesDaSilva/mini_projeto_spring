package com.jeanlima.springmvcapp.Repository;

import com.jeanlima.springmvcapp.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Integer> {

    @Query(value="SELECT DISTINCT e FROM Disciplina e JOIN FETCH e.alunos")
    List<Disciplina> findAllFetchDisciplinasWithAlunos();
    @Query("SELECT a FROM Disciplina a JOIN FETCH a.alunos WHERE a.id = :disciplinaId")
    Disciplina findFetchDisciplinaByIdWithAlunos(@Param("disciplinaId") Integer disciplinaId);

    @Query(value="SELECT DISTINCT e FROM Disciplina e JOIN FETCH e.cursos")
    List<Disciplina> findAllFetchDisciplinasWithCursos();
    @Query("SELECT a FROM Disciplina a JOIN FETCH a.cursos WHERE a.id = :disciplinaId")
    Disciplina findFetchDisciplinaByIdWithCursos(@Param("disciplinaId") Integer disciplinaId);

    @Query("SELECT DISTINCT d FROM Disciplina d LEFT JOIN FETCH d.alunos LEFT JOIN FETCH d.cursos")
    List<Disciplina> findAllFetchDisciplinasWithAlunosAndCursos();
    @Query("SELECT d FROM Disciplina d LEFT JOIN FETCH d.alunos LEFT JOIN FETCH d.cursos WHERE d.id = :disciplinaId")
    Disciplina findAllFetchDisciplinasWithAlunosAndCursos(@Param("disciplinaId") Integer disciplinaId);

}
