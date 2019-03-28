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
    // Asegura que la Activity ha implementado nuestro listener y que no es null
    //El parámetro context es la actividad contenedora del fragment
    // Lo que hace es asignar a la variable mCallback una referencia a la actividad contenedora,
    // que es la que ha implemenado el método mensajeDesdeFragmentoVerde de la interface.
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);  // context es la Activity que contiene el fragment
        // Si la Activity implementa la interface entonces es instancia de ella
        if (context instanceof OnGreenFragmentListener) {
            // Como la actividad implementa la interface OnGreenFragmentListener
            // puedo hacer esta asignación polimórfica.
            // mCallback ahora referenciará a MainActivity y podra ejecutar el método
            // mensajeDesdeFragmentoVerde de la ingterface, que esta implementa.
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


    // Este método se ejecuta justo después del onCreateView. Es llamado solo si la view devuelta
    // por onCreateView no es null.
    // Aquí se crean las referencias a los views y demás objetos del layout del fragment,
    // se implementan sus listeners, ...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "¡Hola Azul! Yo soy Verde.";

                // Lamada al metodo de la interface implementado en la actividad contenedora del
                // del fragmente (MainActivity)
                mCallback.mensajeDesdeFragmentoVerde(message);
            }
        });
    }


    // Este método es llamado cuando el fragment no se ha conectado con la activity desde
    // hace tiempo.
    // Cualquier referencia creada en onAttach deberia ser anulada aquí para evitar memory leasks
    @Override
    public void onDetach() {
        super.onDetach();
        // Para que limpie el objeto el recolector de basura y evitar memory lieak.
        mCallback = null;
    }
}
