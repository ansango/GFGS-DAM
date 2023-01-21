public class FechaMain {

	public static void main(String[] args) {// TODO Auto-generated method stub
     Fecha fec = new Fecha();
     System.out.println(fec.DevuelveFecha(1));
     System.out.println(fec.DevuelveFecha(2));
     System.out.println(fec.DevuelveFecha(3));
     System.out.println(fec.DevuelveFecha(4));	 
     
     if (fec.DevuelveFecha(1).equals("2014/03"))
         System.out.println("igual");    
	}
}
