using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        int counta;
        int countespc = 0;
        string cadena;


        if (funcion(out cadena, out counta, ref countespc) > 2)
        {
            Console.WriteLine("la frase tiene tres espacios o mas ");
        }
        else
        {
            Console.WriteLine("la frase contiene menos de tres espacios");

        }

        if (counta > 0)
        {
            Console.WriteLine("la frase contiene la letra a");
        }
        else
        {
            Console.WriteLine("la frase No contiene la letra a");
        }
    }

    public static int funcion(out string cadena, out int counta, ref int countespc)
    {

        counta = 0;
        int countcad;
        cadena = Console.ReadLine();

        for (int i = 0; i < cadena.Length; i++)
        {
            if (cadena[i] == 'a')
            {
                counta++;
            }
            if (cadena[i] == ' ')
            {
                countespc++;

            }

        }

        funcion2(out countcad, ref cadena);

        return countespc;

    }

    public static void funcion2(out int countcad, ref string cadena)
    {
        countcad = cadena.Length;
        Console.WriteLine("La frase contiene {0} caracteres ", countcad);
    }

}  

