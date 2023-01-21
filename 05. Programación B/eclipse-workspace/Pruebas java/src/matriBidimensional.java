
public class matriBidimensional {

	public static void main(String[] args) {
		
		int [][] mimatrix = new int [4][5];
		
		mimatrix[0][0]=23;
		mimatrix[0][1]=45;
		mimatrix[0][2]=67;
		mimatrix[0][3]=89;
		mimatrix[0][4]=7;
		
		mimatrix[1][0]=12;
		mimatrix[1][1]=32;
		mimatrix[1][2]=43;
		mimatrix[1][3]=54;
		mimatrix[1][4]=13;
		
		mimatrix[2][0]=41;
		mimatrix[2][1]=42;
		mimatrix[2][2]=43;
		mimatrix[2][3]=56;
		mimatrix[2][4]=69;
		
		mimatrix[3][0]=14;
		mimatrix[3][1]=51;
		mimatrix[3][2]=54;
		mimatrix[3][3]=79;
		mimatrix[3][4]=8;
	
		//System.out.println("valor almacenado en la posicion 2 y 3" + mimatrix[2][3]);
		
		for(int i=0;i<4;i++) 
		{System.out.println();
		
			for(int j=0;j<5;j++) 
			{
				System.out.print(mimatrix[i][j] + " ");
			}
		}

	}

}
