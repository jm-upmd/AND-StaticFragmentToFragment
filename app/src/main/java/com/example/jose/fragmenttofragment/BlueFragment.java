package com.example.jose.fragmenttofragment;


import android.os.Bundle;
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

        // En este mentodo se hace el inflado del fragmento y se crean las referencias
        // a sus views componentes.
        View v = inflater.inflate(R.layout.fragment_blue, container, false);


        // La view que contiene el fragmento
        mTextView = v.findViewById(R.id.textview);

        return v;
    }

    // Este es un método público que la actividad puede usar para comunicarse directamente con
    // este fragmento.

    public void tienesUnMensaje(String mensaje) {
        mTextView.setText(mensaje);
    }
}
