package com.example.appaspi.basededados;


import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.P)
public class Atendimento extends AppCompatActivity implements Serializable
{
    private Funcionario funcionario;
    private Date data;
    private DateFormat dateFormat = DateFormat.getDateInstance();
    private DateFormat horaFormat = DateFormat.getTimeInstance();
    private Paciente paciente;
    private EditText observacao;
    private ListView listViewEncontrase;
    private ListView listaViewMedicamento;

    public Atendimento(Funcionario funcionarios, Paciente paciente, Date data) {
        this.funcionario = funcionarios;
        this.data = data;
        this.paciente = paciente;
    }



    public String getData() { return dateFormat.format(data); }

    public Paciente getPaciente() {
        return paciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getHora(){
        return horaFormat.format(data);
      }

     public ListView getListaViewMedicamento() { return listaViewMedicamento; }

    public ListView getListViewEncontrase() { return listViewEncontrase; }

    public void setListaViewMedicamento(ListView listaViewMedicamento) { this.listaViewMedicamento = listaViewMedicamento; }

    public void setListViewEncontrase(ListView listViewEncontrase) { this.listViewEncontrase = listViewEncontrase; }

    public EditText getObservacao() {
        return observacao;
    }

    public void setObservacao(EditText observacao) {
        this.observacao = observacao;
    }

}
