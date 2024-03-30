package com.jeanlima.springmvcapp.Repository;

import com.jeanlima.springmvcapp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {
    @Query(value="SELECT DISTINCT e FROM Curso e JOIN FETCH e.disciplina")
    List<Curso> findAllFetchCursoWithDisciplinas();
    @Query("SELECT a FROM Curso a JOIN FETCH a.disciplina WHERE a.id = :cursoId")
    Curso findFetchCursoByIdWithDisciplinas(@Param("cursoId") Integer cursoId);
}
