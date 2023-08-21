package com.example.gitsenaiapp.controller;

import com.example.gitsenaiapp.model.AccountType;
import com.example.gitsenaiapp.model.Conta;
import com.example.gitsenaiapp.model.ContaCorrentePF;
import com.example.gitsenaiapp.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void delete(String name){
        bancoRepository.delete(this.consultaConta(name));
    }
    public ContaCorrentePF criarConta(String name, String accountType) throws Exception {
        ContaCorrentePF contaCorrentePF = new ContaCorrentePF();
        StringBuilder message = new StringBuilder();
        if(accountType == null) {
            message.append("\nNecessário informar o tipo da conta!");
        }
        switch (accountType) {
            case "POUPANCA":
                contaCorrentePF.setAccountType(AccountType.CONTA_POUPANCA);
                break;
            case "CORRENTE":
                contaCorrentePF.setAccountType(AccountType.CONTA_CORRENTE);
            default:
                message.append("\nTipo da conta não é suportado!");
        }
        Pessoa pessoa = controle.findPessoa(name);
        if(pessoa != null && contaCorrentePF.getError() == null){
            number++;
            contaCorrentePF.setNumeroConta(number);
            contaCorrentePF.setPessoa(pessoa);
            bancoRepository.save(contaCorrentePF);
        }else if (contaCorrentePF.getError() == null){
            message.append("\nPessoa ");
            message.append(name).append(" informada não foi cadastrada");
        }
        if(!message.isEmpty()) {
            contaCorrentePF.setError(message.toString());
        }
        return contaCorrentePF;
    }

    public ContaCorrentePF consultaConta(String name){

        List<ContaCorrentePF> contas = (List<ContaCorrentePF>) bancoRepository.findAll();

        for(ContaCorrentePF cc : contas){
            if(cc.getPessoa() != null && cc.getPessoa().getName().equals(name)) {
                if (cc.getDataAtualizacao().equals(new Date()))
                    return cc;
            }
        }
        return null;
    }
    @Override
    public void depositar(Double quantidade, Conta conta) {
        Double total = conta.getSaldo() + quantidade ;
        conta.setSaldo(total);
    }

    @Override
    public String transferir(Long contaOrigem, Long contaDestino, Double valor) {
        String message = "";
        ContaCorrentePF destino = bancoRepository.findById(contaDestino).get();
        ContaCorrentePF origem = bancoRepository.findById(contaOrigem).get();

        if(origem.getSaldo() >= valor){
            destino.setSaldo(destino.getSaldo() + valor);
            origem.setSaldo(origem.getSaldo() - valor);
            bancoRepository.save(destino);
            bancoRepository.save(origem);
            message = "A conta do(a) " + destino.getPessoa().getName() + " recebeu a transferência no valor de R$ " + valor;
        }else{
            message = message + " Saldo insuficiente para a operação";
        }

        return message;
    }

    @Override
    public Double consultaSaldo(ContaCorrentePF conta) {
        return conta.getSaldo();
    }
}
