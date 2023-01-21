using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
namespace TrabajoConFicheros
{
    class Program
    {
        struct persona
        {
            public string nombre;
            public int edad;
            public double altura;
        }
        
            static void Main(string[] args)
            {


              //  leerTexto();
              //  escribirTexto();
                persona[] clase = new persona[100];
               // crearPersonasEjemplo(clase);
               // escribirBinario(clase);
               // leerBinario(clase);
                Console.WriteLine("Vamos a leer un fichero binario y cargar todos los datos en el array de personas");
                persona[] clase2 = new persona[100];
                leerBinarioTodos(clase2);
                Console.ReadLine();
            }

            static void leerTexto()
            {
                FileStream flujo = new FileStream("ejemplo.txt", FileMode.Open, FileAccess.Read);
                StreamReader fichero = new StreamReader(flujo);
                string linea = "";
                while ((linea = fichero.ReadLine()) != null)
                {
                    Console.WriteLine("***-->{0}", linea);

                }
                fichero.Close();
                flujo.Close();

            }
            static void escribirTexto()
            {
                FileStream flujo = new FileStream("ejemplo2.txt", FileMode.Create, FileAccess.Write);
                StreamWriter fichero = new StreamWriter(flujo);
                string linea = "";
                while (linea != "FIN")
                {
                    Console.WriteLine("Entra texto. FIN para finalizar");
                    linea = Console.ReadLine();
                    if (linea != "FIN")
                        fichero.WriteLine(linea);

                }
                //Si no cerramos, no se guarda!
                fichero.Close();
                flujo.Close();
            }
            static void leerBinario(persona[] clase)
            {
                FileStream flujo = new FileStream("ejemplo3.txt", FileMode.Open, FileAccess.Read);
                BinaryReader fichero = new BinaryReader(flujo);
                //vamos a rellenar las posiciones 4 y 5
                clase[4].nombre = fichero.ReadString();
                clase[4].edad = fichero.ReadInt32();
                clase[4].altura = fichero.ReadDouble();
                clase[5].nombre = fichero.ReadString();
                clase[5].edad = fichero.ReadInt32();
                clase[5].altura = fichero.ReadDouble();
                fichero.Close();
                flujo.Close();

                mostrar(clase, 6);

            }
            static void leerBinarioTodos(persona[] clase)
            {
                FileStream flujo = new FileStream("ejemplo3.txt", FileMode.Open, FileAccess.Read);
                BinaryReader fichero = new BinaryReader(flujo);
                //vamos a rellenar un nuevo array de peronas, tantas como haya en el fichero
                int contador = 0;
                while (fichero.BaseStream.Position != fichero.BaseStream.Length)
                {
                    clase[contador].nombre = fichero.ReadString();
                    clase[contador].edad = fichero.ReadInt32();
                    clase[contador].altura = fichero.ReadDouble();
                    contador++;
                }
                fichero.Close();
                flujo.Close();

                mostrar(clase, contador);

            }
            static void mostrar(persona[] vector, int cantidad)
            {
                for (int i = 0; i < cantidad; i++)
                {
                    Console.WriteLine("Persona: {0} {1} {2}", vector[i].nombre, vector[i].edad, vector[i].altura);
                }
            }
            static void escribirBinario(persona[] clase)
            {

                //Escribimos datos binarios. Debemos saber el orden en que los escribimos para posteriormente leerlos por ese orden


                FileStream flujo = new FileStream("ejemplo3.txt", FileMode.Create, FileAccess.Write);
                BinaryWriter fichero = new BinaryWriter(flujo);
                fichero.Write(clase[0].nombre);
                fichero.Write(clase[0].edad);
                fichero.Write(clase[0].altura);
                fichero.Write(clase[1].nombre);
                fichero.Write(clase[1].edad);
                fichero.Write(clase[1].altura);
                fichero.Close();
                flujo.Close();
            }
            static void crearPersonasEjemplo(persona[] vector)
            {
                //Creamos personas de ejemplo...
                vector[0].nombre = "Marc";
                vector[0].edad = 28;
                vector[0].altura = 1.75;
                vector[1].nombre = "Jose";
                vector[1].edad = 22;
                vector[1].altura = 1.54;
                vector[2].nombre = "Ana";
                vector[2].edad = 27;
                vector[2].altura = 1.63;
                vector[3].nombre = "Andrea";
                vector[3].edad = 44;
                vector[3].altura = 1.71;

            }
        }

    
}
