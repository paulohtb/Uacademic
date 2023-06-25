package com.example.uacademic.controllers;

import java.util.List;
import com.example.uacademic.entities.Professor;
import com.example.uacademic.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository rep;

    @GetMapping("/professores")
    public String index(Model model){
        List<Professor>professores = (List<Professor>)rep.findAll();
        model.addAttribute("professores", professores);
        return "professores/index";
    }   
}
