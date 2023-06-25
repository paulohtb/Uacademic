package com.example.uacademic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.uacademic.entities.Administrador;

public interface AdminRepository extends CrudRepository<Administrador, Integer> {
    Administrador findByEmailAndSenha(String email, String senha);
}