using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Solución_PAC3_UF1_M03B
{
    class Program
    {
        static void Main(string[] args)
        {
            // Declaración de variables
            int casos = 0; int mejillones, conchas, numero_mejillones;
            int diasJusto = 0; int diasSuerte = 0; int diasTimo = 0;
            bool validacion_casos = false;
            do
            {
                if (validacion_casos)
                {
                    Console.Write("Has introducido un numero de casos negativo, vuelve a introducrir: ");
                    casos = int.Parse(Console.ReadLine());
                }
                else
                {
                    Console.Write("Introduce el número de casos a evaluar: ");
                    casos = int.Parse(Console.ReadLine());
                    validacion_casos = true;
                }             
            } while (casos < 0);

            while(casos > 0)
            {
                //Para cada caso de prueba, tenemos que reiniciar el acumulador de mejillones y contador de conchas
                mejillones = 0;
                conchas = 0;

                // Leemos mejillones por concha
                Console.WriteLine("Introducir mejillones por concha (terminar con -1): ");
                numero_mejillones = int.Parse(Console.ReadLine());
                while(numero_mejillones != -1)
                {
                    mejillones += numero_mejillones;
                    conchas++;
                    Console.WriteLine("Introducir mejillones por concha (terminar con -1): ");
                    numero_mejillones = int.Parse(Console.ReadLine());
                }

                //Hacemos la revisión de si hay las mismas conchas que mejillones, si hay más o menos 
                if (conchas==mejillones && mejillones != 0 && conchas !=0 )
                {
                    diasJusto++;
                    Console.WriteLine("JUSTO");
                }
                else if(conchas < mejillones)
                {
                    diasSuerte++;
                    Console.WriteLine("SUERTE");
                }
                else
                {
                    //Control donde se tiene en cuenta que no haya ninguna concha. 
                    if (mejillones != 0 && conchas != 0)
                    { 
                    diasTimo++;
                    Console.WriteLine("TIMO");
                    }
                }
                casos--;         
            }

           // Mostramos la leyenda
            Console.WriteLine();
            Console.WriteLine("JUSTO - ->" + diasJusto);
            Console.WriteLine("SUERTE - ->" + diasSuerte);
            Console.WriteLine("TIMO - ->" + diasTimo);
            Console.ReadKey();
        }
    }
}

