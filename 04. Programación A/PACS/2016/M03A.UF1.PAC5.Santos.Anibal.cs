using System;

namespace Anibal_UF1_PAC5_arrays
{
    class MainClass
    {
        public static void Main(string[] args)
        {                                                               //declaramos arrays y variables
            int[] Array16 = new int[16];
            int[,] Array4x4 = new int[4, 4];
            int[,] Array4x5Suma = new int[4, 5];
            int i, j, k = 0;                                            // índices de posición de los arrays
            int contadorPares = 0;
            
            //A.)

            Random rand = new Random();                                 // creamos un objeto generador de números aleatorios

                                                                        // rellenamos el array inicial
            for (i = 1; i < Array16.Length; i++)
            {
                Array16[i] = rand.Next(-10, 20);                        // insertamos un valor aleatorio entre -10 y 20 en la posición i 
            }

            Console.Write("contenido\t");
            for (i = 0; i < Array16.Length; i++)
            {
                Console.Write(Array16[i] + "\t");
            }


            Console.Write("\nposicion\t");
            for (i = 0; i < Array16.Length; i++)
            {
                Console.Write(i + "\t");
            }

             //B.)

            for (i = 0; i < Array16.Length; i++) 
            {
                if (((Array16[i] % 2) == 0) && (Array16[i] > 0))
                {
                    contadorPares++;
                }
            }

            Console.WriteLine("\n" + contadorPares + " múltiplos de dos que son positivos ");


            //C.)

            k = 0;

            Console.Write("POSICION\t1\t2\t3\t4\n\t");

            for (i = 0; i < 4; i++)
            {
                Console.Write(i + "");                                      // numero de fila
                for (j = 0; j < 4; j++)
                {
                    Array4x4[i, j] = Array16[k];                            // k es el indice de posición del array original
                    k++;                                                    // aumentamos en 1 el valor de k, para cambiar de posición
                    Console.Write("\t" + Array4x4[i, j]);
                }
                Console.Write("\n\t");
            }

           //D.)

            Console.WriteLine(" \n\n Matriz positivada con suma por filas\n");
            Console.Write("POSICION\t1\t2\t3\t4\tTOTAL\n");
            
            for (i = 0; i < 4; i++)
            {
                Array4x5Suma[i, 4] = 0;                                     //inicializamos la suma total de la fila a 0

                Console.Write( "\t" + i + "\t");

                for (j = 0; j < 4; j++)
                {
                    Array4x5Suma[i, j] = Array4x4[i, j];

                    if (Array4x5Suma[i, j] < 0)                             //si es negativo positivamos
                    {
                        Array4x5Suma[i, j] = Array4x5Suma[i, j] * (-1);
                    }

                    Array4x5Suma[i, 4] += Array4x5Suma[i, j];               //vamos sumando el total de la fila

                    Console.Write(Array4x5Suma[i, j] + "\t");
                }
                Console.Write(Array4x5Suma[i, 4] + "\n");
            }

            //E.)

            for (i = 0; i < 4; i++)
            {
                for (j = 0; j < 4; j++)
                {
                    if ((((Array4x5Suma[i, j] % 3) == 0) ||                 // es multiplo de 3 
                           ((Array4x5Suma[i, j] % 4) == 0)                  // es multiplo de 4
                        )
                        &&
                        (Array4x5Suma[i, j] != 0)                           // comprobamos que es distinto de 0 para no dividir por la siguiente condicion
                        && 
                        ((Array4x5Suma[i, 4] % Array4x5Suma[i, j]) == 0)    // El total de suma es divisible entee el valor de la posicion
                    )
                    {
                        Console.Write("\nNumero " + Array4x5Suma[i, j] + " (posición " + i + "," + j + "), ya que " +
                            "es múltiplo de 3 o de 4, y divide exactamente la suma de la fila " + i + " (" + Array4x5Suma[i, 4] + " )");
                    }
                }
            }
            Console.ReadKey();
        }
    }
}
