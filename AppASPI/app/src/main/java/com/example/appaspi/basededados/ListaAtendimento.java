package com.example.appaspi.basededados;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.P)
public class ListaAtendimento{

    private List<Atendimento> atendimentoList = new ArrayList<>();
    private ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
    private  ListaPaciente listaPaciente = new ListaPaciente();

    public ListaAtendimento(){
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