package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controle {

    @Autowired
    private PersonRepository personRepository;
    private List<Pessoa> pessoas = new ArrayList<>();
    private int id = 0;

    public Pessoa findPessoa(String name){
        List<Pessoa> pessoas = (List<Pessoa>) personRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getName().equals(name)) {
                return pessoa;
            }
        }
        return null;
    }

    public Pessoa addPessoa(String name, String sexo){
        Pessoa pessoa = new Pessoa();
        pessoa.setName(name);
        pessoa.setSexo(sexo);
        id++;
        pessoa.setId(id);
        pessoas.add(pessoa);
        return pessoa;
    }

    public void removePessoa(String name){
        Pessoa pessoa = findPessoa(name);
        personRepository.delete(pessoa);
    }

    public Pessoa editPessoa(String name, String sexo){
        Pessoa pessoa = findPessoa(name);
        pessoa.setSexo(sexo);
        personRepository.save(pessoa);
        return pessoa;
    }
    public List<Pessoa> listAll(){
        return (List<Pessoa>)personRepository.findAll();
    }
}

