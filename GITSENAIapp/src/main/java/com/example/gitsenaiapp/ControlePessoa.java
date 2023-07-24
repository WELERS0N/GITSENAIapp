package com.example.gitsenaiapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlePessoa {

    List<Pessoa> pessoas = new ArrayList<>();
    int id = 0;

    @GetMapping("/pessoa")
    public Pessoa findPessoa(@PathParam("id") int id, @PathParam("name") String name) {
        for (Pessoa P : pessoas) {
            if (P.getName().equals(name)) {
                return P;
            }
        }
        return null;
    }

    @DeleteMapping("/pessoa")
    public String deletePerson(@PathParam("name") String name) {
        Pessoa pessoa = new Pessoa();
        for (Pessoa P : pessoas) {
            if (P.getName().equals(name)) {
                pessoa = P;
            }
        }
        pessoas.remove(pessoa);

        return "Pessoa com o nome de " + name + " foi deletada";
    }


    @PostMapping("/pessoa")
    public Pessoa addPessoa(@RequestParam String name, @RequestParam String sexo) {
        Pessoa pessoa = new Pessoa();
        pessoa.setName(name);
        pessoa.setSexo(sexo);
        id++;
        pessoa.setId(id);
        pessoas.add(pessoa);
        return pessoa;
    }

    @PutMapping
    public Pessoa updatePessoa(@PathParam("id") int id, @PathParam("name") String name) {
        Pessoa p = new Pessoa();
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                pessoa.setName(name);
                p = pessoa;
            }
        }
            return p;
    }

    @GetMapping("/home")
        public String helloWorld () {
            return "Hello world";
    }
}





