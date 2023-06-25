package com.example.uacademic.controllers;

import java.util.List;
import java.util.Optional;

import com.example.uacademic.entities.Administrador;
import com.example.uacademic.entities.Aluno;
import com.example.uacademic.entities.Cadeira;
import com.example.uacademic.entities.Professor;
import com.example.uacademic.repositories.AdminRepository;
import com.example.uacademic.repositories.AlunoRepository;
import com.example.uacademic.repositories.CadeiraRepository;
import com.example.uacademic.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @Autowired
    private AdminRepository adminrepo;

    @Autowired
    private AlunoRepository alunorepo;

    @Autowired
    private CadeiraRepository cadeirarepo;

    @Autowired
    private ProfessorRepository professorepo;

    @GetMapping("/administradores")
    public String index(Model model){
        List<Administrador> administradores = (List<Administrador>)adminrepo.findAll();
        List<Aluno> alunos = (List<Aluno>)alunorepo.findAll();
        List<Cadeira> cadeiras = (List<Cadeira>)cadeirarepo.findAll();
        List<Professor> professores = (List<Professor>)professorepo.findAll();

        model.addAttribute("administradores", administradores);
        model.addAttribute("alunos", alunos);
        model.addAttribute("cadeiras", cadeiras);
        model.addAttribute("professores", professores);
        
        return "administradores/index";
    }
    
    @GetMapping("/novoAdministrador")
    public String novoAdministrador(Model model) {

        return "administradores/novoAdmin";
    }

    @PostMapping("/salvarAdministrador")
    public String salvarAluno(@ModelAttribute Administrador administrador, Model model) {

        adminrepo.save(administrador);
        
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}/excluirAdmin")
    public String excluirAdmin(@PathVariable int id) {
        adminrepo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/administradores/{id}")
    public String editarAdmin(@PathVariable int id, Model model) {
        Optional<Administrador> administrador = adminrepo.findById(id);
        model.addAttribute("administrador", administrador.get());
        return "administradores/editarAdmin";
    }

    @PostMapping("/administradores/{id}/atualizar")
    public String atualizarAdmin(@PathVariable int id, @ModelAttribute Administrador administrador) {
        administrador.setId(id);
        adminrepo.save(administrador);
        return "redirect:/administradores";
    }

    @GetMapping("/novoAluno")
    public String novoAluno(Model model) {

        List<Cadeira> cadeiras = (List<Cadeira>)cadeirarepo.findAll();
        model.addAttribute("cadeiras", cadeiras);

        return "administradores/novoAluno";
    }

    @PostMapping("/salvarAluno")
    public String salvarAluno(@ModelAttribute Aluno aluno, Model model) {

        alunorepo.save(aluno);
        
        return "redirect:/administradores";
    }

    @GetMapping("/alunos/{id}/excluirAluno")
    public String excluirAluno(@PathVariable int id) {
        alunorepo.deleteById(id);
        return "redirect:/administradores";
    }
    
    @GetMapping("/alunos/{id}")
    public String editarAluno(@PathVariable int id, Model model) {
        List<Cadeira> cadeiras = (List<Cadeira>) cadeirarepo.findAll();
        model.addAttribute("cadeiras", cadeiras);
        Optional<Aluno> aluno = alunorepo.findById(id);
        model.addAttribute("aluno", aluno.get());
        return "administradores/editarAluno";
    }

    @PostMapping("/alunos/{id}/atualizar")
    public String atualizarAluno(@PathVariable int id, @ModelAttribute Aluno aluno) {
        aluno.setAid(id);
        alunorepo.save(aluno);
        return "redirect:/administradores";
    }

    @GetMapping("/novaCadeira")
    public String novaCadeira(Model model) {

        List<Professor> professores = (List<Professor>)professorepo.findAll();
        model.addAttribute("professores", professores);
        List<Aluno> alunos = (List<Aluno>)alunorepo.findAll();
        model.addAttribute("alunos", alunos);

        return "administradores/novaCadeira";
    }

    @PostMapping("/salvarCadeira")
    public String salvarAluno(@ModelAttribute Cadeira cadeira, Model model) {

        cadeirarepo.save(cadeira);
        
        return "redirect:/administradores";
    }

    @GetMapping("/cadeiras/{id}/excluirCadeira")
    public String excluirCadeira(@PathVariable int id) {
        cadeirarepo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/cadeiras/{id}")
    public String editarCadeira(@PathVariable int id, Model model) {
        List<Aluno> alunos = (List<Aluno>)alunorepo.findAll();
        model.addAttribute("alunos", alunos);
        List<Professor> professores = (List<Professor>) professorepo.findAll();
        model.addAttribute("professores", professores);
        Optional<Cadeira> cadeira = cadeirarepo.findById(id);
        model.addAttribute("cadeira", cadeira.get());
        return "administradores/editarCadeira";
    }

    @PostMapping("/cadeiras/{id}/atualizar")
    public String atualizarCadeira(@PathVariable int id, @ModelAttribute Cadeira cadeira) {
        cadeira.setCid(id);
        cadeirarepo.save(cadeira);
        return "redirect:/administradores";
    }

    @GetMapping("/novoProfessor")
    public String novoProfessor(Model model) {

        List<Cadeira> cadeiras = (List<Cadeira>)cadeirarepo.findAll();
        model.addAttribute("cadeiras", cadeiras);

        return "administradores/novoProfessor";
    }

    @PostMapping("/salvarProfessor")
    public String salvarProfessor(@ModelAttribute Professor professor, Model model) {

        professorepo.save(professor);
        
        return "redirect:/administradores";
    }
    
    @GetMapping("/professores/{id}/excluirProfessor")
    public String excluirProfessor(@PathVariable int id) {
        professorepo.deleteById(id);
        return "redirect:/administradores";
    }

    @GetMapping("/professores/{id}")
    public String editarProfessor(@PathVariable int id, Model model) {
        List<Cadeira> cadeiras = (List<Cadeira>) cadeirarepo.findAll();
        model.addAttribute("cadeiras", cadeiras);
        Optional<Professor> professor = professorepo.findById(id);
        model.addAttribute("professor", professor.get());
        return "administradores/editarProfessor";
    }

    @PostMapping("/professores/{id}/atualizar")
    public String atualizarProfessor(@PathVariable int id, @ModelAttribute Professor professor) {
        professor.setPid(id);
        professorepo.save(professor);
        return "redirect:/administradores";
    }

}
