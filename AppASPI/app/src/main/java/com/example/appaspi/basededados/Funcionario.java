package com.example.appaspi.basededados;

import java.io.Serializable;
import java.util.List;

public class Funcionario implements Serializable {
    private int matricula;
    private Cargos cargo;
    private String nome;
    private List<Atendimento> atendimentos;

    public Funcionario(String nome, int matricula, Cargos cargo){
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo.toString();
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setAtendimentos(Atendimento atendimento){
        this.atendimentos.add(atendimento);
    }
    public List<Atendimento> getAtendimentos(){return atendimentos;}

}
