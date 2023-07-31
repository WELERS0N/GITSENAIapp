package com.example.gitsenaiapp.model;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class ContaCorrentePF {
    @Id
    @Column(name = "numero_conta")
    private Long numeroConta;

    //private Person pessoa;

    private Double saldo;

    @OneToOne
    private Pessoa pessoa;

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

    /*public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }*/

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
