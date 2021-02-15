package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ConsultarDocumento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_documento);



    }








    public void buscar(View v){
        EditText txtCriterio = (EditText)findViewById(R.id.txtCriterio);
        String criterio = txtCriterio.getText().toString();
        String url = "http://alma23.atwebpages.com/index.php/productos/"+criterio;

        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    Log.i("======>", jsonArray.toString());

                    List<String> items = new ArrayList<>();
                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        items.add(" ("+object.getString("idreg")+") " + object.getString("placa") + "  " +object.getString("soat") + "  " +object.getString("revisiontecnica")  + "  " + object.getString("mtc") );
                    }

                    ListView lstProductos = findViewById(R.id.lista);
                    ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                            ConsultarDocumento.this,
                            android.R.layout.simple_list_item_1,
                            items);
                    lstProductos.setAdapter(adaptador);

                } catch (JSONException e) {
                    Log.i("======>", e.getMessage());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void boton2(View v) {
        Intent intent2 = new Intent(v.getContext(), MenuSecundario.class);
        startActivityForResult(intent2, 0);
    }


}