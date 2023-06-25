package com.example.uacademic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.uacademic.entities.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
    Professor findByEmailAndSenha(String email, String senha);
}