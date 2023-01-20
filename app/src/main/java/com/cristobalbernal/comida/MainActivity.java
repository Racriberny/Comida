package com.cristobalbernal.comida;

import androidx.appcompat.app.AppCompatActivity;
import android.preference.*;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable {
    private Button btMenosPavo,btMasPavo,btMenosPollo,btMasPollo,btMenosSalmon,btMasSalmon,btMenosTernera,btMasTernera;
    public TextView pavo,pollo,salmon,ternera;
    public int contadorPavo,contadorPollo,contadorSalmon,contadorTernera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contadorPavo = 0;
        contadorPollo = 0;
        btMasPavo = findViewById(R.id.btMasPavo);
        btMenosPavo = findViewById(R.id.btMenosPavo);
        btMenosPollo = findViewById(R.id.btMenosPollo);
        btMasPollo = findViewById(R.id.btMasPollo);
        pavo = findViewById(R.id.txPavo);
        pollo = findViewById(R.id.txPollo);
        pavo.setText("" + contadorPavo);
        pollo.setText("" +contadorPollo);
        btMasPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContadorPavo();
            }
        });
        btMenosPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorPavo();
            }
        });
        btMasPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarContadorPollo();
            }
        });
        btMenosPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementarContadorPollo();
            }
        });
    }

    private void decrementarContadorPollo() {
        if (contadorPollo == 0){
            Toast.makeText(this,"Estas intentado quedarte en -0",Toast.LENGTH_SHORT).show();
        }else {
            contadorPollo--;
            pollo.setText(contadorPollo + "");
        }
    }

    private void incrementarContadorPollo() {
        contadorPollo++;
        pollo.setText("" + contadorPollo);
    }

    private void decrementarContadorPavo() {
        if (contadorPavo == 0){
            Toast.makeText(this,"Estas intentado quedarte en -0",Toast.LENGTH_SHORT).show();
        }else {
            contadorPavo--;
            pavo.setText(contadorPavo + "");
        }
    }

    private void incrementarContadorPavo() {
        contadorPavo++;
        pavo.setText(contadorPavo + "");
    }


    public void onPause() {
        super.onPause();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor miEditor = datos.edit();
        miEditor.putInt("pavo",contadorPavo);
        miEditor.putInt("pollo",contadorPollo);
        miEditor.apply();

    }

    public void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        contadorPavo = datos.getInt("pavo",0);
        contadorPollo = datos.getInt("pollo",0);
        pavo.setText(""+contadorPavo);
        pollo.setText("" + contadorPollo);
    }
}