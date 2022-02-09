//Asociamos la clase al paquete
package com.leonardoestudiante.tarea_5;

//Importamos las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//Declaramos la clase y heredamos
public class DetailActivity extends AppCompatActivity {

    //Creamos una variable para el intercambio de informacion
    public static final String EXTRA_INVENTOR_ID = "id";

    //Al ejecutar la activity se inicia este metodo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Asociamos la activity con el layout
        setContentView(R.layout.activity_detail);

        //Declaramos un fragment y le indicamos su ID
        InventorDetailFragment fragment = (InventorDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_fragment_container);

        //Obtenemos el ID del intent anterior
        int workoutId = (int)getIntent().getExtras().get(EXTRA_INVENTOR_ID);

        //Introducimos el ID al fragment
        fragment.setInventorId(workoutId);

    }

}