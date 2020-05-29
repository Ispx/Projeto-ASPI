package com.example.appaspi.basededados;
import android.os.Build;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {

    List<Funcionario> funcionariosList = new ArrayList<>();

    public ListaFuncionarios(){
        funcionariosList.add(new Funcionario("Maria Souza Carla",1234,Cargos.Enfermeiro));
        funcionariosList.add(new Funcionario("João Carlos",1235,Cargos.Enfermeiro));
        funcionariosList.add(new Funcionario("Pedro Paulo Santos",5734,Cargos.Enfermeiro));
        funcionariosList.add(new Funcionario("Vitor Vielela ",4567,Cargos.Enfermeiro));
        funcionariosList.add(new Funcionario("Henrique Pedro Barbosa",7894,Cargos.Enfermeiro));
        funcionariosList.add(new Funcionario("Karla Souza ",4563,Cargos.Medico));
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean verifyFuncionario(final int matricula){

        if(funcionariosList.stream().filter(x -> x.getMatricula() == matricula).count() > 0){
            return true;
        }

        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Funcionario getFuncionario(final int matricula){


        for( int i = 0 ; i < funcionariosList.size(); i ++){
            if(funcionariosList.get(i).getMatricula() == matricula){
                return funcionariosList.get(i);
            }
        }
        return null;
    }


}
