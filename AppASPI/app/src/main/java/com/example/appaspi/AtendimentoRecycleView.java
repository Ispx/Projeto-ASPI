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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.example.appaspi.basededados.ListaFuncionarios;

import java.util.Collections;
import java.util.List;

import static com.example.appaspi.LoginActivity.pacientes;

@RequiresApi(api = Build.VERSION_CODES.P)
public class AtendimentoRecycleView extends AppCompatActivity implements AtendimentoAdapter.RecycleViewOnClickListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter recycleAdapter;
    RecyclerView.LayoutManager recycleManager;
    public static ListaAtendimento listaAtendimento = new ListaAtendimento();

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimento_recycle);
        setTitle("Histório de Atendimentos");

       // setOnClickListener();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recycleManager = new LinearLayoutManager(this);
        recycleAdapter = new AtendimentoAdapter(listaAtendimento.getAtendimentoId(002),this);
        recyclerView.setLayoutManager(recycleManager);
        recyclerView.setAdapter(recycleAdapter);


        Button bt = findViewById(R.id.addatendimento); //Instanciação do botão de adicionar um novo atendimento
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AtendimentoRecycleView.this, FormularioActivity.class));
            }
        });



    }

    @Override
    public void itemSelecionado(Atendimento atendimento) {
       // startActivity(new Intent(AtendimentoRecycleView.this, FormularioActivity.class).putExtra("ItemSelecionado",atendimento));
    }
}

class AtendimentoAdapter extends RecyclerView.Adapter<AtendimentoAdapter.AtendimentoViewHolder> {
    private List<Atendimento> listaAtendimento;
    private RecycleViewOnClickListener listener;
    private TextView nome;
    private TextView funcao;
    private TextView data;
    private TextView hora;


    public AtendimentoAdapter(List<Atendimento> listaAtendimento, RecycleViewOnClickListener listener) {
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

        this.nome = holder.itemView.findViewById(R.id.nome);
        this.funcao = holder.itemView.findViewById(R.id.cargo);
        this.data = holder.itemView.findViewById(R.id.data);
        this.hora = holder.itemView.findViewById(R.id.hora);

        this.nome.setText(atendimento.getFuncionario().getNome());
        this.funcao.setText(atendimento.getFuncionario().getCargo());
        this.data.setText(atendimento.getData());
        this.hora.setText(atendimento.getHora());


    }

    @Override
    public int getItemCount() {
        return listaAtendimento.size();
    }

    //Criando uma interface anônima para para capturar a view clicada e sua posição.
    public interface RecycleViewOnClickListener{
        void itemSelecionado(Atendimento atendimento);
    }

    class AtendimentoViewHolder extends RecyclerView.ViewHolder{

        public AtendimentoViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemSelecionado(listaAtendimento.get(getAdapterPosition()));
                }
            });
        }
    }
}
