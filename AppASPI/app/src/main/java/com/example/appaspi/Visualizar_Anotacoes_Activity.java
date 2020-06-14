package com.example.appaspi;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appaspi.basededados.Atendimento;

public class Visualizar_Anotacoes_Activity extends AppCompatActivity {

    private ListView listViewEncontrase;
    private ListView listaViewMedicamento;
    private EditText observacao;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_visualizar_anotacoes);

        this.listViewEncontrase = findViewById(R.id.alert_list_encotnrase);
        this.listaViewMedicamento = findViewById(R.id.alert_list_medicacao);
        this.observacao = findViewById(R.id.alert_informacoes_edittext_observacao);

        Intent intent = getIntent();
        Atendimento atendimento = (Atendimento) intent.getSerializableExtra("atendimento");

        this.listaViewMedicamento = atendimento.getListaViewMedicamento();
        this.listViewEncontrase = atendimento.getListViewEncontrase();
        this.observacao = atendimento.getObservacao();


    }
}
