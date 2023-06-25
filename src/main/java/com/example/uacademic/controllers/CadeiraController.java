package com.example.uacademic.controllers;

import java.util.List;
import com.example.uacademic.entities.Cadeira;
import com.example.uacademic.repositories.CadeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CadeiraController {

    @Autowired
    private CadeiraRepository rep;

    @GetMapping("/cadeiras")
    public String index(Model model){
        List<Cadeira>cadeiras = (List<Cadeira>)rep.findAll();
        model.addAttribute("cadeiras", cadeiras);
        return "cadeiras/index";
    }   
}
