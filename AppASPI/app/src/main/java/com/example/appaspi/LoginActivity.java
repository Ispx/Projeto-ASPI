package com.example.appaspi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import com.example.appaspi.basededados.ListaFuncionarios;
import com.example.appaspi.basededados.ListaPaciente;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LoginActivity extends AppCompatActivity {
    static ListaFuncionarios funcionarios = new ListaFuncionarios();
    static ListaPaciente pacientes = new ListaPaciente();
    public static int matricula = 1234;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        setTitle("Acesso ao ASPI");

        final Button btlogin = findViewById(R.id.btlogin);
        final EditText textMatricula = findViewById(R.id.matriculalogin);

        final String matriculastr = textMatricula.getText().toString();
       // this.matricula = Integer.parseInt(matriculastr);

        btlogin.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                //Validação do usuário
                if(funcionarios.verifyFuncionario(matricula) == true){
                    startActivity(new Intent(LoginActivity.this, AtendimentoRecycleView.class));
                    finish();
                }
                else{

                    //Tratamento de erro
                    textMatricula.setHighlightColor(R.color.colorPrimary);
                    textMatricula.setTextColor(R.color.colorPrimaryDark);

                }
            }
        });
    }

}


