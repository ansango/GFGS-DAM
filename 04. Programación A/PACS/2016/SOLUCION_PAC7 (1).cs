using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace solucionUF3PT1
{
    class Program
    {
        
            struct Kart
        {
            public string nombre;
            public double tiempo;
            public int vueltas;
        }
        static void Main(string[] args)
        {
            //Creamos el array de corredores
            Kart[] corredores = new Kart[100];
            //leemos el fichero para saber cuantos corredores hay
            
            int cuantos = leerFichero(corredores);
            escribirResultados(corredores, cuantos);
            //mostramos por pantalla los resultados
            
            Console.ReadLine();
        }
        static void escribirResultados(Kart[] todos, int cantidad)
        {
            FileStream flujo = new FileStream("clasificacion.txt", FileMode.Create, FileAccess.Write);
            StreamWriter fichero = new StreamWriter(flujo);
            for (int i = 0; i < cantidad; i++)
            {
                //esto no haria falta, pero lo muestro por pantalla
                Console.WriteLine("{0} --> {1} vueltas-->Mejor:{2}", todos[i].nombre, todos[i].vueltas, todos[i].tiempo);
                fichero.WriteLine("{0} --> {1} vueltas-->Mejor:{2}", todos[i].nombre, todos[i].vueltas, todos[i].tiempo);
            }
            fichero.Close();
            flujo.Close();
        }
        static int leerFichero(Kart[] todos)
        {
            //abrimos el fichero, que se llama karts.txt
            Console.WriteLine("Que fichero desea abrir?");
            String nombreFichero = Console.ReadLine();
            FileStream flujo = new FileStream(nombreFichero, FileMode.Open, FileAccess.Read);
            StreamReader fichero = new StreamReader(flujo);
            string linea = "", nombre="", mensaje="";
            double tiempo=-1;
            int nLinea=1, errores=0;
            int posicion=0, posaux=0;
            //leemos linea por linea
            while ((linea = fichero.ReadLine()) != null)
            {
                Console.WriteLine("\n*** Leemos linea {0}-->{1}",nLinea, linea);
                mensaje = "";
                //llamamos a la función comrpovar Errores, para saber si es correcta la linea o no
                if(!ComprovarErrores(linea, ref tiempo, ref nombre, ref mensaje))
                {
                   //si no es correcta, mostramos el mensaje de error que hemos preparado
                    Console.WriteLine("Error en linea {0}: {1}", nLinea, mensaje);
                    errores++;
                }
                else
                {
                    //Si todo es correcto, buscamos la posicion del kart en la estructura. Si la posicion
                    //Si la posicion es -1, añadimos el kart ya que no existe. Si es otro numero, sera
                    //la posicoin que modificaremos.
                    posaux = buscarKart(todos, posicion, nombre);
                    if(posaux!=-1)
                    {
                        //actualizamosKart, tiempo y vueltas
                        
                        if (todos[posaux].tiempo > tiempo)
                        {
                            todos[posaux].tiempo = tiempo;
                        }
                        todos[posaux].vueltas++;
                    }
                    else
                    {
                        //añadimos kart;
                        todos[posicion].nombre = nombre;
                        todos[posicion].tiempo = tiempo;
                        todos[posicion].vueltas = 1;
                        posicion++;
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
        static bool ComprovarErrores(string linea, ref double tiempo, ref string nombre, ref string mensaje)
        {
            //esta funcion sirve para comrpovar si la linea es correcta o no
            //suponemos que es correcta
            bool resultado = true;
            nombre = "";
            tiempo = -1;
            string[] separado= linea.Split(' ');//hago un split por el espacio. asi tengo en la posicion 0 la primera parte
            //y en la 1 la segunda
            //si no hay dos posiciones exactamente, la linea es erronea
            if (separado.Length != 2)
            {
                resultado = false;
                mensaje=mensaje + "Numero de espacios incorrecto\t";
            }
            else
            {
                //llamo a una función para comprovar el nombre
                //Si el nombre no es correcto, la linea es erronea
                if (comprovarNombre(separado[0]))
                {
                    nombre = separado[0];
                }
                else
                {
                    mensaje = mensaje + "Nombre incorrecto\t";
                    resultado = false;
                }
                //llamo a una función para comprovar el tiempo
                //Si el tiempo no es correcto, la linea es erronea. Si es correcto, lo guardo
                if (comprovarTiempo(separado[1]))
                {
                    //En caso de ser correcto, sustituyo el punto por la coma, sino no me lo convertirá bién a double.
                    separado[1]=separado[1].Replace('.', ',');
                    tiempo = Double.Parse(separado[1]);
                }
                else
                {
                    mensaje = mensaje + "Tiempo incorrecto\t";
                    resultado = false;
                }
            }
            //Si todo es correcto, devuelvo true, 
            return resultado;
        }
        static bool comprovarNombre(string nombre)
        {
            bool resultado = true;
            //si la medida es incorrecta, es error
            if (nombre.Length < 5 || nombre.Length > 7)
            {
                resultado = false;
            }
            else
            {
                //PALABRA KART seguido de entre 1 y 3 numeros
                //partimos la palabra
                string parte1 = nombre.Substring(0, 4);
                string parte2 = nombre.Substring(4, nombre.Length - 4);
                //comprovamos que la parte2 sea un numero
                //En caso que no sea un numero, resultado valdra falso.
                int numero;
                resultado = int.TryParse(parte2, out numero);
                
                //comprovamos que la primera sea KART, y que haya entre 1 y 3 digitos despues.
                
                if(parte1!="KART")
                {
                    resultado = false;
                }
                else if(parte2.Length<1 || parte2.Length>3)
                {
                    resultado = false;
                }

            }
            //devolveremos resultado, sabiendo que si es falso, el nombre tendrá un error.
            return resultado;
        }
        static bool comprovarTiempo(string tiempo)
        {
            bool resultado = true;
            //si la longitud es incorrecta, es error
            if (tiempo.Length < 4 || tiempo.Length > 6)
            {
                resultado = false;
            }
            else
            {
                //antes del punto,  entre 1 y 3 caracteres numericos.
                //partimos la palabra
                string[] partes = tiempo.Split('.');
                //si no hay dos partes, signigica que no hay punto, o hay mas de un punto, por tanto error
                if (partes.Length != 2)
                {
                    resultado = false;
                }
                else
                {
                    //si hay dos partes exactamente, miro que tengan la longitud pedida y que sean numeros...
                    //parte uno, entre 1 y 3 digitos
                    if (partes[0].Length < 1 || partes[0].Length>3)
                    { resultado = false; }
                    //parte 2, 2 digitos
                    else if (partes[1].Length != 2)
                    { resultado = false; }
                    else
                    {
                        double x = -1;
                        //al hacer el tryParse, resultado sera falso si no es un double lo que hay en "tiempo"
                        resultado = Double.TryParse(tiempo, out x);
                        //En caso de tiempo negativo, el resultado es falso.
                        if(x<0)
                        {
                            resultado = false;
                        }
                    }

                }
            }    
            return resultado;
        }
        static int buscarKart(Kart [] todos, int cantidad, string nombre)
        {
            //esta funcion sirve para comprovar que el kart ya exista. 
            //si existe, devuelve la posicion donde se encuentra, Si no existe devuelve -1
            //asi sabre si debo añadir el kart o modificarlo.
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
