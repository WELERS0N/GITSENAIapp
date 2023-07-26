package com.example.gitsenaiapp.controller;

import org.springframework.data.repository.CrudRepository;
import com.example.gitsenaiapp.model.Pessoa;

public interface PersonRepository extends CrudRepository<Pessoa, Integer> {
}
