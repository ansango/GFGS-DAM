static void Main(string[] args)
        {
            String[] palabras = new String[] { "hola", "casa", "maria", "bosque", "arbol", "partia", "partiagggg", "pre", "orc", "raton" };
            String letrasPosibles = "abcdefghijklmnopqrstuvwxyz";
            int[] contadorLetras = new int[letrasPosibles.Length]; //este array lo uso para contar letras, opcion avanzada.

            //este array lo uso para que en caso de acertar siempre, salgan todas las palabras del array palabras.
            //y que en cada ejecución del programa, salgan en un orden distinto.
            int[] orden=new int[palabras.Length];
            int palabrasDichas=0, ganadas=0, perdidasRepetir=0, perdidasNoEmpezar=0, partidas=0 ;
            char volverAJugar='s';
            
            //decido el orden en que saldran las palabras. Cada partida saldra una palabra.
            prepararOrdenPartidas(orden);
            Console.WriteLine("Bienvenidos a las palbras encadenadas!");
            do
            {
                Console.WriteLine("Partida " + (partidas + 1));
                //llamo a jugar pasandole la palabra actual, los contadores, y el array para contar letras (ampliacion)
                jugar(palabras[orden[partidas]], ref palabrasDichas, ref ganadas, ref perdidasNoEmpezar, ref perdidasRepetir, letrasPosibles, contadorLetras);
                partidas++;
                volverAJugar = masPartidas();
               
            } while (volverAJugar == 's' && partidas<palabras.Length);
            //añado a la condicion que el numero de partidas sea menor que el numero de palabras.
            estadisticas(partidas, palabrasDichas, ganadas, perdidasNoEmpezar, perdidasRepetir, letrasPosibles, contadorLetras);
            Console.WriteLine("Pulsa intro para finalizar");
            Console.ReadLine();
        
        }
        //funcion principal del juego. Recibe la primera palabra, y la cantidad de palabras dichas, ganadas, perdidas...
        //estos contadores los paso por referencia para poderlos actualizar
        static void jugar(String palabraAnterior, ref int palDichas, ref int partidasGanadas, ref int partidasPerdidasNoEmpezar, ref int partidasPerdidasRepetir, string letras, int[] contLetras)
        { 
            //empieza la partida y repito el proceso:
            //cantidad de palabras que he encadenado
            int encadenadas=1;
            //la variable fallo sirve para saber si he fallado
            bool fallo = false;
            String palabra, ultimaSilaba;
            String []listaPalabrasDichas=new String[21];
            listaPalabrasDichas[0] = palabraAnterior;
            //paso a minusculas la anterior para evitar problemas
            palabraAnterior = palabraAnterior.ToLower();
            //muestro palabra Inicial
            Console.WriteLine("Palabra inicial: "+palabraAnterior);
            do
            {
                //busco ultima silaba de la anterior
                buscarSilaba(palabraAnterior, out ultimaSilaba);
                //pido la palabra actual
                Console.WriteLine("ESTA LINEA NO DEBE SALIR: ULTIMA SILABA: (" + ultimaSilaba+")");
                Console.Write("Jugador, introduce palabra "+encadenadas+": ");
                palabra=Console.ReadLine();
                palabra = palabra.ToLower(); //la paso a minusculas para evitar problemas
                contarLetras(letras, contLetras, palabra);
                
                //miro si esta repetida
                //si la longitud de la palbra no es mayor que la ultima silaba...
                if (estaDicha(listaPalabrasDichas, palabra, encadenadas))
                {
                    Console.WriteLine("Error! La palabra está dicha!");
                    Console.WriteLine("Has llegado a la ronda " + encadenadas);
                    fallo=true;
                    partidasPerdidasRepetir++;
                }
                //miro si no empieza igual o la palabra dicha es mas corta que la silaba
                else if (empiezaPor(palabra, ultimaSilaba) || palabra.Length<ultimaSilaba.Length)
                {
                    Console.WriteLine("Error! La palabra no empieza por las letras correspondientes!");
                    Console.WriteLine("Has llegado a la ronda " + encadenadas );
                    fallo = true;
                    partidasPerdidasNoEmpezar++;
                }
                else
                {
                    //la ultima palabra, pasa a ser la palabraActual, y guardo la palabra en la lista de dichas
                    Console.WriteLine("Correcto!");
                    palabraAnterior = palabra;
                    listaPalabrasDichas[encadenadas] = palabra;
                }
                encadenadas++;
            } while (encadenadas <= 20 && fallo == false);
            //actualizo contador de palabras Dichas en total
            palDichas = palDichas + encadenadas-1;
            //si no hay fallo, he ganado.
            if (fallo == false) { partidasGanadas++;
                Console.WriteLine("Felicidades! Has llegado a la ronda 20!");
            }
        
        }
        //funcion para contar letras
        static void contarLetras(String alfabeto, int[] contador, String palabra)
        { 
            for (int i = 0; i < alfabeto.Length; i++)
            {
                //el bucle anterior recorre el alfabeto. empieza por a, luego b, luego c...
                for (int j = 0; j < palabra.Length; j++)
                {
                    //este bucle recorre la palabra
                    //si encuentro la letra, la cuento.
                    if (alfabeto[i] == palabra[j]) { contador[i]++; }
                }
            }
            //se podia hacer con el codigo ascii de la letra, y sin el "alfabeto" pero lo hago recorriendo los string palabra y alfabeto al completo.
            /*
              for (int j = 0; j < palabra.Length; j++)
                {
                    //este bucle recorre la palabra
                    //si encuentro la letra, la cuento.
                    int codigoAsciiLetra=alfabeto[j]-'a';
                    contador[codigoAsciiLetra]++;
                }
             
             */
            
        }
        //funcion para buscar la silaba
        static void buscarSilaba(String pal, out String silaba)
        { 
            //busco silaba
            /* En la version "basica", podiamos usar cualquiera de estas dos lineas. La primera hace una subCadena, 
             * desde la posicion "longitud-2", y de 2 caracteres:
             * La otra, concatena un string vacio ("") con el caracter en la posicion "longitud-2", con el caracter en la posicion "longitud-1"
            silaba = pal.Substring(pal.Length-2,2);
            silaba = ""+pal[pal.Length - 2] + pal[pal.Length - 1];
             */
            //version ampliada: busco la ultima vocal.
            int posicionUltimaVocal = -1;
            for (int i = pal.Length - 1; i >= 0 && posicionUltimaVocal == -1; i--)
            {
                if (pal[i] == 'a' || pal[i] == 'e' || pal[i] == 'i' || pal[i] == 'o' || pal[i] == 'u')
                {
                    //si en la posicion i hay una vocal, guardo la posicion, y salgo del bucle. Por eso lo hago al reves, en cuanto encuentro
                    //una vocal, guardo su posicion y salgo.
                    posicionUltimaVocal = i;
                }
            }
            //como nos aseguran que hay una vocal, no hace falta controlar ese caso. Para buscar la ultima silaba, puede pasar que:
            //1.-La vocal sea el primer caracter. 2.-La vocal no sea el primer caracter. En este segundo caso, a la vez, pueden pasar dos cosas
            //2a) que la anterior a la vocal, sea una vocal, o que la anterior a la vocal sea una consonante
            if (posicionUltimaVocal == 0)
            {
                //caso 1. la silaba es toda la palabra
                silaba = pal;
            }
            else if (pal[posicionUltimaVocal - 1] == 'a' || pal[posicionUltimaVocal - 1] == 'e' || pal[posicionUltimaVocal - 1] == 'i' ||
                pal[posicionUltimaVocal - 1] == 'o' || pal[posicionUltimaVocal - 1] == 'u')
            {
                //caso 2a. La letra antes de la ultima vocal es una vocal, por lo que la ultima silaba va desde la vocal hasta el final..
                //calculo el tamaño de la silaba:
                int tamano = pal.Length - posicionUltimaVocal;
                silaba = pal.Substring(posicionUltimaVocal, tamano);
            }
            else
            {
                //caso 2b. La letra antes de la ultima vocal es una consonante, por lo que la ultima silaba va desde la consonante hasta el final..
                //calculo el tamaño de la silaba:
                int tamano = pal.Length - posicionUltimaVocal+1;
                silaba = pal.Substring(posicionUltimaVocal-1, tamano);
            }
           // Console.WriteLine("Ultima Silaba!:" + silaba);
        }
        //funcion para comprobar que una palabra esté dicha
        static bool estaDicha(String[] lista, String palabra, int cantidad)
        {
            //recorro el array lista, desde la posicion 0 hasta cantidad, para ver si esta dicha la palabra.
            bool dicha = false;
            for (int i = 0; i < cantidad; i++)
            {
                if (lista[i] == palabra) dicha = true;
            }
            return dicha;
        }
        static bool empiezaPor(String palabra, String silaba)
        {
            if (palabra.StartsWith(silaba)) return false;
            else return true;

            //se podria hacer de otro modo. Con un bucle recorriendo "silaba" y mirando si coinciden las letras con "palabra"
            /*
             bool errorEmpieza=false;
             for(int i=0;i<silaba.length;i++)
             {
                if(silaba[i]!=palabra[i]) errorEmpieza=true;
              
             }
              return errorEmpieza
             */
        }
        static void prepararOrdenPartidas(int []ordenPartidas)
        {
            //rellenare los numeros para tantas palabras como haya (recordad que el array ordenPartidas tiene el mismo tamaño que el de palabras)
            for (int i = 0; i < ordenPartidas.Length; i++)
            { ordenPartidas[i] = i; }

            //ahora hare un proceso que repetiré tantas veces como palabras haya:
            //el proceso sera: genero dos aleatorios entre 0 y el tamaño del array, e intercambio sus posiciones.
            Random r = new Random();
            int  aux, pos1, pos2;
            for (int i = 0; i < ordenPartidas.Length; i++)
            {
                pos1 = r.Next(0, ordenPartidas.Length);
                pos2 = r.Next(0, ordenPartidas.Length);
                //intercambio pos1 y pos2
                aux=ordenPartidas[pos1];
                ordenPartidas[pos1] = ordenPartidas[pos2];
                ordenPartidas[pos2] = aux;
            }
            //de éste modo queda el array desordenado.

        }
        //funcion para preguntar si quiero mas partidas. Devuelve un caracter 's' o 'n'
        static char masPartidas()
        {
            char otraPartida = 's';
            do
            {
                Console.WriteLine("Desea volver a jugar? S/N");
                //aqui leo una linea de teclado (.ReadLine()). La paso a minusculas .ToLower. Y cojo el caracter de la poscion 0.
                otraPartida = Console.ReadLine().ToLower()[0];
                //podriamos hacerlo en 3 pasos:
                //String linea=Console.ReadLine();
                //linea=linea.ToLower();
                //otraPartida=linea[0];
            } while (otraPartida != 's' && otraPartida != 'n');

            return otraPartida;
        }
        //funcion para mostrar las estadisticas
        static void estadisticas(int partidasHechas, int totalPalabrasDichas, int partidasGanadas, int partidasPerdidasNoEmpezar, int partidasPerdidasRepetir, string alfabeto, int[] contadorLetras)
        {
            Console.WriteLine("Numero de partidas jugadas: " + partidasHechas);
            Console.WriteLine("Numero de palabras dichas: " + totalPalabrasDichas);
            Console.WriteLine("Numero de partidas ganadas: " + partidasGanadas);
            Console.WriteLine("Numero de partidas perdidas por no empezar correctamente: " + partidasPerdidasNoEmpezar);
            Console.WriteLine("Numero de partidas perdidas por decir palabras repetidas: " + partidasPerdidasRepetir);

            Console.WriteLine("Letras dichas:");
            for (int i = 0; i < alfabeto.Length; i++)
            {
                Console.Write(alfabeto[i] + "-->" + contadorLetras[i] + "\t\t");
            }
            Console.WriteLine();
        }