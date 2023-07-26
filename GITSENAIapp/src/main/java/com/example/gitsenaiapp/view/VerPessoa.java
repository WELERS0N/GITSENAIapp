package com.example.gitsenaiapp.view;

import com.example.gitsenaiapp.controller.Controle;
import com.example.gitsenaiapp.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VerPessoa {

    @Autowired
    Controle controle;
    @GetMapping("/pessoa")
    public Pessoa findPessoa(@PathParam("name") String name) {
        return controle.findPessoa(name);
    }

    @DeleteMapping("/pessoa")
    public String deletePerson(@PathParam("name") String name) {
        Pessoa pessoa = new Pessoa();

        return "Pessoa com o nome de " + name + " foi deletada";
    }

    @PostMapping("/pessoa")
    public Pessoa addPessoa(@RequestParam String name, @RequestParam String sexo) {
        return controle.addPessoa(name, sexo);
    }

    @PutMapping
    public Pessoa updatePessoa(@PathParam("id") int id, @PathParam("name") String name) {
        Pessoa p = new Pessoa();
         return p;
    }

    @GetMapping("/home")
        public String helloWorld () {
            return "Hello world";
    }
}





