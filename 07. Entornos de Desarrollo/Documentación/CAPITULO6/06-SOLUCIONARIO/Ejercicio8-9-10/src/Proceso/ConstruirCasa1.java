package Proceso;

import Datos.*;

public class ConstruirCasa1 {
	public static void main(String[] args) {
		Casa casa = new Casa(1);

		Habitacion h = new Habitacion(15);
		Puerta p = new Puerta(2.10, 1); // alto 2.10, ancho 1
		h.setPuerta(p);
		Ventana v = new Ventana(1.60, 1.20);// //alto 1.60 ancho 1,20
		h.setVentana(v);

		casa.addHabitacion(h);

		Habitacion hab[] = casa.getHabitaciones();
		System.out.println("Número de Habitaciones:" + hab.length);

	}
}
