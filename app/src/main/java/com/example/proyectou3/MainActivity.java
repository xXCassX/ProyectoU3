package com.example.proyectou3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BlendMode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button botones;
    EditText texto1, texto2, txtResultado;
    RadioButton ra1, ra2, ra3, ra4, ra5, ra6;
    RadioGroup ra;
    String[] conjunto1, conjunto2;
    List<String> resultado;
    //ghfghfgh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botones = (Button) findViewById(R.id.button);
        botones.setOnClickListener(this);
        texto1 = (EditText) findViewById(R.id.c1);
        texto2 = (EditText) findViewById(R.id.c2);

        txtResultado = (EditText) findViewById(R.id.resultados);
        ra = (RadioGroup) findViewById(R.id.gruporadio);
        ra1 = (RadioButton) findViewById(R.id.Union);
        ra2 = (RadioButton) findViewById(R.id.Interseccion);
        ra3 = (RadioButton) findViewById(R.id.diferencia);
        ra4 = (RadioButton) findViewById(R.id.complemento);
        ra5 = (RadioButton) findViewById(R.id.pertenencia);
        ra6 = (RadioButton) findViewById(R.id.igualdad);
    }

    @Override
    public void onClick(View view){
        try {
            CrearConjunto(texto1.getText().toString(), texto2.getText().toString());

            if (ra1.isChecked()) {
                OpUnion(conjunto1, conjunto2);
            } else if (ra2.isChecked()) {
                OpInterseccion(conjunto1, conjunto2);
            } else if (ra3.isChecked()) {
                OpDiferencia(conjunto1, conjunto2);
            } else if (ra4.isChecked()) {
                OpComplemento(conjunto1, conjunto2);
            } else if (ra5.isChecked()) {
                OpPertenencia(conjunto1, conjunto2);
            } else if (ra6.isChecked()) {
                OpIgualdad(conjunto1, conjunto2);
            }
        }catch (Exception e){
            Toast toast=Toast.makeText(getApplicationContext(),"Causa + "+e.getCause(), Toast.LENGTH_LONG);
        }
    }


    public void CrearConjunto(String cade1, String cade2){
        conjunto1 = cade1.split(","); //Split: se separara la cadena por comas
        conjunto2 = cade2.split(",");
        String cadena="";
        for (int i=0;i<conjunto1.length;i++){
            cadena=cadena+conjunto1[i].toString();
        }

    }


    public void OpUnion(String[] cade1, String[] cade2){
        String cadena="";
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.addAll(Arrays.asList(cade2));
        cadena =res.toString();
        txtResultado.setText(cadena);
    }

    public void OpInterseccion(String[] cade1, String[] cade2){
        String cadena="";
        Set res= new TreeSet(Arrays.asList(cade1));
        res.retainAll(Arrays.asList(cade2));
        cadena=res.toString();
        txtResultado.setText(cadena);
    }

    public void OpDiferencia(String[] cade1, String[] cade2){
        String cadena="";
        Set res= new TreeSet(Arrays.asList(cade1));
        res.removeAll(Arrays.asList(cade2));
        cadena=res.toString();
        txtResultado.setText(cadena);
    }

    public void OpComplemento(String[] cade1, String[] cade2){
        String cadena="";
        Set res= new TreeSet(Arrays.asList(cade1));
        res.addAll(Arrays.asList(cade2));
        res.removeAll(Arrays.asList(cade1));
        cadena=res.toString();
        txtResultado.setText("Los elementos "+cadena+" del conjunto B son complementos del conjunto A");
    }

    public void OpPertenencia(String[] cade1, String[] cade2){
        String cadena="";
        Set res= new TreeSet(Arrays.asList(cade1));
        res.retainAll(Arrays.asList(cade2));
        cadena=res.toString();
        txtResultado.setText("Los elemntos "+cadena+" del conjunto B pertenecen al conjunto A");
    }

    public void OpIgualdad(String[] cade1, String[] cade2){

        Set res= new TreeSet(Arrays.asList(cade1)), cad2=new TreeSet(Arrays.asList(cade2));

        if(res.equals(cad2)){
            txtResultado.setText("Son iguales");
        }else{
            txtResultado.setText("Son diferentes");
        }

    }

}