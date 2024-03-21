package com.jeanlima.springmvcapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OlaController {

    @GetMapping("/")
    public String showMenu(){
		return "ola/menu";
	}

	@RequestMapping("/showForm")
	public String showForm(){
		return "ola/ola-form";
	}

	@RequestMapping("/processaForm")
	public String processForm(@RequestParam("nome") String nome, Model model){
		nome = nome.toUpperCase();
		String result = "Olá, " + nome + "! Seja bem-vindo!";
		model.addAttribute("msg", result);
		return "ola/saudacao";
	}
    
}
