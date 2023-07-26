package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controle {

    private List<Pessoa> pessoas = new ArrayList<>();
    private int id = 0;

    public Pessoa findPessoa(String name){
        for (Pessoa P : pessoas) {
            if (P.getName().equals(name)) {
                return P;
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

}
