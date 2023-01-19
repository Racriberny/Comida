package com.cristobalbernal.comida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cristobalbernal.comida.modelo.Alimentos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private Button btMenosPavo,btMasPavo,btMenosPollo,btMasPollo,btMenosSalmon,btMasSalmon,btMenosTernera,btMasTernera;
    private Button guardar,leer;
    public TextView pavo,pollo,salmon,ternera;
    private ArrayList<Alimentos> alimentos;
    private static final String FILE_NAME = "texto.txt";
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
        guardar = findViewById(R.id.btGuardar);
        leer = findViewById(R.id.btLeer);
        loadData();
        btMenosPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(pavo.getText().toString());
                if (numero == 0){
                    Toast.makeText(getBaseContext(),"El numero es 0",Toast.LENGTH_SHORT).show();
                }else {
                    numero--;
                    pavo.setText(String.valueOf(numero));
                }

            }
        });
        btMenosPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(pollo.getText().toString());
                if (numero == 0){
                    Toast.makeText(getBaseContext(),"El numero es 0",Toast.LENGTH_SHORT).show();
                }else {
                    numero--;
                    pollo.setText(String.valueOf(numero));
                }

            }
        });
        btMenosSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(salmon.getText().toString());
                if (numero == 0){
                    Toast.makeText(getBaseContext(),"El numero es 0",Toast.LENGTH_SHORT).show();
                }else {
                    numero--;
                    salmon.setText(String.valueOf(numero));
                }

            }
        });
        btMenosTernera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(ternera.getText().toString());
                if (numero == 0){
                    Toast.makeText(getBaseContext(),"El numero es 0",Toast.LENGTH_SHORT).show();
                }else {
                    numero--;
                    ternera.setText(String.valueOf(numero));
                }

            }
        });
        btMasPavo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(pavo.getText().toString());
                numero++;
                pavo.setText(String.valueOf(numero));
            }
        });
        btMasPollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(pollo.getText().toString());
                numero++;
                pollo.setText(String.valueOf(numero));
            }
        });
        btMasSalmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(salmon.getText().toString());
                numero++;
                salmon.setText(String.valueOf(numero));
            }
        });
        btMasTernera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(ternera.getText().toString());
                numero++;
                ternera.setText(String.valueOf(numero));
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
    }

    private void addItem() {
        int pavoNumero = Integer.parseInt(pavo.getText().toString());
        int polloNumero = Integer.parseInt(pollo.getText().toString());
        int salmonNumero = Integer.parseInt(salmon.getText().toString());
        int terneraNumero = Integer.parseInt(ternera.getText().toString());

        Alimentos pavo = new Alimentos(pavoNumero);
        Alimentos pollo = new Alimentos(polloNumero);
        Alimentos salmon = new Alimentos(salmonNumero);
        Alimentos ternera = new Alimentos(terneraNumero);
        alimentos.add(pavo);
        alimentos.add(pollo);
        alimentos.add(salmon);
        alimentos.add(ternera);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        saveFile();
    }

    private void saveFile() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(alimentos);
        editor.putString("todos", json);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("todos",null);
        Type type = new TypeToken<ArrayList<Alimentos>>() {}.getType();
        alimentos = gson.fromJson(json,type);
        if (alimentos == null) alimentos = new ArrayList<Alimentos>();
    }


}