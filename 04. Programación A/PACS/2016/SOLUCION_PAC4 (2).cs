using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SolucionPac4
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcion = 0;
            do
            {
                Console.WriteLine("Escoje opcion: \n 1, 2, 3 o 4 para salir");
                opcion = int.Parse(Console.ReadLine());
                if(opcion==1)
                {
                    opcion1();
                }
                else if (opcion == 2)
                {
                    Console.WriteLine("Escribe una cadena");
                    string texto1 = Console.ReadLine();
                    Console.WriteLine("Escribe otra cadena");
                    string texto2 = Console.ReadLine();

                    string texto3;
                    opcion2(texto1, texto2, out texto3);
                    Console.WriteLine(texto3);
                }
                else if(opcion==3)
                {
                    Console.WriteLine("Escribe una cadena");
                    string texto1 = Console.ReadLine();
					int numero = 0;
                    do
					{
						Console.WriteLine("Escribe un numero");
						numero = int.Parse(Console.ReadLine());
					}while (numero<0);
                    int longitud = opcion3(ref texto1, numero);
                    Console.WriteLine(texto1 + " " + longitud);
                }


            } while (opcion != 4);
        }
        static void opcion1()
        {
            Random r = new Random();
            int num1 = r.Next(10, 31);
            int num2 = r.Next(10, 31);
            if (num1>num2)
            {
                int aux = num2;
                num2 = num1;
                num1 = aux;
            }
            for (int i = num1; i <= num2; i++)
            {
                Console.WriteLine(i);
            }
        }
        static void opcion2(string cad1, string cad2, out string cad3)
        {
            cad1 = cad1.ToLower();
            cad2 = cad2.ToLower();
            if(cad1.CompareTo(cad2)<0)
            {
                cad3 = "MENOR";
            }
            else if (cad1.CompareTo(cad2) > 0)
            {
                cad3 = "MAYOR";
            }
            else { cad3 = "IGUAL"; }

        }
        static int opcion3(ref string cad1,int num)
        {
            string aux = cad1;
            cad1 = "";
            for (int i = 0; i < num; i++)
            {
                cad1 = cad1 + aux;
            }
            return cad1.Length;
        }
    }
}