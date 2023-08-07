package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Conta;
import com.example.gitsenaiapp.model.ContaCorrentePF;

public interface ContaCorrente {

    Double sacar(Double quantidade, Conta conta);


    void depositar(Double quantidade, Conta conta);

    String transferir(Long contaOrigem, Long contaDestina, Double valor);

    Double consultaSaldo(ContaCorrentePF conta);



}
