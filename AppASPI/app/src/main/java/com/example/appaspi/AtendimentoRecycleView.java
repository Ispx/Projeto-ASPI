package com.example.appaspi;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
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
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.P)
public class AtendimentoRecycleView extends AppCompatActivity implements AtendimentoAdapter.RecycleViewOnClickListener {
    private EditText editText;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recycleAdapter;
    private RecyclerView.LayoutManager recycleManager;
    private ListaAtendimento listaAtendimento = new ListaAtendimento();


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimento_recycle);
        setTitle("Histório de Atendimentos");

        editText = findViewById(R.id.alert_informacoes_edittext_observacao);

        // setOnClickListener();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recycleManager = new LinearLayoutManager(this);

        //Valores do parâmetros: Objeto do tipo Atendimento e o contexto da classe ao objeto da interface.
        recycleAdapter = new AtendimentoAdapter(listaAtendimento.getAtendimentoId(002),this);
        recyclerView.setLayoutManager(recycleManager);
        recyclerView.setAdapter(recycleAdapter);

        Button addAtendimento = findViewById(R.id.addatendimento); //Instanciação do botão de adicionar um novo atendimento
        addAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AtendimentoRecycleView.this, FormularioActivity.class));
            }
        });
    }

    @Override
    public void itemSelecionado(Atendimento atendimento,int posicao, View itemView) {
        Toast.makeText(AtendimentoRecycleView.this,atendimento.getFuncionario().getNome() + ", Posição: " + posicao,Toast.LENGTH_LONG).show();
    }
}

class AtendimentoAdapter extends RecyclerView.Adapter<AtendimentoAdapter.AtendimentoViewHolder> {
    private List<Atendimento> listaAtendimento;
    private RecycleViewOnClickListener listener;

    public AtendimentoAdapter(List<Atendimento> listaAtendimento, RecycleViewOnClickListener listener) {
        this.listaAtendimento = listaAtendimento;
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

        holder.nome.setText(atendimento.getFuncionario().getNome());
        holder.funcao.setText(atendimento.getFuncionario().getCargo());
        holder.data.setText(atendimento.getData());
        holder.hora.setText(atendimento.getHora());

    }

    @Override
    public int getItemCount() {
        return listaAtendimento.size();
    }

    //Criando uma interface anônima para para capturar a o objeto, a posição e a view clicada.
    public interface RecycleViewOnClickListener {
        void itemSelecionado(Atendimento objeto, int posicao, View view);
    }

    class AtendimentoViewHolder extends RecyclerView.ViewHolder{
        //Atributos da classe
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
                    //Carregando valores aos atributos dos parâmetros (objeto,posicao,view)
                    listener.itemSelecionado(listaAtendimento.get(getAdapterPosition()),getAdapterPosition(),itemView);
                }
            });


        }


    }
}
