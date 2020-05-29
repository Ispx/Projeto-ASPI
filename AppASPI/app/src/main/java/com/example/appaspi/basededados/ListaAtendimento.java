package com.example.appaspi.basededados;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.P)
public class ListaAtendimento {

    private List<Atendimento> atendimentoList = new ArrayList<>();
    private ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
    private  ListaPaciente listaPaciente = new ListaPaciente();

    public ListaAtendimento(){

        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1234), listaPaciente.getPaciente(001),new Date(), "08:00:11"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894),listaPaciente.getPaciente(003), new Date(), "11:11:02"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(5734), listaPaciente.getPaciente(002),new Date(), "12:00:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1235), listaPaciente.getPaciente(001),new Date(), "13:36:11"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894),listaPaciente.getPaciente(002), new Date(), "10:76:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1235), listaPaciente.getPaciente(001),new Date(), "06:56:45"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(4563), listaPaciente.getPaciente(002),new Date(), "08:00:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894),listaPaciente.getPaciente(001), new Date(), "10:65:57"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(5734), listaPaciente.getPaciente(002),new Date(), "10:00:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(5734), listaPaciente.getPaciente(002),new Date(), "08:00:56"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1235),listaPaciente.getPaciente(004), new Date(), "21:21:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1234), listaPaciente.getPaciente(002),new Date(), "10:23:53"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894), listaPaciente.getPaciente(002),new Date(), "08:52:12"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894),listaPaciente.getPaciente(002), new Date(), "10:43:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(4563), listaPaciente.getPaciente(002),new Date(), "10:59:23"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(5734), listaPaciente.getPaciente(002),new Date(), "08:54:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1235),listaPaciente.getPaciente(002), new Date(), "10:52:52"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894), listaPaciente.getPaciente(002),new Date(), "10:00:00"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(1234), listaPaciente.getPaciente(002),new Date(), "08:42:58"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(4563),listaPaciente.getPaciente(002), new Date(), "10:41:59"));
        atendimentoList.add(new Atendimento(listaFuncionarios.getFuncionario(7894), listaPaciente.getPaciente(002),new Date(), "10:47:01"));
    }

    public int qtdAtendimentosId(int id){

       return (int) atendimentoList.stream().filter(x-> x.getPaciente().getId() == id).count();

    }

    public void addAtendimento(Atendimento atendimento) {
        this.atendimentoList.add(atendimento);
    }

    public List<Atendimento> getAtendimentoId(int id) {

        List<Atendimento> list = new ArrayList<>();


        for(int i = 0 ; i < atendimentoList.size(); i ++){
            if(atendimentoList.get(i).getPaciente().getId() == id){

                list.add(atendimentoList.get(i));
            }
        }
        return list;
    }

}