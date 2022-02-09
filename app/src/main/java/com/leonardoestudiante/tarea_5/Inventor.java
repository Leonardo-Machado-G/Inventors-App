package com.leonardoestudiante.tarea_5;

import android.content.Context;

public class Inventor {

    //Varibales para guardar informacion
    public static final String EXTRA_NAME = "nameValue";
    public static final String EXTRA_DESCRIPTION = "descriptionValue";

    //Usado para acceder a los recursos de una activity
    public static Context context = null;

    //Declaramos el nombre
    private int name;

    //Declaramos la descripcion
    private int description;

    //Declaramos un int que sera el id de la imagen
    private int imageID;

    //Declaramos el array de inventores y su informacion que se encuentra asociado al fichero de strings
    public static final Inventor[] inventors = {

            new Inventor(R.string.inventor_name_1, R.string.inventor_description_1,R.drawable.tesla),
            new Inventor(R.string.inventor_name_2, R.string.inventor_description_2,R.drawable.arquimedes),
            new Inventor(R.string.inventor_name_3, R.string.inventor_description_3,R.drawable.benjamin),
            new Inventor(R.string.inventor_name_4, R.string.inventor_description_4,R.drawable.edison),
            new Inventor(R.string.inventor_name_5, R.string.inventor_description_5,R.drawable.da_vinci),
            new Inventor(R.string.inventor_name_6, R.string.inventor_description_6,R.drawable.graham_bell)

    };

    //Declaramos el constructor
    public Inventor(int name, int description, int imageID){

        this.name = name;
        this.description = description;
        this.imageID = imageID;

    }

    //Declaramos los get para cada elemento
    public int getName() {
        return name;
    }
    public int getDescription() {
        return description;
    }
    public int getImageID() {
        return imageID;
    }

    //Devolvemos el string a traves del contexto de esta clase
    @Override
    public String toString(){
        return context.getResources().getString(name);
    }

}
