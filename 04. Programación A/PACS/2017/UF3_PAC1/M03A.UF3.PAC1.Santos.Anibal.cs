using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace UF3_PAC1
{
    class Program
    {

        //******************* INDICE DEL PROGRAMA *******************

        //1. CREACION STRUCT

        //2. MAIN --- ARRAY / LECTURA DE FICHERO

        //3. ESCRITURA DE RESULTADO

        //4. LECTURA DE FICHERO

        //5. COMPROBAR ERRORES
        //5.1. COMPROBAR EVENTO
        //5.2. COMPROBAR NOMBRE
        //5.3. COMPROBAR TIEMPO - COMPROBAR NUMERO

        //6. RESTO DE COMPROBACIONES - PASO A MAYUS - BUSCA TREN
        //6.1. COMPROBACION EVENTO ************ (5.1.)
        //6.2. COMPROBACION NOMBRE ************ (5.2.)
        //6.2.1. PASO A MAYUS
        //6.3. COMPROBACION NUMERO - TIEMPO ************(5.3.)

        //7. BUSCA TREN

        //***********************************************************


        //1. CREACION STRUCT

        struct Tren
        {
            public string nombre;
            public int plazas;
            public int libres;
        }

        //2. MAIN --- ARRAY / LECTURA DE FICHERO

        static void Main(string[] args) 
        {
            //creacion array

            Tren[] train = new Tren[100];

            //lectura de fichero

            int num = LecturaFichero(train);
            EscribirResult(train, num);
        }

        //3. ESCRITURA DE RESULTADO

        static void EscribirResult(Tren[] all, int numm)
        {

            //abrimos flujo y fichero ocupacion.txt

            FileStream fl = new FileStream("ocupacion.txt", FileMode.Create, FileAccess.Write);

            StreamWriter fichero = new StreamWriter(fl);

            for (int i = 0; i < numm; i++)
            {
                Console.WriteLine(" El tren {0} con plazas {1} y plazas disponibles: {2} ", all[i].nombre, all[i].plazas, all[i].libres);
                fichero.WriteLine(" El tren {0} con plazas {1} y plazas disponibles: {2} ", all[i].nombre, all[i].plazas, all[i].libres);
            }

            //cerramos fichero y flujo

            fichero.Close();
            fl.Close();
        }

        //4. LECTURA DE FICHERO

        static int LecturaFichero(Tren[] all)
        {
            Console.WriteLine("Introduce fichero de apertura");
            String nomFichero = Console.ReadLine();

            //flujo

            FileStream fl = new FileStream(nomFichero, FileMode.Open, FileAccess.Read);
            StreamReader fichero = new StreamReader(fl);

            //variable y control segun enunciado

            string linea = "";
            string nom = "";
            string mensaje = "";
            string evento = "";
            int num = -1;
            int numLinea = 1;
            int error = 0;
            int posicion = 0;
            int aux = 0;

            //aqui leemos linea por linea

            while ((linea = fichero.ReadLine()) != null) //mientras la linea del fichero leida no sea nula
            {
                Console.WriteLine(" Lectura de linea {0} - - - - - {1} ", numLinea, linea);
                mensaje = "";

                //comprobamos que la linea es correcta utilizando la funcion de comprobar errores

                if (!ComprobacionERROR(linea, ref num, ref evento, ref nom, ref mensaje))
                {
                    Console.WriteLine(" Error en la linea {0} : {1} ", numLinea, mensaje);
                    error++;
                }

                //Busqueda del tren (7.)

                else
                {
                    aux = buscaTREN(all, posicion, nom);

                    //CREAR - - - COMPRAR

                    if(evento == " CREAR ")
                    {
                        if (aux != -1) //si el tren existe no es -1
                        {
                            Console.WriteLine(" ERROR en la línea {0}: CREAR. TREN EXISTENTE. ", numLinea);
                            error++;
                        }
                        else
                        {
                            all[posicion].nombre = nom;
                            all[posicion].plazas = num;
                            all[posicion].libres = num;

                            posicion++;
                        }
                    }
                    else 
                    {
                        //si el tren no existe es -1

                        if(aux == -1) //ERROR
                        {
                            Console.WriteLine(" ERROR en la línea {0}: COMPRAR. TREN NO EXISTENTE. ", numLinea);
                            error++;
                        }
                        else //control de plazas libres
                        {
                            if(num < all[aux].libres)
                            {
                                all[aux].libres = all[aux].libres - num;
                            }
                            else
                            {
                                Console.WriteLine(" ERROR en la línea {0}: COMPRAR. NO HAY BILLETES. ", numLinea);
                                error++;
                            }
                        }
                    }
                }
                numLinea++;
            }

            Console.WriteLine(" Se han controlado {0} líneas, de las cuales {1} son incorrectas. ",numLinea -1, error);
            fichero.Close();
            fl.Close();

            return posicion;

        }

        //5. COMPROBAR ERRORES

        static bool ComprobacionERROR(string linea, ref int num, ref string evento, ref string train, ref string mensaje)
        {
            //la funcion de comprobacion de errores la inicializamos y utlizamos un valor true

            bool result = true;
            train = "";
            num = -1;

            string[] separacion = linea.Split('#'); //hacemos un split para comprobar posiciones, 0 en la primera, 1 en la segunda y 2 en la tercera
                                                    //tiene que haber tres posiciones si <3 o >3 ERROR.

            if (separacion.Length != 3)
            {
                result = false;
                mensaje = mensaje + " El numero de # no es el correcto\t ";
            }
            else
            {
                //5.1. COMPROBAR EVENTO

                if (ComprobacionEVENTO(separacion[0]))
                {
                    evento = separacion[0];
                }
                else
                {
                    mensaje = mensaje + " El evento es incorrecto\t ";
                    result = false;
                }

                //5.2. COMPROBAR NOMBRE

                if (ComprobacionNOMBRE(separacion[1]))
                {
                    train = separacion[1];
                }
                else
                {
                    mensaje = mensaje + " El tren es incorrecto\t ";
                    result = false;
                }

                //5.3. COMPROBAR TIEMPO - COMPROBAR NUMERO

                if (ComprobacionNUMERO(separacion[2]))
                {
                    num = int.Parse(separacion[2]);
                }
                else
                {
                    mensaje = mensaje + " El número es incorrecto\t ";
                    result = false;
                }

            }

            //concluido la comprobacion de errores y siendo correcto, devolvera true

            return result;
        }

        //6. RESTO DE COMPROBACIONES - PASO A MAYUS - BUSCA TREN

        //6.1. COMPROBACION EVENTO ************ (5.1.)

        static bool ComprobacionEVENTO(string evento) 
        {
            bool result = true;

            //el evento tiene que ser CREAR o COMPRAR en MAYUS

            if (evento != "CREAR" && evento != "COMPRAR")
            {
                result = false;
            }
            return result;
        }

        //6.2. COMPROBACION NOMBRE ************ (5.2.)

        static bool ComprobacionNOMBRE(string nombre)
        {
            bool result = true;


            if(nombre.Length!=8)
            {
                result = false;
            }
            else
            {
                string[] parte = nombre.Split('_');
                if(parte.Length!=3)
                {
                    result = false;
                }
                else if(parte[0].Length!=2||parte[1].Length!=2||parte[2].Length!=2)
                {
                    result = false;
                }
                else
                {
                    if(!Mayus(parte[0]))
                    {
                        result = false;
                    }
                    else if(!Mayus(parte[1]))
                    {
                        result = false;
                    }
                    else if(!ComprobacionNOMBRE(parte[2]))
                    {
                        result = false;
                    }
                }
            }
            return result;
        }

        //6.2.1. PASO A MAYUS

        static bool Mayus(string txt)
        {
            bool result = true;

            //paso a mayus

            string txt2 = txt.ToUpper();

            //txt y txt2 tienen que ser iguales

            if (txt != txt2) { result = false; }

            //comprobamos que no se cuele ningun numero

            else 
            {
                for (int i = 0; i < txt.Length; i++)
                {
                    if(!Char.IsLetter(txt[i]))
                    {
                        result = false;
                    }
                }
            }

            return result;
        }

        //6.3. COMPROBACION NUMERO - TIEMPO ************(5.3.)

        static bool ComprobacionNUMERO(string num)
        {
            bool result = true;

            for(int i = 0; i < num.Length; i++)
            {
                if( num[i] != '0' && num[i] != '1' && num[i] != '2' && num[i] != '3' && num[i] != '4' &&
                    num[i] != '5' && num[i] != '6' && num[i] != '7' && num[i] != '8' && num[i] != '9')
                {
                    result = false;
                }
            }

            return result;
        }
       
        //7. BUSCA TREN

        static int buscaTREN(Tren[] all, int numm, string nom)
        {
            int existe = -1;

            for (int i = 0; i < numm; i++)
            {
                if(all[i].nombre == nom)
                {
                    existe = i;
                    i = numm;
                }
            }

            return existe;
        }

    }
}
