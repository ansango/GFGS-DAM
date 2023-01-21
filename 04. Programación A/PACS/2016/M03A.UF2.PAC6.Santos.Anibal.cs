using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AnibalParejasAnibal
{
    class Program
    {
        static void Main(string[] args)
        {
            // 1. Generar el array de solucion
            // 2. Generar el array que mostramos
            // 3. Entrar en el juego
            // 3.1. Pedir coordernadas.
            // 3.2 comprobar coordenadas que no sean repetidas y no esten fuera de rango
            // 3.2.1. Si coordenadas son repetidas entonces => 
            // 3.2.1.1. mensaje de error
            // 3.2.1.2. volver a pedir coordenadas (volver al 3.1.)
            // 3.2.2 coordenadas no repetidas
            //3.2.2.1. comprobamos si los contenidos de las coordenadas son iguales
            //3.2.2.2.1.si son iguales
            //3.2.2.2.2.modificamos el array mostrar poniendo las solucion de esas coordenados.
            //3.2.2.2. imprimimos el array mostrar y esperamos a tecla enter
            //3.2.2.2.1. si la coordenada que estamos imprimiendo es una de las que nos ha dado
            //3.2.2.2.1.1. entonces imprimimos el contenido del array Solucion para esa coordenada
            //3.2.2.3 esperamos tecla enter
            //3.3. comprobamos que la matriz mostrar no contenga interrogantes "?"
            //3.3.1. si no contiene interrogantes "?"
            //3.3.1.1. el juego ha finalizado
            //3.3.2. si contiene interrogantes "?"
            //3.3.2.1. volvemos al 3.1. pedir coordenadas.



            // 1. Generar el array de solucion y // 2. generar el array que mostramos

            char[,] solucion;
            char[,] mostrar;
            int contadorIntentos = 0;
            int dificultad;
            bool valorNoValido;
            bool finTablero;

            do
            {
                valorNoValido = false;
                Console.WriteLine("Elige dificultad (4 ó 6)");
                dificultad = Int32.Parse(Console.ReadLine());

                if ((dificultad != 4) && (dificultad != 6))
                {
                    valorNoValido = true;
                    Console.WriteLine("\tERROR: El valor introducido no es válido");
                }

            } while (valorNoValido);


            rellenaArray(out solucion, out mostrar, dificultad);
            Console.WriteLine("Relleno!");
            do
            {
                // 3. Entrar en el juego.
                //3.0. Imprimir tablero de juego

                imprimeTableroJuego(mostrar, dificultad);
                imprimeTableroJuego(solucion, dificultad);

                // 3.1. Pedir coordernadas.

                int[] coords1Ficha;
                int[] coords2Ficha;
                bool error;

                do
                {
                    error = false;
                    pideCoordenadas("primera", out coords1Ficha, mostrar.GetLength(0));
                    pideCoordenadas("segunda", out coords2Ficha, mostrar.GetLength(0));

                    if ((coords1Ficha[0] == coords2Ficha[0]) & (coords1Ficha[1] == coords2Ficha[1]))
                    {
                        Console.WriteLine("\tERROR: Las coordenadas introducidas para ambas fichas son iguales. Instroduzcalas de nuevo");
                        error = true;
                    }

                } while (error);

                // 3.2.1. Si coordenadas son repetidas entonces => 
                // 3.2.1.1. mensaje de error
                // 3.2.1.2. volver a pedir coordenadas (volver al 3.1.)
                // 3.2.2 coordenadas no repetidas

                //3.2.2.1. comprobamos si los contenidos de las coordenadas son iguales
                //3.2.2.2.1.si son iguales

                comprobarJugada(ref mostrar, solucion, coords1Ficha, coords2Ficha, mostrar.GetLength(0));
                contadorIntentos++;

                //3.2.2.2. imprimimos el array mostrar y esperamos a tecla enter
                //3.2.2.2.1. si la coordenada que estamos imprimiendo es una de las que nos ha dado
                //3.2.2.2.1.1. entonces imprimimos el contenido del array Solucion para esa coordenada

                imprimirJugada(mostrar, solucion, mostrar.GetLength(0), coords1Ficha, coords2Ficha);

                //3.3. comprobamos que la matriz mostrar no contenga interrogantes "?"

                finTablero = comprobarFinTablero(mostrar, mostrar.GetLength(0));
                //3.3.2. si contiene interrogantes "?"
                //3.3.2.1. volvemos al 3.1. pedir coordenadas.

            } while (!finTablero);

            Console.WriteLine("Fin del juego!");
            Console.WriteLine("Has necesitado " + contadorIntentos + " intentos para resolver el tablero");
            Console.WriteLine("Hasta la próxima!");

            Console.ReadKey();

        }


        // funcion que genera y devuelve una letra aleatoria con return del alfabeto ingernacional 
        private static char letraAleatoria()
        {
            int indiceLetra;
            char[] letras = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'Y', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
            Random rand = new Random();    // creamos un objeto generador de números aleatorios

            indiceLetra = rand.Next(letras.Length);
            return letras[indiceLetra];
        }


        // generador de parejas de coordenadas aleatorias
        private static void generaParejasCoordenadasAleatorias(out int[,] parejas, int tamano, char[,] solucion)
        {
            int primeraCoordenada;
            int segundaCoordenada;
            parejas = new int[2, 2];
            Random rand = new Random();
            bool coordenadaValida;

            // primera tarjeta 
            do
            {
                coordenadaValida = false;
                primeraCoordenada = rand.Next(0, tamano);
                segundaCoordenada = rand.Next(0, tamano);

                if (solucion[primeraCoordenada, segundaCoordenada].Equals('\0'))
                {
                    coordenadaValida = true;
                }
            } while (!coordenadaValida);

            parejas[0, 0] = primeraCoordenada;
            parejas[0, 1] = segundaCoordenada;


            // segunda tarjeta 
            do
            {
                coordenadaValida = false;
                primeraCoordenada = rand.Next(0, tamano);
                segundaCoordenada = rand.Next(0, tamano);

                if (solucion[primeraCoordenada, segundaCoordenada].Equals('\0'))
                {
                    coordenadaValida = true;
                }

                parejas[1, 0] = primeraCoordenada;
                parejas[1, 1] = segundaCoordenada;

                if ((parejas[0, 0] == parejas[1, 0]) && (parejas[0, 1] == parejas[1, 1]))
                {
                    coordenadaValida = false;
                }
            } while (!coordenadaValida);
        }


        // funcion que rellena los arrays de solucion y el que mostramos
        private static void rellenaArray(out char[,] solucion, out char[,] mostrar, int tamano)
        {
            String letrasIntroducidas = "";     // nos permite controlar qué letras ya hemos incorporado a la solución, para evitar parejas duplicadas
            char letra;
            int[,] parejas;
            bool error;

            // inicializamos los arrays al tamaño dificultad x dificultad
            solucion = new char[tamano, tamano];
            mostrar = new char[tamano, tamano];

            for (int i = 0; i < tamano; i++)
            {
                for (int j = 0; j < tamano / 2; j++)
                {
                    generaParejasCoordenadasAleatorias(out parejas, tamano, solucion);
                    do
                    {
                        error = true;
                        letra = letraAleatoria();
                        if (letrasIntroducidas.IndexOf(letra) < 0)    // IndexOf devuelve -1 si no lo encuentra
                        {
                            error = false;
                        }
                    } while (error);

                    letrasIntroducidas += letra;

                    solucion[parejas[0, 0], parejas[0, 1]] = letra;
                    solucion[parejas[1, 0], parejas[1, 1]] = letra;

                    // rellenamos la matriz mostrar con '?'
                    //mostrar[i, j] = '?';
                    mostrar[parejas[0, 0], parejas[0, 1]] = '?';
                    mostrar[parejas[1, 0], parejas[1, 1]] = '?';
                }
            }
        }


        //funcion que imprime el tablero del juego
        private static void imprimeTableroJuego(char[,] tablero, int tamano)
        {
            for (int i = 0; i < tamano; i++)
            {
                for (int j = 0; j < tamano; j++)
                {
                    Console.Write("\t" + tablero[i, j]);
                }
                Console.Write("\n");
            }
        }


        /** función que solicita y devuelve las coordenadas de la jugada **/
        private static void pideCoordenadas(String ordenFicha, out int[] coords, int tamano)
        {
            bool error;
            do
            {
                error = false;
                Console.WriteLine("Dame las coordenadas de la " + ordenFicha.ToUpper() + " ficha (f,c): ");
                String coordenadas = Console.ReadLine();
                String[] arrCoordenadas = coordenadas.Split(',');

                coords = new int[2];
                coords[0] = Int32.Parse(arrCoordenadas[0]); // fila
                coords[1] = Int32.Parse(arrCoordenadas[1]); // columna

                //coords = new int[Int32.Parse(arrCoordenadas [0]), Int32.Parse(arrCoordenadas [1])];
                // 3.2 Comprobar coordenadas no sean repetidas y 
                // no estén fuera de rango

                if (!((coords[0] >= 0) & (coords[0] < tamano) & (coords[1] >= 0) & (coords[1] < tamano)))
                {
                    Console.WriteLine("\tERROR: las coordenadas introducidas están fuera de rango)");
                    error = true;
                }
            } while (error);
        }



        private static void imprimirJugada(char[,] mostrar, char[,] solucion, int tamano, int[] coords1Ficha, int[] coords2Ficha)
        {
            for (int i = 0; i < tamano; i++)
            {
                Console.Write("\t");
                for (int j = 0; j < tamano; j++)
                {
                    // si la coordenadas coinciden con las coordenadas de ficha1, "destapamos" la ficha 1
                    if (i == coords1Ficha[0] && j == coords1Ficha[1])
                    {
                        Console.Write(solucion[i, j]);
                    } // si la coordenadas coinciden con las coordenadas de ficha1, "destapamos" la ficha 1
                    else if (i == coords2Ficha[0] && j == coords2Ficha[1])
                    {
                        Console.Write(solucion[i, j]);
                    } // si las coordenadas NO coinciden con las coordenadas de ficha1 o ficha2, imprimimos lo que contenga mostrar en esas coordenadas
                    else
                    {
                        Console.Write(mostrar[i, j]);
                    }
                    Console.Write("\t");
                }
                // fin de línea => salto de línea
                Console.Write("\n");
            }
            Console.Write("\n\n");

            //3.2.2.3 esperamos tecla enter
            Console.ReadKey();
        }



        // devuelve true si se ha resulto el tablero o false si todavia no se ha resuelto
        private static bool comprobarFinTablero(char[,] mostrar, int tamano)
        {
            for (int i = 0; i < tamano; i++)
            {
                for (int j = 0; j < tamano; j++)
                {
                    if (mostrar[i, j].Equals('?'))
                    {
                        return false;
                    }
                }
            }
            return true;
        }


        //3.2.2.2.2.modificamos el array mostrar poniendo las solucion de esas coordenados.
        private static void comprobarJugada(ref char[,] mostrar, char[,] solucion, int[] coords1Ficha, int[] coords2Ficha, int tamano)
        {
            if (solucion[coords1Ficha[0], coords1Ficha[1]].Equals((solucion[coords2Ficha[0], coords2Ficha[1]])))
            {
                mostrar[coords1Ficha[0], coords1Ficha[1]] = solucion[coords1Ficha[0], coords1Ficha[1]];
                mostrar[coords2Ficha[0], coords2Ficha[1]] = solucion[coords2Ficha[0], coords2Ficha[1]];
            }
        }

    }
}
