package com.example.jose.fragmenttofragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements GreenFragment.OnGreenFragmentListener{

    BlueFragment mBlueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos una referencia al fragmento azul para hacerle llegar el mensaje ercogido
        // al hacer click en boton del fragmento verde

       FragmentManager fragmentManager = getSupportFragmentManager();

       mBlueFragment= (BlueFragment) fragmentManager.findFragmentById(R.id.fragmento_azul);

    }

    // La actividad recibe el mensaje del fragmento verde a través del metodo de la interface
    // y se lo pasa al fragmento azul
    @Override
    public void mensajeDesdeFragmentoVerde(String mensaje) {

        mBlueFragment.tienesUnMensaje(mensaje);
    }
}
