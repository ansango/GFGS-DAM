using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication5
{
    class Program
    {
        static void Main(string[] args)
        {
            // a) Creamos el array.
            int[] A = new int[16];
            Random aleatorio = new Random();
            // a) Introducimos los números aleatorios en el array y mostramos.
            Console.Write("\na) Creamos y mostramos el vector: ");
            for (int i = 0; i < 16; i++)
            {
                A[i] = aleatorio.Next(-10, 21);
                Console.Write("{0} ", A[i]);
            }

           
            Console.Write("\nb) Mostramos la cantidad de pares positivos ");
            int contador = 0; // c) Creo contador de positivos pares.
            // b) Mostramos el contenido del tercer array y contamos los pares positivos.
            for (int i = 0; i < 16; i++)
            {
                if (A[i] % 2 == 0 && A[i] > 0)
                {
                    contador++;
                }
            }

            Console.WriteLine("\n Hay " + contador + " números postivos y pares a la vez.");
            // c) Creamos la matriz
            // lo creo de 4,5 en vez de 4,4 para guardar la suma en la ultima columna
            int[,] matriz = new int[4, 5];
            int k = 0; // indice del vector
            Console.Write("\nc) Lo paso a matriz: ");
            Console.Write("\n\n");
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    matriz[i, j] = A[k];  //guardamos en al posicion i,j de la matriz lo que hay en la posicion k del vector
                    Console.Write("\t{0}", matriz[i, j]); //el \t es un tabulador.

                    k++;
                }
                Console.WriteLine();
            }
            // d) Positivizamos la matriz, y calculamos la suma, y la ponemos en la columna 4.
            Console.Write("\nd) Contenido D: ");
            Console.Write("\n\n");
            int suma;
            for (int i = 0; i < 4; i++)
            {
                suma = 0; //lo hago para reiniciar la variable suma.
                for (int j = 0; j < 4; j++)
                {
                    if (matriz[i, j] < 0) matriz[i, j] = matriz[i, j] * -1;  //Si es menor que 0, multiplico por -1
                    Console.Write("\t{0}", matriz[i, j]); //Lo muestro, y acumulo la suma
                    suma += matriz[i, j];
                }
                //guardo la suma en la ultima columna, y la muestro
                matriz[i, 4] = suma;
                Console.WriteLine("\t"+matriz[i,4]);
            }

            // e) Puntos de bitacora:
            int result = 0;
            Console.WriteLine();
            Console.WriteLine("e) Puntos de bitacora:");
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4; j++)
                {
                    if (matriz[i, j] != 0) // e) Si el valor es distinto de 0, lo hago para evitar hacer un "suma" % 0, ya que dividiria por 0 y petaria
                    {
                        //primero hago el OR para saber si es multiplo de 3 o 4. En caso que sea cierto, hago el AND
                        // para saber si a demás de ser multiplo de 3 o 4, divido la suma (que esta en la columna 4), exactamente
                        if ((matriz[i, j] %3== 0 || matriz[i, j]%4==0) && (matriz[i,4]%matriz[i, j]==0) )
                        {
                            Console.WriteLine("Numero "+matriz[i, j]+" (posicion "+i+","+j+"), ya que es multiplo de 3 o 4,"+
                                " y divide exactamente a la suma de la fila "+i+"("+matriz[i, 4]+")");
                        }
                        
                    }
                }
                
            }

            
            Console.ReadLine();
        }
    }
}
