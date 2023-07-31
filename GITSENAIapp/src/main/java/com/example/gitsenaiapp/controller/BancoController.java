package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.Conta;
import com.example.gitsenaiapp.model.ContaCorrentePF;
import com.example.gitsenaiapp.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoController implements ContaCorrente{
    @Autowired
    private BancoRepository bancoRepository;

    @Autowired
    private Controle controle;

    private Long number = 0L;
    @Override
    public Double sacar(Double quantidade, Conta conta) {
        return null;
    }

    public ContaCorrentePF criarConta(String name) throws Exception {
        ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
        number++;
        contaCorrentePF.setNumeroConta(number);
        Pessoa pessoa = controle.findPessoa(name);
        if(pessoa != null){
            contaCorrentePF.setPessoa(pessoa);
            bancoRepository.save(contaCorrentePF);
        }else{
            throw new Exception("Pessoa não está cadastrada");
        }

        return contaCorrentePF;
    }

    public ContaCorrentePF consultaConta(String name){

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for(ContaCorrentePF cc : contas){
            if(cc.getPessoa() != null && cc.getPessoa().getName().equals(name)){
                return cc;
            }
        }
        return null;
    }


    @Override
    public void sacar(Double quantidade) {

    }

    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade ;
        conta.setSaldo(total);
    }

    @Override
    public void transferir(Double quantidade, Conta conta) {

    }

    @Override
    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo();
    }
}
