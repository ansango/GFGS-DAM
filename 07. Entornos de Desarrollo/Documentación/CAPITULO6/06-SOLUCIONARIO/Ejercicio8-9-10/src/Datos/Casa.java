package Datos;

public class Casa {
	int numhabit;
	Habitacion [] habitaciones;
	int n;
	
	public Casa(int numhabit) {	
		this.numhabit=numhabit;
		habitaciones = new Habitacion[numhabit];		
		n=0;
	}

	public void addHabitacion(Habitacion h){		
		habitaciones[n] = h;
		n++;
	}

	public Habitacion[] getHabitaciones() {
		return habitaciones;
	}	
}
