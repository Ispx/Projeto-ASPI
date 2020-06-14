package com.example.appaspi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    public EditText textMatricula;
    public Button btlogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        setTitle("Acesso ao ASPI");

        btlogin = findViewById(R.id.btlogin);
        textMatricula = findViewById(R.id.matriculalogin);

        Editable text = textMatricula.getText();
        String matriculastr = text.toString();
        this.matricula = 1234;

        btlogin.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                //Validação do usuário
                if(funcionarios.verifyFuncionario(matricula) == true){

                    Intent dados = new Intent(LoginActivity.this,Lista_de_Atendimentos_Activity.class);
                    dados.putExtra("matricula",matricula);
                    startActivity(dados);
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Matricula não identificada",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}


