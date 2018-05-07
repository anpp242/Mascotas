package com.edu.omar.mascotas;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class confirmacion extends AppCompatActivity {

    private TextView saludo, text_entrada, resultados, tipoM;
    private EditText peso;
    private Typeface grotesk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        String fonts ="fuentes/grotesk.ttf";
        this.grotesk = Typeface.createFromAsset(getAssets(), fonts);

        paramsFormulario();

        peso = (EditText)findViewById(R.id.peso);
        peso.setTypeface(grotesk);

        resultados = (TextView)findViewById(R.id.resultados);
        resultados.setTypeface(grotesk);

    }

    private void paramsFormulario(){
        String np = getIntent().getStringExtra("dNombre");
        String nm = getIntent().getStringExtra("nMascota");
        String tm = getIntent().getStringExtra("tm");

        saludo = (TextView)findViewById(R.id.Saludo);
        saludo.setTypeface(grotesk);
        saludo.setText("Hola "+np+" y "+nm);

        text_entrada = (TextView)findViewById(R.id.text_entrada);
        text_entrada.setText("Aquí podrás elegir la cantiad de comida apropiada para "+nm);
        text_entrada.setTypeface(grotesk);

        tipoM = (TextView)findViewById(R.id.tm);
        tipoM.setText(tm);
        tipoM.setTypeface(grotesk);
    }

    public void calculoP (View v){
        String pString = peso.getText().toString();
        double pesoN = Double.parseDouble(pString);

        if(pesoN >= 0 && pesoN < 3){
            resultados.setText("Es una mascota cachorra, basta con una porción diaria de 40gr");
        }
        else if(pesoN >= 4 && pesoN <= 7){
            resultados.setText("Ya es una mascota adulta , son necesarias 2 porciones diarias cada una de 65gr");
        }
        else if (pesoN >=8 && pesoN <= 12){
            resultados.setText("Ya es un mascota adulta , son necesarias 2 porciones diarias cada una de 80gr");
        }else{
            resultados.setText("¿Está seguro que ese es el peso de su mascota!?");
        }

    }

    public void cerrar(View v){
        finish();
    }

}
