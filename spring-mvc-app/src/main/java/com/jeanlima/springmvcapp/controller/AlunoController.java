package com.jeanlima.springmvcapp.controller;

import java.util.*;

import com.jeanlima.springmvcapp.Enum.LinguagemDeProgramacao;
import com.jeanlima.springmvcapp.Enum.SistemaOperacional;
import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.service.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.jeanlima.springmvcapp.model.Aluno;
import com.jeanlima.springmvcapp.service.service.AlunoService;


@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    @Qualifier("alunoServiceImpl")
    AlunoService alunoService;

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/showForm")
    public Object showFormAluno(Model model){

        Aluno aluno = new Aluno();
        Curso curso = new Curso();
        aluno.setCurso(curso);
        model.addAttribute("aluno", aluno);
        model.addAttribute("cursos", cursoService.getListaCurso());

        model.addAttribute("linguagensDeProgramacaoEnum", LinguagemDeProgramacao.values());
        model.addAttribute("sistemasOperacionaisEnum", SistemaOperacional.values());

        return "aluno/formAluno";
    }

    @RequestMapping("/addAluno")
    public String showFormAluno(@ModelAttribute("aluno") Aluno aluno,  Model model){

       Curso cursoSelecionado = cursoService.getCursoById(aluno.getCurso().getId());
        aluno.setCurso(cursoSelecionado);

        alunoService.salvarAluno(aluno);
        //cursoService.adicionarAlunoAoCurso(aluno.getCurso(),aluno);
        model.addAttribute("aluno", aluno);
        return "aluno/paginaAluno";
    }

    @RequestMapping("/getListaAlunos")
    public String showListaAluno(Model model){
        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos",alunos);
        return "aluno/listaAlunos";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesAluno(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunoService.getAlunoById(id);
        model.addAttribute("aluno", aluno);
        return "aluno/paginaAluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id) {
        Aluno aluno = alunoService.getAlunoById(id);
        //cursoService.removerAlunoDoCurso(aluno.getCurso(),aluno);
        alunoService.deletarAluno(aluno);
        return "redirect:/aluno/getListaAlunos";
    }

    @GetMapping("/showListaAlunosCurso")
    public String listarAlunosPorCurso(Model model) {
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);

        return "aluno/alunosPorCurso";
    }

    @GetMapping("/showListaAlunosLP")
    public String listarAlunosPorLP(Model model) {
        List<LinguagemDeProgramacao> linguagens = Arrays.asList(LinguagemDeProgramacao.values());
        Map<LinguagemDeProgramacao, List<Aluno>> alunosPorLP = new HashMap<>();

        // Inicializa a lista de alunos para cada linguagem de programação
        for (LinguagemDeProgramacao lp : linguagens) {
            alunosPorLP.put(lp, new ArrayList<>());
        }

        // Agrupa os alunos por linguagem de programação
        for (Aluno aluno : alunoService.getListaAluno()) {
            alunosPorLP.get(aluno.getLinguagem()).add(aluno);
        }

        model.addAttribute("alunosPorLP", alunosPorLP);
        return "aluno/alunosPorLP";
    }

    @GetMapping("/showListaAlunosSO")
    public String listarAlunosPorSO(Model model) {

        List<Aluno> alunos = alunoService.getListaAluno();
        model.addAttribute("alunos", alunos);
        return "aluno/alunosPorSO";
    }

}
