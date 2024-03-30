package com.jeanlima.springmvcapp.Repository;

import com.jeanlima.springmvcapp.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    @Query(value="SELECT DISTINCT e FROM Aluno e JOIN FETCH e.disciplinas")
    List<Aluno> findAllFetchAlunoWithDisciplinas();
    @Query("SELECT a FROM Aluno a JOIN FETCH a.disciplinas WHERE a.id = :alunoId")
    Aluno findFetchAlunoByIdWithDisciplinas(@Param("alunoId") Integer alunoId);
}
