package com.example.appaspi.basededados;

import android.app.AppComponentFactory;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.P)
public class Atendimento implements Parcelable {
    private Funcionario funcionario;
    private Date data;
    private DateFormat dateFormat = DateFormat.getDateInstance();
    private DateFormat horaFormat = DateFormat.getTimeInstance();
    private Paciente paciente;

    public Atendimento(Funcionario funcionarios, Paciente paciente, Date data, String hora) {
        this.funcionario = funcionarios;
        this.data = data;
        this.paciente = paciente;
    }

    public Atendimento(Parcel in) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public static final Creator<Atendimento> CREATOR = new Creator<Atendimento>() {
        @Override
        public Atendimento createFromParcel(Parcel in) {
            return new Atendimento(in);
        }

        @Override
        public Atendimento[] newArray(int size) {
            return new Atendimento[size];
        }
    };

    public String getData() {
        return dateFormat.format(data);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
     public String getHora(){
        return horaFormat.format(data);
      }


}