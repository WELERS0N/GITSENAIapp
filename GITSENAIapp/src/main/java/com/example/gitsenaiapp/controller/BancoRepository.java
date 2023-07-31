package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Conta;
import com.example.gitsenaiapp.model.ContaCorrentePF;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository<ContaCorrentePF, Long> {

}
