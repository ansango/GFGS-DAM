package com.example.online.proyecto1_actividades;

/**
 * Created by Online on 26/08/2016.
 */
public class Datos {
    static public String lista[][] = {
            {"Jose", "Fuentes", "666666666"},
            {"Pedro", "Ceballos", "666666666"},
            {"Antonio", "San Román", "666666666"},
            {"Luisa", "Ancos", "666666666"},
            {"Luis", "Pérez", "666666666"},
            {"María", "García", "666666666"},
            {"Nerea", "Petro", "666666666"},
            {"Marcos", "Santos", "666666666"},
            {"Lucía", "González", "666666666"}
    };

    static public String[] getNombres() {
        String ret[]=new String[9];
        ret[0]=lista[0][0];
        ret[1]=lista[1][0];
        ret[2]=lista[2][0];
        ret[3]=lista[3][0];
        ret[4]=lista[4][0];
        ret[5]=lista[5][0];
        ret[6]=lista[6][0];
        ret[7]=lista[7][0];
        ret[8]=lista[8][0];

        return ret;
    }

    //No hay set, puesto que no se modifican los datos de la agenda
}
