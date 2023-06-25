package com.example.uacademic.controllers;

import com.example.uacademic.entities.Aluno;
import com.example.uacademic.entities.Professor;
import com.example.uacademic.entities.Administrador;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.uacademic.repositories.AdminRepository;
import com.example.uacademic.repositories.AlunoRepository;
import com.example.uacademic.repositories.ProfessorRepository;

@Controller
public class HomeController {

    @Autowired
    private AdminRepository adminrepo;

    @Autowired
    private AlunoRepository alunorepo;

    @Autowired
    private ProfessorRepository professorepo;

	@GetMapping("/")
    public String index(){
        return "home/index";
	}

    @PostMapping("/login/aluno")
    public String logarAluno(Aluno aluno){
        Aluno alunop = alunorepo.findByEmailAndSenha(aluno.getEmail(), aluno.getSenha());
        if(alunop != null){
            return "redirect:/aluno/" + alunop.getAid();
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/aluno/{id}")
    public String aluno(@PathVariable int id, Model model) {
        Optional<Aluno> aluno = alunorepo.findById(id);
        model.addAttribute("aluno", aluno.get());
        return "home/viewAluno";    
	}

    @PostMapping("/login/professor")
    public String logarProfessor(Professor professor){
        Professor professorp = professorepo.findByEmailAndSenha(professor.getEmail(), professor.getSenha());
        if(professorp != null){
            return "redirect:/professor/" + professorp.getPid();
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/professor/{id}")
    public String professor(@PathVariable int id, Model model) {
        Optional<Professor> professor = professorepo.findById(id);
        model.addAttribute("professor", professor.get());
        model.addAttribute("cadeiras", professor.get().getCadeiras());
        return "home/viewProfessor";    
	}

    @PostMapping("/login/administrador")
    public String logarAdministrador(Administrador administrador){
        Administrador administradorp = adminrepo.findByEmailAndSenha(administrador.getEmail(), administrador.getSenha());
        if(administradorp != null){
            return "redirect:/administradores";
        } else {
        return "redirect:/";
        }
	}
}
