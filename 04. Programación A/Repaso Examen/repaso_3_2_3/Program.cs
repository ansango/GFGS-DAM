//Función que rellene un array, con un string más la posición del array.
//Función con parametros de entrada el string y un array.
//En el main se solicita el string por pantalla y se llama a la función y muestra el array por pantalla.

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace repaso_3_2_3
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] textoArray = new string[20];
            string texto;
            Console.Write("Introducir texto: ");
            texto = Console.ReadLine();
            RellenarArray(texto, textoArray);

            for (int i = 0; i < textoArray.Length; i++)
            {
                Console.Write("{0} ",textoArray[i]);
            }
            Console.ReadLine();
        }

        static void RellenarArray(string texto, string[] textoArray)
        {
            for (int i = 0; i < textoArray.Length; i++)
            {
                textoArray[i] = texto + i;
            }
        }
    }
}
