package com.example.online.proyecto1_actividades;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Online on 19/09/2016.
 */
public class Detalles extends Fragment {
    private int numLista=0;
    InterfaceDatos myListener;
    Detalles miCtx=null;

    public interface InterfaceDatos{
        public void onComunicateData(String val1);
    }

    public Detalles(){
        this.numLista=0;
    };

    @Override
    public void onCreate(Bundle sb){
        super.onCreate(sb);
        miCtx=this;

        //Se carga el elemento
        this.numLista=getArguments().getInt(MainActivity.KEY_LIST, 0);
    }

    @Override
    public void onAttach(Activity ctx){
        super.onAttach(ctx);
        try {
            myListener = (InterfaceDatos) ctx;
        } catch (ClassCastException e) {
            throw new ClassCastException(ctx.toString() + " No se puede comunicar con la actividad");
        }
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Se añade el fragment a la actividad
        super.onCreateView(inflater, container, savedInstanceState);

        //Colocamos los datos en el layout
        View vw= inflater.inflate(R.layout.detalles, container, false);

        TextView txt=(TextView)vw.findViewById(R.id.txtNombre);
        txt.setText(Datos.lista[numLista][0]);
        txt=(TextView)vw.findViewById(R.id.txtApellidos);
        txt.setText(Datos.lista[numLista][1]);
        txt=(TextView)vw.findViewById(R.id.txtTelefono);
        txt.setText(Datos.lista[numLista][2]);

        Button bt=(Button)vw.findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
               myListener.onComunicateData("Saliendo...");
            }
        }
        );

        return vw;
    }
}
