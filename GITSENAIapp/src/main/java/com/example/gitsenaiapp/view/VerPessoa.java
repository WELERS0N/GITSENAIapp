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
    public String deletePessoa(@PathParam("name") String name) {
        controle.removePessoa(name);

        return "Pessoa com o nome de " + name + " foi deletada";
    }

    @PostMapping("/pessoa")
    public Pessoa addPessoa(@RequestParam String name, @RequestParam String sexo) {
        return controle.addPessoa(name, sexo);
    }

    @PutMapping("/pessoa")
    public Pessoa updatePessoa(@PathParam("name") String name, @PathParam("sexo") String sexo) {
       return controle.editPessoa(name, sexo);
    }

    @GetMapping("/all")
    public List<Pessoa> listAll(){
        return controle.listAll();
    }

    @GetMapping("/home")
        public String helloWorld () {
            return "Hello world";
    }
}





