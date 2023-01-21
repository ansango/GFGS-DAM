using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcion = -1;
            int[,] sudoku = new int[9, 9];
            int numero;
            bool correcto = true; //supongo q el sudoku es correcto de salida
            int[] contador = new int[10];   //array para contar numeros de cada fila , y para contar teminaciones.
            int[] limiteInf = new int[] { 0, 3, 6 }; //ARRAY PARA CONTROLAR REGIONES (explicado mas adelante)
            int[] limiteSup = new int[] { 3, 6, 9 }; //ARRAY PARA CONTROLAR REGIONES (explicado mas adelante)
            int desdeFila, hastaFila, desdeCol, hastaCol; //variables usadas en el sudoku para regiones, con los dos arrays.
            int numSorteos, numeroPremiado, terminacion, posicionMaximo, repeticionMaximos;
            do
            {
                Console.WriteLine("Escoge opcion: 1.-Sorteo\t2.-Sudoku\t3.-Salir");
                opcion = int.Parse(Console.ReadLine());
                ///PRIMER EJERCICIO!!!
                if (opcion == 1)
                {
                    //la estrategia no es guardar todos los sorteos en un array, sino usar un array
                    //para contar CUANTOS NUMEROS TERMINAN EN 0, EN 1, EN 2....
                    //por tanto necesito un array de 10 posiciones.

                    //pongo el array de contadores a 0, para las terminaciones 
                    //La posicion 0, significa la terminación 0. La posicion 1, significa la terminacion 1
                    //Y esto lo usaré para contar cuantos numeros de cada terminacion hay
                    for (int i = 0; i < 10; i++) { contador[i] = 0; }
                    //pido sorteos,
                    Console.WriteLine("Cuantos Sorteos?");
                    numSorteos = int.Parse(Console.ReadLine());
                    //pido sorteos
                    for (int i = 1; i <=numSorteos; i++)
                    {
                        //leo el numero
                        Console.WriteLine("Sorteo numero " + i + ":");
                        numeroPremiado = int.Parse(Console.ReadLine());
                        //calculo la terminacion dividiendo entre 10 y quedandome con el resto
                        terminacion = numeroPremiado % 10; 
                        //sumo 1 a la posicion terminacion del array contador, para que cuente que hay otro numero
                        //que termina con ese digito
                        contador[terminacion]++;
                    }

                    //Una vez hecho esto, voy a buscar el maximo, y cuantos maximos hay. Se podia hacer en 2 bucles
                    //primero buscar el maximo, y luego buscar cuantas veces sale el maximo.
                    //yo os lo pongo todo en uno. Empezamos suponiendo que el maximo esta en la posicion 0, y que no hay repeticiones
                    posicionMaximo = 0;
                    repeticionMaximos = 0;
                    //recorro el array de terminaciones, desde la posicion 1 (ya que la 0 ya la tengo, es donde supongo que está el maximo)
                    for (int i = 1; i < 10; i++)
                    {
                        if (contador[i] == contador[posicionMaximo])
                        { 
                            //si se repite el maximo, aumento el contador de maximo repetido
                            repeticionMaximos++;
                        }
                        else if (contador[i] > contador[posicionMaximo])
                        {
                            //he econtrado un nuevo maximo en la posicion I. Por tanto, actualizo
                            //la posicionMaximo, y el numero de repeticiones pasa a ser 0
                            posicionMaximo = i;
                            repeticionMaximos=0;
                        }
                    
                    }
                    //Una vez hecho esto, si repeticionMaximos es 0, el numero que mas veces se repite es I
                    if (repeticionMaximos == 0) Console.WriteLine("La terminacion mas premiada es " + posicionMaximo);
                    else Console.WriteLine("Hay VARIAS terminaciones que se repetien");
                
                }
                ///SEGUNDO EJERCICIO!!!
                else if (opcion == 2)
                {
                    //leo el sudoku
                    for (int i = 0; i < 9; i++)
                    {
                        Console.WriteLine("Vamos a entrar fila " + i + 1);
                        for (int j = 0; j < 9; j++)
                        {
                            Console.WriteLine("Entra columna " + j + 1);
                            sudoku[i, j] = int.Parse(Console.ReadLine());
                        }
                    }

                    correcto = true; //supongo q el sudoku es correcto de salida
                    //pongo el array de contadores a 0
                    for (int i = 0; i < 10; i++) { contador[i] = 0; }
                    //compruebo por filas primero. Si en algun momento correcto es falso, 
                    //la condicion será falsa y no hace falta comprobar mas.
                    for (int i = 0; i < 9 && correcto == true; i++)
                    {
                        //para cada fila hago
                        //cojo el numero de la celda, y aumento en uno el array contador en esa posicion
                        //asi puedo contar cuantos 1s, 2s, 3s.. hay en esa fila
                        for (int j = 0; j < 9; j++)
                        {
                            numero = sudoku[i, j]; //miro el numero que hay
                            contador[numero]++; //incremento en uno el array contador, en la posicion numero
                        }
                        //recorro el array contador, y si de algun numero hay 0, es que no se ha llenado ese numero, 
                        //desde la posicion 1 hasta la 9 incluida, ya que son los numeros del sudoku
                        for (int j = 1; j < 10; j++)
                        {
                            //si alguno vale 0, correcto valdrá false.
                            if (contador[j] == 0) correcto = false;
                        }
                        //reinicio a 0 el array contador
                        for (int j = 1; j < 10; j++)
                        {
                            contador[j] = 0;
                        }
                    }

                    //hago lo mismo con las columnas.
                    //no pongo comentarios porque son los mismos que los de la fila.
                    for (int i = 0; i < 9 && correcto == true; i++)
                    {
                        for (int j = 0; j < 9; j++)
                        {
                            numero = sudoku[j, i]; //aquí está la diferencia, que giro filas y columnas.
                            contador[numero]++;
                        }
                        for (int j = 1; j < 10; j++)
                        {
                            if (contador[j] == 0) correcto = false;
                        }
                        for (int j = 1; j < 10; j++)
                        {
                            contador[j] = 0;
                        }
                    }
                    //recorro regiones. Podria poner este codigo nueve veces, cambiando los "limites" de las regiones.
                    //region 0-3 hasta 3-3
                    /*for (int i = 0; i < 3 && correcto == true; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            numero = sudoku[i, j]; 
                            contador[numero]++;
                        }
                    }
                    //despues de recorrer la region, miro si estan todos, y reinicio array contador
                        for (int j = 1; j < 10; j++)
                        {
                            if (contador[j] == 0) correcto = false;
                        }
                        for (int j = 1; j < 10; j++)
                        {
                            contador[j] = 0;
                        }
                    }*/

                    //pero lo haremos haciendolo con dos arrays mas, para ir cambiando posiciones

                    //ahora las regiones. Para testear cada region, se podrian hacer 9 bucles. Yo lo hago de una manera 
                    //distinta, para que lo veáis de otra manera
                    //estos dos arrays me permitiran recorrer las regiones (ESTAN DECLARADOS AL PRINICPIO DEL PROGRAMA)
                   // int[] limiteInf = new int[] { 0, 3, 6 };
                   // int[] limiteSup = new int[] { 3, 6, 9 };

                    //me creare 4 bucles. 
                    //añado condicion "correcto==true", para no hacer vueltas innecesarias
                    for (int m = 0; m < 3 && correcto == true; m++)
                    {
                        for (int n = 0; n < 3 && correcto == true; n++)
                        {
                            //estos dos bucles los uso para los limites. 
                            desdeFila = limiteInf[m];
                            hastaFila = limiteSup[m];
                            desdeCol = limiteInf[n];
                            hastaCol = limiteSup[n];
                            //con estas 4 variables, consigo ir cambiando desde los limites de las regiones.
                            for (int i = desdeFila; i < hastaFila && correcto == true; i++)
                            {
                                for (int j = desdeCol; j < hastaCol; j++)
                                {
                                    numero = sudoku[i, j];
                                    contador[numero]++;
                                }
                            }
                            //una vez testeada la region, miro si hay algun numero a 0:
                            for (int j = 1; j < 10; j++)
                            {
                                if (contador[j] == 0) correcto = false;
                            }
                            //y reinicio el array de contadores
                            for (int j = 1; j < 10; j++)
                            {
                                contador[j] = 0;
                            }
                        }
                    }
                    //por ultimo, si es correcto digo que lo es, y sino digo que no
                    if (correcto) Console.WriteLine("EL SUDOKU ES CORRECTO");
                    else Console.WriteLine("EL SUDOKU NO ES CORRECTO");
                    

                }
                else if (opcion != 3)
                {
                    Console.WriteLine("Opcion incorrecta!");
                }

            } while (opcion != 3);
           

        }
    }
}
