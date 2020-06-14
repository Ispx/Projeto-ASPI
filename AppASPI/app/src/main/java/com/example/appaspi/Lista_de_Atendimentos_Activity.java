package com.example.appaspi;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appaspi.basededados.Atendimento;
import com.example.appaspi.basededados.ListaAtendimento;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.P)
public class Lista_de_Atendimentos_Activity extends AppCompatActivity implements Lista_de_Atendimentos_Adapter.RecycleViewOnClickListener {
    private EditText editText;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recycleAdapter;
    private RecyclerView.LayoutManager recycleManager;


    public static ListaAtendimento listaAtendimento = new ListaAtendimento();
    public static int matricula;



    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_atendimentos);
        setTitle("Histório de Atendimentos");

        editText = findViewById(R.id.alert_informacoes_edittext_observacao);

        //Carregando view RecyclerView
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recycleManager = new LinearLayoutManager(this);

        //Valores do parâmetros: Objeto do tipo Atendimento e o contexto da classe ao objeto da interface.
        recycleAdapter = new Lista_de_Atendimentos_Adapter(listaAtendimento.getAtendimentoId(002),this);
        recyclerView.setLayoutManager(recycleManager);
        recyclerView.setAdapter(recycleAdapter);

        //Capturando dados enviados do LoginActivity, que no caso é o login do profissional
        Intent capturarIntent = getIntent();
        Bundle capturandoExtras = capturarIntent.getExtras();
        matricula = 1234;

    }

    public void addAtendimento(View view){

        //Evento de transferencia de activity ao clicar no botão
        startActivity(new Intent(Lista_de_Atendimentos_Activity.this, Fazer_Anotacoes_Activity.class));

    }

    @Override
    public void itemSelecionado(Atendimento atendimento, int posicao, View view) {

        //Criando um objeto do tipo Intent para transferir dados para outra Activity através do método putExtra
        Intent transferirDadosParaOutraActivity = new Intent(Lista_de_Atendimentos_Activity.this,Visualizar_Anotacoes_Activity.class);

        //Determinado o nome da transação e dado a ser transferindo
        transferirDadosParaOutraActivity.putExtra("atendimento",atendimento);

        //Começando a transação
        startActivity(transferirDadosParaOutraActivity);

    }


}

class Lista_de_Atendimentos_Adapter extends RecyclerView.Adapter<Lista_de_Atendimentos_Adapter.AtendimentoViewHolder> {
    private List<Atendimento> listaAtendimento;
    RecycleViewOnClickListener listener;

    public Lista_de_Atendimentos_Adapter(List<Atendimento> listaAtendimento, RecycleViewOnClickListener listener) {
        this.listaAtendimento = listaAtendimento;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AtendimentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      //Inflando todos das as views do layout de itens a atribuindo a um objeto do tipo view, pesteriormente este objeto
      //será passando como parametro da classe AtedimentoViewHolder que será instanciada dentro deste método.
        // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false);

        return new AtendimentoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itens, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onBindViewHolder(@NonNull AtendimentoViewHolder holder, int position) {
        //O objeto hoder do tipo viewHolder tem todos os elementos que foram inflados através do método onCreateViewHolder
        //e será através do mesmo que outras views poderam ser instanciadas para atribuição de valor.

        Atendimento atendimento = this.listaAtendimento.get(position);

        //Atribuindo valores as views da classe viewHolder
        holder.nome.setText(atendimento.getFuncionario().getNome());
        holder.funcao.setText(atendimento.getFuncionario().getCargo());
        holder.data.setText(atendimento.getData());
        holder.hora.setText(atendimento.getHora());

    }

    //Quantidade de elementos a ser listados
    @Override
    public int getItemCount() {
        return listaAtendimento.size();
    }

    //Criando uma interface para eventos de click e determinando os atributos que quero capturar após o click.
    public interface RecycleViewOnClickListener {
        void itemSelecionado(Atendimento objeto, int posicao, View view);
    }

    class AtendimentoViewHolder extends RecyclerView.ViewHolder{

        //As views serão atribuidas na classe ViewHolder
        protected TextView nome;
        protected TextView funcao;
        protected TextView data;
        protected TextView hora;


        //Construtor
        public AtendimentoViewHolder(@NonNull View itemView) {
            super(itemView);

            //Atribuindo aos atributos do tipo view da classe interna
            nome = itemView.findViewById(R.id.nome);
            funcao = itemView.findViewById(R.id.cargo);
            data = itemView.findViewById(R.id.data);
            hora = itemView.findViewById(R.id.hora);

            //Chamando um evento de clique.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Carregando valores aos atributos dos parâmetros do método da interface de evento de clicks (objeto,posicao,view)
                    listener.itemSelecionado(listaAtendimento.get(getAdapterPosition()),getAdapterPosition(),itemView);
                }
            });


        }


    }
}
