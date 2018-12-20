package com.example.jose.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GreenFragment extends Fragment {
    private OnGreenFragmentListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_green, container, false);

        Button button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "¡Hola Azul! Yo soy Verde.";


                // Lamada al metodo de la interface implementado en la activiadad
                mCallback.mensajeDesdeFragmentoVerde(message);
            }
        });

        return v;
    }

    //Esta es la interface que la Activity implementará para que
    // este fragmento pueda comunicarse con ella
    public interface OnGreenFragmentListener {
        void mensajeDesdeFragmentoVerde(String text);
    }


    // Este método, que es el primero en ejecutarse en el ciclo de vida del fragment,
    // asugura que la Activity ha implementado nuestro listener y que no es null
    //El parámetro context es la actividad contenedora del fragment
    // Lo que hace es asignar a la variable mCallback una referencia a la actividad
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);  // context es la Activity que contiene el fragment
        // Si la Activity implementa la interface entonces es instancia de ella
        if (context instanceof OnGreenFragmentListener) {
            // Como la actividad implementa la interface OnGreenFragmentListener
            // puedo hacer esta asignación polimórfica.
            mCallback = (OnGreenFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGreenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }
}
