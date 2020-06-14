package com.example.appaspi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appaspi.basededados.ListaPaciente;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    public static int idPaciente = 002;
    Button btqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dados do Paciente");



        final Activity activity = this;
       btqr = findViewById(R.id.btqr);

       btqr.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


                   IntentIntegrator integrator = new IntentIntegrator(activity);
                   integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                   integrator.setPrompt("Capturando dados do paciente");
                   integrator.setCameraId(0);
                   integrator.initiateScan();


           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result != null && result.getContents() != null){

            //capturou algo
            idPaciente = Integer.parseInt(result.getContents());

            startActivity(new Intent(MainActivity.this, Lista_de_Atendimentos_Activity.class)); //Migrando para AtendimentosActivity
        }
        else {

            super.onActivityResult(requestCode, resultCode, data);
        }

    }
}