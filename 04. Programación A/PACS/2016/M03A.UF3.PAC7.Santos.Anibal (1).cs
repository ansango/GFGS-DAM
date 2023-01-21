using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace PAC7_Karts
{
    class Kart
    {
        private string nombre;
        private decimal mejorTiempo;
        private int numVueltas;

        public Kart(string nombre, decimal primerTiempo)
        {
            this.nombre = nombre;   // this.nombre se refiere a la propiedad nombre del objeto. Mientras que nombre (sin this.) se refiere al parámetro recivido por el método
            this.mejorTiempo = primerTiempo;
            this.numVueltas = 1;
        }

        public void SetMejorTiempo(decimal tiempo)  // modifica el mejor tiempo de mi kart
        {
            if (this.mejorTiempo > tiempo)
            {
                this.mejorTiempo = tiempo;
            }
        }

        public decimal GetMejorTiempo()  // permite leer el mejorTiempo de mi kart
        {
            return this.mejorTiempo;
        }

        public void AddVuelta()     // suma una vuelta al contador de vueltas de mi kart
        {
            this.numVueltas++;
        }

        public string GetNombre()
        {
            return this.nombre;
        }

        public string info()
        {
            return (this.nombre + " Mejor Vuelta: " + this.mejorTiempo / 100 + " Numero de vueltas: " + this.numVueltas);
        }
    }


    class Program
    {
        static void Main(string[] args)
        {
            // Leer fichero (pedir nombre fichero, comprobar si fichero existe; leer fichero)

            // leer línea por línea
            // comprobar si la línea tiene formato correcto
            // si formato no correcto => indicar error
            // si formato correcto =>
            // comprobar valores
            // leer nombre kart
            // leer tiempo
            // aumentar contador vueltas coche
            // comprobamos si nuevo tiempo es mejor que MEJOR tiempo
            // si es mejor => modificamos MEJOR tiempo
            // si es peor => no modificamos


            // crear fichero clasificacion.txt ( en cualquier punto )
            // volcar datos en clasificacion.txt


            string linea;
            int cuentaLineas = 0;
            int cuentaIncorrectas = 0;
            string[] arrLinea;
            Regex rgxNombre = new Regex(@"(KART)[0-9][0-9]?[0-9]?$");
            Regex rgxTiempo = new Regex(@"^[0-9][0-9]?[0-9]?\.[0-9][0-9]$");


            // Creamos un diccionario para los karts y sus tiempos
            Dictionary<string, Kart> diccionarioKarts = new Dictionary<string, Kart>();


            // Lectura de fichero
            System.IO.StreamReader ficheroLectura = new System.IO.StreamReader(@"C:\Users\ansan\Desktop\Karts.txt");

            while ((linea = ficheroLectura.ReadLine()) != null)
            {
                cuentaLineas++;
                System.Console.WriteLine("\n*** Leemos linea " + cuentaLineas + "-->" + linea);
                //System.Console.WriteLine("\n*** Leemos linea {0} --> {1}", cuentaLineas, linea);
                string msgError = "Error en línea " + cuentaLineas + ":";
                bool hayError = false;
                arrLinea = linea.Split(' ');

                // comprobamos que la cantidad de datos por línea es correcto
                if (arrLinea.Length != 2)
                {
                    msgError += "Numero de espacios incorrecto \t";
                    hayError = true;
                    cuentaIncorrectas++;
                }

                // comprobamos el nombre arrLinea[0]
                else
                {
                    if (rgxNombre.IsMatch(arrLinea[0]) == false)
                    {
                        msgError += "Nombre incorrecto \t";
                        hayError = true;
                        cuentaIncorrectas++;
                    }

                    // comprobamos el tiempo. arrLinea[1] 
                    if (rgxTiempo.IsMatch(arrLinea[1]) == false)
                    {
                        msgError += "Tiempo incorrecto \t";
                        hayError = true;
                        cuentaIncorrectas++;
                    }
                }

                if (hayError)
                {
                    System.Console.WriteLine(msgError);
                }
                else
                {
                    if (diccionarioKarts.ContainsKey(arrLinea[0]))
                    {
                        diccionarioKarts[arrLinea[0]].SetMejorTiempo(Convert.ToDecimal(arrLinea[1]));
                        diccionarioKarts[arrLinea[0]].AddVuelta();
                    }
                    else
                    {
                        Kart k = new Kart(arrLinea[0], Convert.ToDecimal(arrLinea[1]));
                        diccionarioKarts.Add(k.GetNombre(), k);
                    }
                }
            }

            // termina de leer el fichero y lo cerramos
            ficheroLectura.Close();

            System.Console.WriteLine("He leido " + cuentaLineas + " líneas ");

            System.Console.WriteLine("\n\n");


            ///////////////////////////////////////////////////////////////////
            // escribimos el fichero de clasificación                        //
            ///////////////////////////////////////////////////////////////////

            // using: entra en el bloque en caso de que lo que tiene entre paréntesis se ejecute correctamente
            using (System.IO.StreamWriter ficheroEscritura = new System.IO.StreamWriter(@"C:\Users\ansan\Desktop\clasificacion.txt"))
            {
                foreach (var entradaDiccionario in diccionarioKarts)
                {
                    //System.Console.WriteLine(entradaDiccionario.Value.info());
                    ficheroEscritura.WriteLine(entradaDiccionario.Value.info());
                } // finaliza de leer el diccionario

                // cerramos el fichero de escritura
                ficheroEscritura.Close();
            }

            System.Console.ReadLine();

        }
    }
}
