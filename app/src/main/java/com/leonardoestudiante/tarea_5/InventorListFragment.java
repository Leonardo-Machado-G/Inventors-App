//Asociamos el paquete a la clase
package com.leonardoestudiante.tarea_5;

//Importamos las librerias necesarias
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InventorListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InventorListFragment extends ListFragment {

    //Declaramos la interfaz listener dentro de la clase para enviar un long al fragment
    static interface Listener{
        void itemClicked(long id);
    }

    //Declaramos un listener
    private Listener listener;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InventorListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inventor_List_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InventorListFragment newInstance(String param1, String param2) {
        InventorListFragment fragment = new InventorListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Obtenemos el contexto
        Inventor.context = getContext();

        //Declaramos un vector vacio de la misma longitud que el array de inventores
        String[] names = new String[Inventor.inventors.length];

        //Vamos introduciendo los nombres que enviamos mediante el context
        for(int i = 0; i<names.length ; i++){
            //Introducimos el nombre
            names[i] = Inventor.inventors[i].toString();
        }

        //Declaramos un adpatar y le asociamos el vector y un tipo de lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, names);

        //Asociamos el adapter
        setListAdapter(adapter);

        //
        return super.onCreateView(inflater,container,savedInstanceState);

    }

    //
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener=(Listener)context;
    }

    //Enviamos el ID mediante el listener
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        if(listener!=null){
            listener.itemClicked(id);
        }

    }

}