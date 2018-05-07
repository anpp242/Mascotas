package com.edu.omar.mascotas;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Formulario extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    private TextView t_principal;
    private EditText nombrepm, nMascota;
    private Typeface grotesk;
    private Button in_form;
    private boolean tMascota;
    private RadioGroup grupo;
    private RadioButton btn_perro, btn_gato;
    private String tMas = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        String fonts ="fuentes/grotesk.ttf";
        this.grotesk = Typeface.createFromAsset(getAssets(), fonts);

        t_principal = (TextView)findViewById(R.id.t_formulario);
        t_principal.setTypeface(grotesk);

        nombrepm = (EditText)findViewById(R.id.nombrepm);
        nombrepm.setTypeface(grotesk);

        nMascota = (EditText)findViewById(R.id.nMascota);
        nMascota.setTypeface(grotesk);

        in_form = (Button)findViewById(R.id.in_form);
        in_form.setTypeface(grotesk);

        grupo = (RadioGroup) findViewById(R.id.grupoTm);
        btn_gato = (RadioButton) findViewById(R.id.btn_gato);
        btn_perro = (RadioButton) findViewById(R.id.btn_perro);
        btn_gato.setOnCheckedChangeListener(this);


        //PASARAL OTRO ACTIVITY
        in_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Formulario.this, confirmacion.class);
                i.putExtra("dNombre", nombrepm.getText().toString());
                i.putExtra("nMascota", nMascota.getText().toString());

                i.putExtra("tm", tMas);
                startActivity(i);
            }
        });

    }

    public void cerrar(View v){
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }

    @Override
    public void onCheckedChanged (CompoundButton buttonView, boolean isChecked) {
        if(btn_gato.isChecked()){
            tMas = "Tu mascota es un Gato";
        }
        else if(btn_perro.isChecked()){
            tMas = "Tu mascota es un  Perro";
        }
    }
}
