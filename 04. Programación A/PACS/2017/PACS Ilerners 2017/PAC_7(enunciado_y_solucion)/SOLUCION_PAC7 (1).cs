using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace solucionUF3PT1
{
            struct Tren
        {
            public string nombre;
            public int plazas;
            public int libres;
        }
        static void Main(string[] args)
        {
            //Creamos el array de corredores
            Tren[] trenes = new Tren[100];
            //leemos el fichero para saber cuantos corredores hay

            int cuantos = leerFichero(trenes);
            escribirResultados(trenes, cuantos);
            //mostramos por pantalla los resultados
            
            Console.ReadLine();
        }
        static void escribirResultados(Tren[] todos, int cantidad)
        {
            FileStream flujo = new FileStream("ocupacion.txt", FileMode.Create, FileAccess.Write);
            StreamWriter fichero = new StreamWriter(flujo);
            for (int i = 0; i < cantidad; i++)
            {
                //esto no haria falta, pero lo muestro por pantalla
                Console.WriteLine("Tren {0} Plazas totales: {1} Plazas libres:{2}", todos[i].nombre, todos[i].plazas, todos[i].libres);
                fichero.WriteLine("Tren {0} Plazas totales: {1} Plazas libres:{2}", todos[i].nombre, todos[i].plazas, todos[i].libres);
            }
            fichero.Close();
            flujo.Close();
        }
        static int leerFichero(Tren[] todos)
        {
            //abrimos el fichero, que se llama karts.txt
            Console.WriteLine("Que fichero desea abrir?");
            String nombreFichero = Console.ReadLine();
            FileStream flujo = new FileStream(nombreFichero, FileMode.Open, FileAccess.Read);
            StreamReader fichero = new StreamReader(flujo);
            string linea = "", nombre="", mensaje="", evento="";
            int numero=-1;
            int nLinea=1, errores=0;
            int posicion=0, posaux=0;
            //leemos linea por linea
            while ((linea = fichero.ReadLine()) != null)
            {
                Console.WriteLine("\n*** Leemos linea {0}-->{1}",nLinea, linea);
                mensaje = "";
                //llamamos a la función comrpovar Errores, para saber si es correcta la linea o no
                if(!ComprovarErrores(linea, ref numero, ref evento, ref nombre, ref mensaje))
                {
                   //si no es correcta, mostramos el mensaje de error que hemos preparado
                    Console.WriteLine("Error en linea {0}: {1}", nLinea, mensaje);
                    errores++;
                }
                else
                {
                    //busco el tren
                    posaux = buscarTren(todos, posicion, nombre);
                    //Si la linea es correcta, dependerá del eveto. Si es CREAR o COMPRAR
                    //Si es crear, y el tren existe, es error. Si no existe, se añade.
                    if (evento == "CREAR")
                    {
                        //si el tren existe, la posaux no será -1
                        if (posaux != -1)
                        {
                            //si existe error.

                            Console.WriteLine("Error en linea {0}: Evento CREAR con tren existente", nLinea);
                            errores++;
                        }
                        else
                        {
                            //añadimos tren;
                            todos[posicion].nombre = nombre;
                            todos[posicion].plazas = numero;
                            todos[posicion].libres = numero;
                            //aumentamos total de trenes
                            posicion++;
                        }
                    }
                    else
                    {
                        //si el tren no existe, la posaux  será -1
                        if (posaux == -1)
                        {
                            //si existe error.

                            Console.WriteLine("Error en linea {0}: Evento COMPRAR con tren inexistente", nLinea);
                            errores++;
                        }
                        else
                        {
                            //si tenemos suficientes billetes, acutalizamos. Sino error.
                            if (numero < todos[posaux].libres)
                                todos[posaux].libres = todos[posaux].libres - numero;
                            else
                            {
                                Console.WriteLine("Error en linea {0}: Evento COMPRAR con numero de billetes insuficiente", nLinea);
                                errores++;
                            }
                        }

                    
                    }
                   
                }
                nLinea++;

            }
            //Mostramos cantidad de lineas y errores
            Console.WriteLine("Se trataron {0} lineas, siendo {1} incorrectas", nLinea-1, errores);
            fichero.Close();
            flujo.Close();
            //devolvemos cuantos hemos encontrado
            return posicion;
        }
        static bool ComprovarErrores(string linea, ref int numero, ref string evento, ref string tren, ref string mensaje)
        {
            //esta funcion sirve para comrpovar si la linea es correcta o no
            //suponemos que es correcta
            bool resultado = true;
            tren = "";
            numero = -1;
            string[] separado= linea.Split('#');//hago un split por el #. asi tengo en la posicion 0 la primera parte
            //y en la 1 la segunda y en la 2 la tercera
            //si no hay tres posiciones exactamente, la linea es erronea
            if (separado.Length != 3)
            {
                resultado = false;
                mensaje=mensaje + "Numero de # incorrecto\t";
            }
            else
            {
                //llamo a una función para comprovar el evento
                //Si el nombre no es correcto, la linea es erronea
                if (comprovarEvento(separado[0]))
                {
                    evento = separado[0];
                }
                else
                {
                    mensaje = mensaje + "Evento incorrecto\t";
                    resultado = false;
                }
                
                //llamo a una función para comprovar el nombre
                //Si el nombre no es correcto, la linea es erronea
                if (comprovarNombre(separado[1]))
                {
                    tren = separado[1];
                }
                else
                {
                    mensaje = mensaje + "Tren incorrecto\t";
                    resultado = false;
                }
                //llamo a una función para comprovar el tiempo
                //Si el tiempo no es correcto, la linea es erronea. Si es correcto, lo guardo
                if (comprovarNumero(separado[2]))
                {
                    //En caso de ser correcto, sustituyo el punto por la coma, sino no me lo convertirá bién a double.
                    
                    numero = int.Parse(separado[2]);
                }
                else
                {
                    mensaje = mensaje + "Numero incorrecto\t";
                    resultado = false;
                }
            }
            //Si todo es correcto, devuelvo true, 
            return resultado;
        }
        static bool comprovarEvento(string evento)
        {
            bool resultado = true;
            //si el evento no es crear o comprar en MAYUSCULAS, resultado=false;
            if (evento != "CREAR" && evento != "COMPRAR")
            {
                resultado = false;
            }
            return resultado;
        }

        static bool comprovarNombre(string nombre)
        {
            bool resultado = true;
            //si la longitud es incorrecta, es error
            if (nombre.Length !=8)
            {
                resultado = false;
            }
            else
            {
                //DOS MAYUSCULAS, seguidas de _ seguido de dos mayusculas, seguido de _, seguido de dos numeros
                //partimos la palabra
                string[] partes = nombre.Split('_');
                //si no hay 3 partes, error
                if (partes.Length != 3)
                {
                    resultado = false;
                }//si la longitud de cada parte no es dos, error
                else if (partes[0].Length != 2 || partes[1].Length != 2 || partes[2].Length != 2)
                {
                    resultado = false;
                }
                else
                { 
                    //miro si las dos primeras son letras, y son mayusculas.
                    if (!esMayuscula(partes[0]))
                        resultado = false;
                    else if (!esMayuscula(partes[1]))
                        resultado = false;
                        //y miro si la tercera parte son numeros.
                    else if (!comprovarNumero(partes[2]))
                        resultado = false;
                   
                }
            }
            //devolveremos resultado, sabiendo que si es falso, el nombre tendrá un error.
            return resultado;
        }
        static bool esMayuscula(string texto)
        {
            bool resultado = true;
            //paso el texto a mayusculas
            String texto2 = texto.ToUpper();
            //si no son iguales texto y texto2 es error.
            if(texto!=texto2) resultado=false;
            else
            {
                //miro que todos sean letras
                for (int i = 0; i < texto.Length; i++)
                {
                    if (!Char.IsLetter(texto[i]))
                        resultado = false;

                }
            }
           return resultado;
        }
        static bool comprovarNumero(string numero)
        {
            bool resultado = true;
            int x;

            //recorro numero, para ver si algun caracter no es un numero
            for (int i = 0; i < numero.Length; i++)
            {
                if (numero[i] != '0' && numero[i] != '1' && numero[i] != '2' && numero[i] != '3' && numero[i] != '4' &&
                    numero[i] != '5' && numero[i] != '6' && numero[i] != '7' && numero[i] != '8' && numero[i] != '9')
                {
                    resultado = false;
                }
            }

            //devuelvo resultado

            return resultado;
        }
        static int buscarTren(Tren[] todos, int cantidad, string nombre)
        {
            //esta funcion sirve para comprovar que el tren ya exista. 
            //si existe, devuelve la posicion donde se encuentra, Si no existe devuelve -1
            //asi sabre si debo añadir el tren o modificarlo.
            int encontrado = -1;
            for(int i=0;i<cantidad;i++)
            {
                if(todos[i].nombre==nombre)
                {
                    encontrado = i;
                    i = cantidad;
                }
            }
            return encontrado;
        }
    }
}
