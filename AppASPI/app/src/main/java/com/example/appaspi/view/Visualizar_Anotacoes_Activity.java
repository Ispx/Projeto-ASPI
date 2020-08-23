package com.example.appaspi.view;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appaspi.R;
import com.example.appaspi.models.Atendimento;

public class Visualizar_Anotacoes_Activity extends AppCompatActivity {

    private ListView listViewEncontrase;
    private ListView listaViewMedicamento;
    private EditText observacao;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_visualizar_anotacoes);

          this.listViewEncontrase = findViewById(R.id.visualizar_estado);
          this.listaViewMedicamento = findViewById(R.id.visualizar_medicacao);
          this.observacao = findViewById(R.id.visualizar_observacao);

        Intent intent = new Intent();
        Atendimento atendimento = intent.getParcelableExtra("atendimento");

        this.listViewEncontrase = atendimento.getListViewEncontrase();

        this.listaViewMedicamento = atendimento.getListaViewMedicamento();


    }
}
