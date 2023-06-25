package com.example.uacademic.controllers;

import java.util.List;
import com.example.uacademic.entities.Aluno;
import com.example.uacademic.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository rep;

    @GetMapping("/alunos")
    public String index(Model model){
        List<Aluno>alunos = (List<Aluno>)rep.findAll();
        model.addAttribute("alunos", alunos);
        return "alunos/index";
    }   
}
