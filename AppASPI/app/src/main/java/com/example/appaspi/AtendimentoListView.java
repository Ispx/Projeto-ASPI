package com.example.appaspi;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import com.example.appaspi.basededados.Atendimento;
import com.example.appaspi.basededados.ListaAtendimento;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AtendimentoListView extends AppCompatActivity {

    private ListaAtendimento listaAtendimento = new ListaAtendimento();


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimento_list);


        AdapterClass adapterClass = new AdapterClass(this,listaAtendimento.getAtendimentoId(002));


        //Criando um objeto listView para receber um listview, posteriormente o mesmo deverá receber através do mesmo
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapterClass);



    }
}

@RequiresApi(api = Build.VERSION_CODES.N)
class AdapterClass extends ArrayAdapter<Atendimento>{

    private Context context;
    private List<Atendimento> listaAtendimento;


    //Através do construtor se chama faz a atribuição dos valores do objeto ArraysList e do contexto
    public AdapterClass(Context context, List<Atendimento> lista){
        super(context,R.layout.itens, lista);

        this.context = context;
        listaAtendimento = lista;

    }

    /*
    Através do método getView que atribui valores aos views do layout
    Para isso nós instanciamos o objeto do contrutor View através do LayoutInflater passando o contexto como parametro e inflando
    o layout dos itens, é este objeto (convertView) que ira receber todos os elementos do layout para atribuição de valores.

    Após isso criamos um objeto principal referente ao arraylist que recebera uma posição da listagem que será instanciada no parametro.

    Com isso, atribuimos valores dentro de cada view.


     */


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Atendimento atendimento = this.listaAtendimento.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.itens,null);


        //Fazendo atribuição dos objetos TextView através do objeto convertView
        TextView nome = convertView.findViewById(R.id.nome);
        TextView funcao = convertView.findViewById(R.id.funcao);
        TextView data = convertView.findViewById(R.id.data);
        TextView hora = convertView.findViewById(R.id.hora);

        nome.setText(atendimento.getFuncionario().getNome());
        funcao.setText(atendimento.getFuncionario().getCargo());
        data.setText(atendimento.getData());
        hora.setText(atendimento.getHora());

        return convertView;
    }


}