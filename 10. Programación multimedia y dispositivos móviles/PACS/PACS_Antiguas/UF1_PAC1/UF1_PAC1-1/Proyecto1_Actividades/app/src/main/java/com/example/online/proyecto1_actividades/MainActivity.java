package com.example.online.proyecto1_actividades;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements Detalles.InterfaceDatos { //Detalles es el Fragment

    static public String KEY_LIST="numlist";
    static public final int NO_DETALLE=-1;
    private static int COD_RTN_ACT=0;

    Context ctx;
    int numLista=-1; //El índice del elemento seleccionado
    Fragment fragmenAct = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        if(savedInstanceState!=null) {
            numLista=savedInstanceState.getInt(KEY_LIST, NO_DETALLE);
        }

        //Cargamos los datos en la lista
        ListView lv = (ListView) this.findViewById(R.id.lstPersonas);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Datos.getNombres()));
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick (AdapterView <?> parent, View view, int position, long id) {
                numLista = position;  //índice
                addDetalles(numLista);  //LLamamos a la función que abre el Fragment con los detalles
            }
        });

        if (numLista>NO_DETALLE) addDetalles(numLista);

        //Cambiar de actividad
        Button btnCambiar = (Button) findViewById(R.id.btnCambiar);
        btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, SecondActivity.class);
                startActivityForResult(intent, COD_RTN_ACT);
            }
        });
    }

    //Comunicación para cerrar el Fragment
    public void onComunicateData(String val1) {
        Toast.makeText(ctx, val1, Toast.LENGTH_LONG).show();
        removeDetalles();
    }

    //Abrimos el Fragment
    public void addDetalles(int num){
        Fragment fragmentOld=fragmenAct;
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transicion = fm.beginTransaction();
        Fragment newFragment = new Detalles();
        fragmenAct=newFragment;

        Bundle data=new Bundle();
        data.putInt(KEY_LIST,numLista); //Se asigna el índice para que el Fragment
        newFragment.setArguments(data);
        //Es posible que el Fragment estuviera abierto con otros datos, y hay que actualizarlos
        if (fragmentOld==null){
            transicion.add(R.id.frmDetalles, newFragment);
        }
        else {
            transicion.replace(R.id.frmDetalles, newFragment);
        }
        transicion.commit();
    }

    //Cerramos el Fragment
    public void removeDetalles(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transicion = fm.beginTransaction();
        transicion.remove(fragmenAct);
        fragmenAct=null;
        transicion.commit();
    }
}
