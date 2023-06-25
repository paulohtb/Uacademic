package com.example.uacademic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.uacademic.entities.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
    Aluno findByEmailAndSenha(String email, String senha);
}