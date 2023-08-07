package com.example.gitsenaiapp.model;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "conta")
public class ContaCorrentePF {
    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;
    private Double saldo;

    @OneToOne
    private Pessoa pessoa;

    @Column(name = "type")
    private AccountType accountType;

    @Transient
    private String error;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
