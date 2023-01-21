using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication3
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            do
            {
                do
                {
                    Console.WriteLine("Para opcion1, pulse 1");
                    Console.WriteLine("Para opcion2, pulse 2");
                    Console.WriteLine("Para opcion3, pulse 3");
                    Console.WriteLine("Para salir, pulse 4");

                    opcion = Int32.Parse(Console.ReadLine());

                } while (opcion < 1 || opcion > 4);


                switch (opcion)
                {
                    case 1:
                        Opcion1();
                        break; // para que no continue con el resto del codigo del switch. se sale del switch

                    case 2:
                        Console.WriteLine("Dame la primera cadena");
                        String cad1 = Console.ReadLine();

                        Console.WriteLine("Dame la segunda cadena");
                        String cad2 = Console.ReadLine();

                        String resultado = "";

                        Opcion2(cad1, cad2, ref resultado); //paso las cad1 y cad2 por valor y resultado por referencia para que la modifque

                        Console.WriteLine(resultado);
                        break;

                    case 3:
                        Console.WriteLine("Dame una cadena");
                        String cadena = Console.ReadLine();

                        Console.WriteLine("Dame un numero");
                        int numero = Int32.Parse(Console.ReadLine());

                        int longitud = Opcion3(ref cadena, numero);

                        Console.WriteLine("La cadena devuelta " + cadena + " tiene una longitud de " + longitud + " caracteres");
                        break;

                    case 4:
                        Console.WriteLine("Gracias por su tiempo");
                        break;

                }
                Console.ReadKey(); // para que no se cierre ventana
            } while (opcion != 4); // mientras no seleccionemos la opcion 4 se ejecutando el programa

        }

        public static void Opcion1 ()

        {
            int aleatorio1, aleatorio2; //valores aleatorio
            int i;                      //iterador del bucle
            int tmp;
            Random rand = new Random (); // creamos un generador de numeros aleatorios

            aleatorio1 = rand.Next(10, 30);
            aleatorio2 = rand.Next(10, 30);

            if(aleatorio1 > aleatorio2) {  // comprobamos orden de limites, e intercambiamos en caso necesario
                tmp = aleatorio1;          // utilizamos una variable temporal para hacer el intercambio
                aleatorio1 = aleatorio2;
                aleatorio2 = tmp;
            }

            //Imprimo numeros aleatorios generados
            Console.WriteLine("aleatorios " + aleatorio1.ToString() + " " + aleatorio2.ToString());

            //for(i=aleatorio1+1;  i < aleatorio2; i++) // recorremos todos los valores entre aleatorio1 y aleatorio2 sin inluir los extremos aleatorio1 y aleatorio2
            for (i=aleatorio1; i <= aleatorio2; i++) // recorremos todos los valores entre aleatorio1 y aleatorio2 inluidos los extremos aleatorio1 y aleatorio2
            {
                    Console.WriteLine(i);
            }

        }

        static void Opcion2(String cad1, String cad2, ref String resultado) {

            //pasamos las cadenas a minusculas para compararlas mejor
            String cad1Min = cad1.ToLower();
            String cad2Min = cad2.ToLower();

            //comparamos las cadenas. Devuelve un nº negativo si cadMin es menor que cad2Min, nº positivo si cadMin es mayor que cad2Min, o 0 si son iguales
            int comp = String.Compare(cad1Min, cad2Min);

            if (comp < 0)
            {
                resultado = "MENOR";
            }
            else if (comp==0)
            {
                resultado = "IGUAL";
            }
            else
            {
                resultado = "MAYOR";
            }
            //no hacemos return porque devolvemos resultado por referencia    
        }

        static int Opcion3(ref String cadena, int entero) {
            String auxiliar = "";
            for (int i = 0; i < entero; i++) {
                auxiliar += cadena; //concatenamos la cadena en auxiliar
            }
            cadena = auxiliar;      //guardamos la cadena concatenada para devolverla por referencia
            return cadena.Length;  // devolvemos la longitud de la cadena por valor
        }

    }
}
