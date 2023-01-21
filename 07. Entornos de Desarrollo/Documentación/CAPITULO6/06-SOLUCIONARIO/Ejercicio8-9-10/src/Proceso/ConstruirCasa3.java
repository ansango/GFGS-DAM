package Proceso;

import Datos.*;

public class ConstruirCasa3 {

	public static void main(String[] args) {
		// Crear una casa con 4 habitaciones
		Casa casa = new Casa(4);
		boolean conventana = true;

		for (int i = 0; i < 4; i++) {
			Habitacion h = new Habitacion(15);
			Puerta p = new Puerta(2.10, 1); // alto 2.10, ancho 1
			h.setPuerta(p);

			if (conventana) {
				Ventana v = new Ventana(1.60, 1.20);// //alto 1.60 ancho 1,20
				h.setVentana(v);
			}
			casa.addHabitacion(h);
		}

		Habitacion hab[] = casa.getHabitaciones();		
		System.out.println("Número de habitaciones:" + hab.length);
	}
}
