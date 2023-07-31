package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Conta;
import com.example.gitsenaiapp.model.ContaCorrentePF;

public interface ContaCorrente {

    Double sacar(Double quantidade, Conta conta);

    void sacar(Double quantidade);
    void depositar(Double quantidade, Conta conta);

    void transferir(Double quantidade, Conta conta);

    Double consultaSaldo(ContaCorrentePF conta);



}
