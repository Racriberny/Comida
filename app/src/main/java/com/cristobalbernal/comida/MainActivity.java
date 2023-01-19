package com.cristobalbernal.comida;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btMenosPavo,btMasPavo,btMenosPollo,btMasPollo,btMenosSalmon,btMasSalmon,btMenosTernera,btMasTernera;
    private TextView pavo,pollo,salmon,ternera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btMenosPavo = findViewById(R.id.btMenosPavo);
        btMasPavo = findViewById(R.id.btMasPavo);
        btMenosPollo = findViewById(R.id.btMenoPollo);
        btMasPollo = findViewById(R.id.btMasPollo);
        btMenosSalmon = findViewById(R.id.btMenoSalmon);
        btMasSalmon = findViewById(R.id.btMasSalmon);
        btMenosTernera = findViewById(R.id.btMenoTernera);
        btMasTernera = findViewById(R.id.btMasTernera);
        pavo = findViewById(R.id.txPavo);
        pollo = findViewById(R.id.txPollo);
        salmon = findViewById(R.id.txSalmon);
        ternera = findViewById(R.id.txTernera);
    }
}