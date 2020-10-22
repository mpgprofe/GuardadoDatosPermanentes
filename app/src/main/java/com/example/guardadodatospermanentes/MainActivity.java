package com.example.guardadodatospermanentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity implements DialogoHora.CuandoEsteSeleccionadaLaHora, DialogoFecha.CuandoSeleccioneLaFecha {
    private static final String EDAD = "EDAD";
    Button guardar, cargar, borrar, botonHora, botonFecha;
    EditText nombre, edad;
    TextView textViewHora, textViewFecha;
    static final String NOMBRE_FICHERO = "DATOS";
    static final String NOMBRE = "NOMBRE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar = findViewById(R.id.buttonGuardar);
        cargar = findViewById(R.id.buttonCargar);
        nombre = findViewById(R.id.editTextNombre);
        edad = findViewById(R.id.Edad);
        borrar = findViewById(R.id.buttonBorrar);
        botonHora = findViewById(R.id.buttonHora);
        textViewHora = findViewById(R.id.textViewHora);
        botonFecha = findViewById(R.id.buttonFecha);
        textViewFecha = findViewById(R.id.textViewFecha);


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                SharedPreferences.Editor editor = misPreferencias.edit();
                editor.putString(NOMBRE, nombre.getText().toString());
                editor.putInt(EDAD, Integer.parseInt(edad.getText().toString()));
                editor.apply();

            }
        });

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                nombre.setText(misPreferencias.getString(NOMBRE, "-Sin nombre-"));
                edad.setText("" + misPreferencias.getInt(EDAD, 0));
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences misPreferencias = getSharedPreferences(NOMBRE_FICHERO, MODE_PRIVATE);
                misPreferencias.edit().clear().apply();
            }
        });

        botonHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(), "Mi Ventana de hora");
            }
        });

        botonFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), "Mi Ventana para Fecha");
            }
        });

    }

    @Override
    public void enSeleccion(GregorianCalendar hora) {
        textViewHora.setText(hora.get(GregorianCalendar.HOUR) + ":" + hora.get(GregorianCalendar.MINUTE));

    }

    @Override
    public void fechaSeleccionada(GregorianCalendar fecha) {
        textViewFecha.setText(fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR));
    }
}