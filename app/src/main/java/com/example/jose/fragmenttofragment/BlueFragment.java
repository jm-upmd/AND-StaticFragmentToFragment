package com.example.jose.fragmenttofragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlueFragment extends Fragment {
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("fragmento","En onCreateView del azul");

        // En este método se hace el inflado del fragmento .
        View v = inflater.inflate(R.layout.fragment_blue, container, false);
        return v;
    }

    // Este método se ejecuta justo después del onCreateView. Es llamado solo si la view devuelta
    // por onCreateView no es null.
    // Aquí se crean las referencias a los views y demás objetos del layout del fragment,
    // se implementan sus listeners, ...
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //  view es la View que contiene el fragmento
        mTextView = view.findViewById(R.id.textview);
    }

    // Este es un método público que la actividad contenedora puede usar para
    // comunicarse directamente con este fragmento.

    public void tienesUnMensaje(String mensaje) {
        mTextView.setText(mensaje);
    }
}
