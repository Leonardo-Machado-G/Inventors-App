//Asociamos la clase al paquete
package com.leonardoestudiante.tarea_5;

//Importamos las librerias
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InventorDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InventorDetailFragment extends Fragment {

    //Declaramos el ID del inventor y su nombre,description e imagen
    private long inventorId;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private ImageView photoImageView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InventorDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Inventor_Detail_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InventorDetailFragment newInstance(String param1, String param2) {
        InventorDetailFragment fragment = new InventorDetailFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventor__detail_, container, false);
    }

    //Metodo que asocia el ID del inventor con esta clase
    public void setInventorId(long inventorId) {
        this.inventorId = inventorId;
    }

    //Metodo que obtiene la View e inserta los datos en los campos
    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        if (view != null) {

            titleTextView = (TextView) view.findViewById(R.id.title_textView);
            titleTextView.setText(Inventor.inventors[(int) inventorId].getName());
            descriptionTextView = (TextView) view.findViewById(R.id.description_textView);
            descriptionTextView.setText(Inventor.inventors[(int) inventorId].getDescription());
            photoImageView = (ImageView) view.findViewById(R.id.photo_ImageView);
            photoImageView.setImageResource(Inventor.inventors[(int) inventorId].getImageID());

        }

    }

}