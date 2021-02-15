package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Agenda extends AppCompatActivity {

    EditText telefono;
    Button btnllamar;
    Button btnllamaroperaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

         telefono= findViewById(R.id.editTelefono);
         btnllamar=findViewById(R.id.btnllamar);
        btnllamaroperaciones=findViewById(R.id.btnllamaroperaciones);

        btnllamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telef=telefono.getText().toString().trim();
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + telef));
                startActivity(intent);
            }
        });

        btnllamaroperaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:954122918"));

                startActivity(intent);
            }
        });


    }




    public void btnir(View v) {
        Intent intent2 = new Intent(v.getContext(), MenuSecundario.class);
        startActivityForResult(intent2, 0);
    }


}