package com.example.appaspi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appaspi.basededados.Atendimento;
import com.example.appaspi.basededados.ListaFuncionarios;
import com.example.appaspi.basededados.ListaPaciente;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.P)
public class FormularioActivity extends AppCompatActivity {
    AtendimentoAdapter.RecycleViewOnClickListener listener;
    private List<String> listaEncontrase = Arrays.asList("Repouso","Acamado","Dormindo","Irritado","Alegre","Ansioso");
    private List<String> listaMedicamento = Arrays.asList("Omeprazol 1g", "Tylex 30 mg", "Soro","Adivíl");
    private ListaFuncionarios funcionarios = new ListaFuncionarios();
    private ListaPaciente pacientes = new ListaPaciente();

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_anotacoes);
        setTitle("Prontuário de Anotações");

        ListView listViewEncontrase = findViewById(R.id.list_encontrase);
        ListView listaViewMedicamento = findViewById(R.id.list_medicamento);
        Button btSalvar = findViewById(R.id.bt_add_observacao);

        listViewEncontrase.setAdapter(adapter(listaEncontrase));
        listaViewMedicamento.setAdapter(adapter(listaMedicamento));

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AtendimentoRecycleView.listaAtendimento.addAtendimento(new Atendimento(funcionarios.getFuncionario(1234),pacientes.getPaciente(002),new Date(),"13:29:00"));
                startActivity(new Intent(FormularioActivity.this, AtendimentoRecycleView.class));
            }
        });


        Intent intent = getIntent();
        if(intent.hasExtra("ItemSelecionado")){
            Atendimento atendimento = (Atendimento) intent.getParcelableExtra("ItemSelecionado");

            ListView listView = findViewById(R.id.list_medicamento);
            EditText editText = findViewById(R.id.caixa_de_texto);
            listView.setItemChecked(0,true);
            listView.setItemChecked(1,true);

            editText.setText(atendimento.getHora());
        }
    }


    public ArrayAdapter<String> adapter(List<String> lista){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_multiple_choice,lista);
        return adapter;
    }

}