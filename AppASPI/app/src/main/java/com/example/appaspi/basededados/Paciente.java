package com.example.appaspi.basededados;

import java.io.Serializable;
import java.util.List;

public class Paciente implements Serializable {
    private int id;
    private String nome;
    private List<Atendimento> atendimentos;
    private int tipo;

    public Paciente(int id, String nome, int tipo){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public void setAtendimentos(Atendimento atendimentos) {
        this.atendimentos.add(atendimentos);
    }

    public Atendimento getAtendimentos(int i) {
        return atendimentos.get(i);
    }


    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
