//Asociamos el paquete a la clase
package com.leonardoestudiante.tarea_5;

//Importamos las librerias necesarias
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

//Declaramos la clase y heredamos
public class MainActivity extends AppCompatActivity implements InventorListFragment.Listener{

    //Metodo que asocia la activity al layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Recibe un long y este se lo enviamos a otra activity y la iniciamos
    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this,DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_INVENTOR_ID, (int)id);
        startActivity(intent);
    }
}