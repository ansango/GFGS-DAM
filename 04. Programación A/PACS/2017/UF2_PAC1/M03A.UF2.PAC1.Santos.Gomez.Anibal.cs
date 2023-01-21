using System;

namespace PAC1_UF2
{
	class Program
	{

		//MAIN

		static void Main(string[] args)
		{
            //Declaro las variables:

			int opcion = 0;
            int n1, n2, n3;
            int resultado;
            int multi2 = 0, multi3 = 0, multi5 = 0;
            string  cad1, cad2, cad3;

           //Con do While creo un menú de tres opciones
            do
			{
				Console.WriteLine("Elige una opción: \n 1, 2, 3 o 4 para salir");
				opcion = int.Parse(Console.ReadLine());

				//selección OPCION 1

				if (opcion == 1)
				{
					Console.WriteLine("Introduce el primer numero");
					n1 = int.Parse(Console.ReadLine());

					Console.WriteLine("Introduce el segundo numero");
					n2 = int.Parse(Console.ReadLine());

					Console.WriteLine("Introduce el tercer numero");
					n3 = int.Parse(Console.ReadLine());

					opcion1(n1, n2, n3);
                 }

				//selección OPCION 2

				else if (opcion == 2)
				{
					Console.WriteLine("Introduce la primera cadena");
					cad1 = Console.ReadLine();

					Console.WriteLine("Introduce la segunda cadena");
					cad2 = Console.ReadLine();
                    			
                    resultado = opcion2(cad1, cad2, out cad3);

                    Console.WriteLine(cad3);
                    Console.WriteLine(resultado + " repeticiones");
                 }

				//selección OPCION 3

				else if (opcion == 3) 
				{

					Random rand = new Random();

					n1 = rand.Next(1,101);
					n2 = rand.Next(1, 101);


                    Console.WriteLine("Números aleatorios: " + n1 + " y " + n2);

                    opcion3(n1, n2, ref multi2, ref multi3, ref multi5);

                    if (multi2 == 1)
                    {
                        Console.WriteLine("El sumatorio es múltiplo de 2");
                    }
                    else Console.WriteLine("El sumatorio no es múltiplo de 2");

                    if (multi3 == 1)
                    {
                        Console.WriteLine("El sumatorio es múltiplo de 3");
                    }
                    else Console.WriteLine("El sumatorio no es múltiplo de 3");

                    if (multi5 == 1)
                    {
                        Console.WriteLine("El sumatorio es múltiplo de 5");
                    }
                    else Console.WriteLine("El sumatorio no es múltiplo de 5");
				}

            } while (opcion != 4);

            //Después del if generamos una cuarta opción con un condicional para salir del menu

			if (opcion == 4) 
			{
				Console.WriteLine("Gracias. Vuelva pronto"); 
			}
		}

		//OPCION 1

		static void opcion1(int nu1,int nu2, int nu3)
		{
            if(nu1>nu2) //primero llevamos a cabo el intercambio de variables
            {
                int help = nu2;
                nu2 = nu1;
                nu1 = help;
            }
            for (int i = nu2; i >= nu1;i--) //establecemos el bucle
            {
                if(i%nu3==0) //y aquí comprobamos si es múltiplo del tercer número.
                {
                    Console.WriteLine(i);
                }
            }
		}

		//OPCION 2

        static int opcion2(string txt1, string txt2, out string txt3)
        {
            //transformamos las cadenas recibidas a mayusculas

            txt1 = txt1.ToUpper();
            txt2 = txt2.ToUpper();
            txt3 = "";

            int contador = 0;

            //hacemos las condiciones

            while(txt3.Length < 5 * txt1.Length) //debe tener longitud menor o igual a 5 veces txt1
            {
                //txt3 estara formada por txt1 + espacio + txt2 + espacio * numero de veces necesarias hasta 5

                txt3 = txt3 + txt1 + " " + txt2 + " ";

                contador++;
            }

            //por ultimo devolvemos las vueltas del bucle;

            return contador;
        }


        //OPCION 3

        static void opcion3(int nu1, int nu2, ref int mul2, ref int mul3, ref int mul5)
        {

            //sumamos los dos primeros numeros

            int sumatorio = nu1 + nu2;

            //hacemos condicionales exigidos

            if (sumatorio % 2 == 0)
            {
                mul2 = 1;
            }
            else mul2 = 0;

            if (sumatorio % 3 == 0)
            {
                mul3 = 1;
            }
            else mul3 = 0;

            if (sumatorio % 5 == 0)
            {
                mul5 = 1;
            }
            else mul5 = 0;
        }

		//OPCION 4 (Fin del programa (no se implementa))
	}
}
