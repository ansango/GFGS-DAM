//Introducir por teclado las datos de una array de 20 posiciones.
//Calcular un número aleatorio.
//

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepasoPrueba31_1
{
    class Program
    {
        static void Main(string[] args)
        {
            int aleatorio;
            int contadorAleatorio=0;
            int[] numeros = new int[5];
            Random aleatorios = new Random();

            aleatorio = aleatorios.Next(1,11);
                        
            for (int i = 0; i < numeros.Length; i++)
            {
                Console.Write("Introducir número {0}: ", i+1);
                numeros[i] = int.Parse(Console.ReadLine());
                
                if (numeros[i] % aleatorio == 0)
                {
                    contadorAleatorio++;
                }
            }

            if (contadorAleatorio>0)
            {
                Console.Write("Los números que son multiplos de {0} son: ",aleatorio);
                for (int i = 0; i < numeros.Length; i++)
                {
                    if (numeros[i] % aleatorio == 0)
                    {
                        Console.Write("{0}" , numeros[i]);
                    }
                }
            }
            else
            {
                Console.Write("No hay números multiplos de {0}", aleatorio);
            }
            
            Console.ReadLine();
        }
    }
}
