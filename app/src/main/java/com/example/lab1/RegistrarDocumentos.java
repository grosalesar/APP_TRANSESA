package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RegistrarDocumentos extends AppCompatActivity {
    EditText t1;
    EditText t2;
    EditText t3;

    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();



    // Y luego ya podrás obtener la fecha
    final Calendar calendario = Calendar.getInstance();
    int anio = calendario.get(Calendar.YEAR);
    int mes = calendario.get(Calendar.MONTH);
    int diaDelMes = calendario.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_documentos);



        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        t1 = (EditText) findViewById(R.id.txtsoat);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });


        t1 = (EditText) findViewById(R.id.txtsoat);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });



        t2 = (EditText) findViewById(R.id.txtrt);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });
        t2 = (EditText) findViewById(R.id.txtrt);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });


        t3 = (EditText) findViewById(R.id.txtmtc);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });
        t3 = (EditText) findViewById(R.id.txtmtc);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });


    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();
                    colocar_fecha2();
                    colocar_fecha3();
                }

            };

    private void colocar_fecha() {
        t1.setText(mDayIni + "/" + (mMonthIni + 1)  + "/" + mYearIni+" ");
    }

    private void colocar_fecha2() {
        t2.setText(mDayIni + "/" + (mMonthIni + 1)  + "/" + mYearIni+" ");
    }

    private void colocar_fecha3() {
        t3.setText(mDayIni + "/" + (mMonthIni + 1)  + "/" + mYearIni+" ");
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);
        }
        return null;
    }


    private DatePickerDialog.OnDateSetListener listenerDeDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int anio, int mes, int diaDelMes) {
            // Esto se llama cuando seleccionan una fecha. Nos pasa la vista, pero más importante, nos pasa:
            // El año, el mes y el día del mes. Es lo que necesitamos para saber la fecha completa
        }
    };




    public void registrar(View v){
        final EditText txtplaca = findViewById(R.id.txtplaca);
        final EditText txtconductor = findViewById(R.id.txtconductor);
        final EditText txtsoat = findViewById(R.id.txtsoat);
        final EditText txtrt = findViewById(R.id.txtrt);
        final EditText txtmtc = findViewById(R.id.txtmtc);

        String url = "http://alma23.atwebpages.com/index.php/productos";

        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast toast = Toast.makeText(RegistrarDocumentos.this,"Se insertó correctamente", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap();
                params.put("placa", txtplaca.getText().toString());
                params.put("conductor", txtconductor.getText().toString());
                params.put("soat", txtsoat.getText().toString());
                params.put("revisiontecnica", txtrt.getText().toString());
                params.put("mtc", txtmtc.getText().toString());

                return params;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        /*
        JSONObject jsonobject = new JSONObject();
        try {
            jsonobject.put("idCategoria", "1");
            jsonobject.put("nombre", txtNombre.getText().toString());
            jsonobject.put("precio", txtDescripcion.getText().toString());
            Log.i("======>", jsonobject.toString());
        } catch (JSONException e) {
            Log.i("======>", e.getMessage());
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, jsonobject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Success Callback
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("======>", error.getMessage());
                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
        */

        Intent intent2 = new Intent (v.getContext(), MenuSecundario.class);
        startActivityForResult(intent2, 0);


    }


}