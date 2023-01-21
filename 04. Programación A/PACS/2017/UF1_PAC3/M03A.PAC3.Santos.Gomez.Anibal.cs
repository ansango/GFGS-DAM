using System;

namespace UF1
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			int numdias, mejillon, i, totalmejillonesdia, totalconchasdia, justo, timo, suerte;

			Console.WriteLine("Dame días");

			numdias = int.Parse(Console.ReadLine());

			justo = 0;
			timo = 0;
			suerte = 0;

			for (i = 0; i < numdias; i++ ) // bucle numero de dias
			{
				int fin = 0;
				totalconchasdia = 0;
				totalmejillonesdia = 0;
				do {
						Console.WriteLine("Dame numero de mejillones"); //utilizamos -1 para acabar el dia
						mejillon = int.Parse(Console.ReadLine());

						if( mejillon == -1 )
							{
								fin = 1;
							}
						else 
							{
								totalconchasdia = totalconchasdia + 1;

								if( mejillon >= 0 ) 
								{
									totalmejillonesdia = totalmejillonesdia + mejillon;
								}
							}

					} while( fin == 0 );

				if (totalmejillonesdia == totalconchasdia) // actualizamos contadores de resultados diarios justo timo y suerte
				{
					Console.WriteLine("JUSTO");
					justo = justo + 1;

				}
				else if (totalmejillonesdia < totalconchasdia)
				{
					Console.WriteLine("TIMO");
					timo = timo + 1;
				}
				else 
				{
					Console.WriteLine("SUERTE");
					suerte = suerte + 1;
				}
					
			}

			Console.WriteLine("JUSTO - - >" + justo);
			Console.WriteLine("TIMO - - >" + timo);
			Console.WriteLine("SUERTE - - >" + suerte);


		}
	}
}
