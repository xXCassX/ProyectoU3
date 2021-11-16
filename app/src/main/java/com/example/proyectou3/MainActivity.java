package com.example.proyectou3;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    Button botones;
    EditText texto1, texto2, txtResultado;
    RadioButton ra1, ra2, ra3, ra4, ra5, ra6;
    RadioGroup ra;
    String[] conjunto1, conjunto2;
    List<String> resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botones = (Button) findViewById(R.id.button);
        texto1 = (EditText) findViewById(R.id.c1);
        texto2 = (EditText) findViewById(R.id.c2);
        botones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=ra.getCheckedRadioButtonId();
                Toast asdf=Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG);
                asdf.show();
                CrearConjunto(texto1.getText().toString(),texto2.getText().toString());
                try{
                    switch (id){
                        case R.id.Union: OpUnion(conjunto1,conjunto2); break;
                        case R.id.Interseccion: OpInterseccion(conjunto1,conjunto2);break;
                        case R.id.diferencia: OpDiferencia(conjunto1,conjunto2);break;
                        case R.id.complemento: OpComplemento(conjunto1,conjunto2);break;
                        case R.id.pertenencia: OpPertenencia(conjunto1,conjunto2);break;
                        case R.id.igualdad: OpIgualdad(conjunto1,conjunto2);break;
                    }

                }catch (Exception e){
                    String cade = "chingo su madre" + e.getCause();
                    Toast notifica = Toast.makeText(getApplicationContext(),cade,Toast.LENGTH_LONG);
                    notifica.show();
                }
            }
        });


        txtResultado = (EditText) findViewById(R.id.resultados);
        ra = (RadioGroup) findViewById(R.id.gruporadio);
        ra1 = (RadioButton) findViewById(R.id.Union);
        ra2 = (RadioButton) findViewById(R.id.Interseccion);
        ra3 = (RadioButton) findViewById(R.id.diferencia);
        ra4 = (RadioButton) findViewById(R.id.complemento);
        ra5 = (RadioButton) findViewById(R.id.pertenencia);
        ra6 = (RadioButton) findViewById(R.id.igualdad);
    }


    public void CrearConjunto(String cade1, String cade2){
        conjunto1 = cade1.split(","); //Split: se separara la cadena por comas
        conjunto2 = cade2.split(",");
    }

   /* public void OpUnion(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        for(int i=0;i<cade1.length;i++){
            resultado.add(cade1[i]);
        }
        for (int i=0;i<cade2.length;i++){
            for(int j=i;j< cade1.length;j++){
                if(cade2[i]!=cade1[j]){

                }
            }
        }
    }*/

    public void OpUnion(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.addAll(Arrays.asList(cade2));
        resultado= (List<String>) res;

        String cadena = "";
        for(int i=0; i<resultado.size(); i++){
            cadena = cadena + resultado.toString();
        }
        txtResultado.setText(cadena);
    }

    public void OpInterseccion(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.retainAll(Arrays.asList(cade2));
        resultado= (List<String>) res;

        String cadena = "";
        for(int i=0; i<resultado.size(); i++){
            cadena = cadena + resultado.toString();
        }
        txtResultado.setText(cadena);
    }

    public void OpDiferencia(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.removeAll(Arrays.asList(cade2));
        resultado= (List<String>) res;

        String cadena = "";
        for(int i=0; i<resultado.size(); i++){
            cadena = cadena + resultado.toString();
        }
        txtResultado.setText(cadena);
    }

    public void OpComplemento(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.addAll(Arrays.asList(cade2));
        res.removeAll(Arrays.asList(cade1));

        resultado= (List<String>) res;

        String cadena = "";
        for(int i=0; i<resultado.size(); i++){
            cadena = cadena + resultado.toString();
        }
        txtResultado.setText("Los elementos "+cadena+" del conjunto B son complementos del conjunto A");
    }

    public void OpPertenencia(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        res.retainAll(Arrays.asList(cade2));
        resultado= (List<String>) res;

        String cadena = "";
        for(int i=0; i<resultado.size(); i++){
            cadena = cadena + resultado.toString();
        }
        txtResultado.setText("Los elemntos "+cadena+" del conjunto B pertenecen a el conjunto A");
    }

    public void OpIgualdad(String[] cade1, String[] cade2){
        resultado=new ArrayList<String>();
        Set res= new TreeSet(Arrays.asList(cade1));
        if(res.equals(Arrays.asList(cade2))){
            txtResultado.setText("Son iguales");
        }else{
            txtResultado.setText("Son diferentes");
        }

    }

}