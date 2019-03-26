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

        // En este mentodo se hace el inflado del fragmento y se crean las referencias
        // a sus views componentes.
        View v = inflater.inflate(R.layout.fragment_blue, container, false);
        return v;
    }

    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // La view que contiene el fragmento
        mTextView = view.findViewById(R.id.textview);
    }

    // Este es un método público que la actividad puede usar para comunicarse directamente con
    // este fragmento.

    public void tienesUnMensaje(String mensaje) {
        mTextView.setText(mensaje);
    }
}
