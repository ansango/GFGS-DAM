
public class matrizbidimensionales2 {

	public static void main(String[] args) {
		
		int [][]matrix= {
					{10,15,18,19,21},
					{1,13,8,9,2},
					{7,51,81,91,32},
					{45,56,67,78,89},
			};
		
		/*for(int i=0;i<4;i++) 
		{System.out.println();
		
			for(int j=0;j<5;j++) 
			{
				System.out.print(matrix[i][j] + " ");
			}
		}*/
		
		for(int[]fila:matrix) 
		{ System.out.println();
			for(int z: fila)
			{
				System.out.print(z + " ");
			}
		}

	}

}
