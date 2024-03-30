package com.jeanlima.springmvcapp.controller;

import com.jeanlima.springmvcapp.model.Curso;
import com.jeanlima.springmvcapp.service.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/getListaCursos")
    public String showListaCurso(Model model){
        List<Curso> cursos =  cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);
        return "curso/listaCursos";
    }

    @RequestMapping("/showForm")
    public Object showFormCurso(Model model){
        model.addAttribute("curso", new Curso());
        return "curso/formCurso";
    }

    @PostMapping("/addCurso")
    public String showFormCurso(@ModelAttribute("curso") Curso curso, Model model){
        cursoService.salvarCurso(curso);
        return this.showListaCurso(model);
    }

    @GetMapping("/excluir/{id}")
    public String excluirCurso(@PathVariable("id") Integer id) {
        Curso curso = cursoService.getCursoById(id);
        cursoService.deletarCurso(curso);
        return "redirect:/curso/getListaCursos";
    }


}
