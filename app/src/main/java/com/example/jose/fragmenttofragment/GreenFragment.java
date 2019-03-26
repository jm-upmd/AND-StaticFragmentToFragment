package com.example.jose.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class GreenFragment extends Fragment {
    private OnGreenFragmentListener mCallback;


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
                    + " la actividad debe implemantar la interface OnGreenFragmentListener");
        }
    }

    // Hace el inflate del layout del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_green, container, false);
        return v;
    }


    // De ejecuta justo después del onCreateView. Aquí se crean las referencias a los views y demás
    // objetos del layout del fragment, se implementan sus listeners, ...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "¡Hola Azul! Yo soy Verde.";

                // Lamada al metodo de la interface implementado en la activiadad
                mCallback.mensajeDesdeFragmentoVerde(message);
            }
        });
    }


    // This method is called when the fragment is no longer connected to the Activity
    // Any references saved in onAttach should be nulled out here to prevent memory leaks.
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null; // Para que limpie el objeto el recolector de basura y evitar memory lieak.
    }
}
