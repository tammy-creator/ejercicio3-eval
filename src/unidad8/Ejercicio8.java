package unidad8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ejercicio8 {
	private static Map<String,Integer> jugadores = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		do {
			
		}while(!ejecutar(teclado.nextLine()));
		
		for (Entry<String, Integer> entry : jugadores.entrySet()) {
		    System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
	public static boolean ejecutar(String linea) {
		if(linea.equals("fin")) {
			return true;
		}
		String[] partes = linea.split(":");
		String nombre = partes[0];
		String[] cartas = partes[1].trim().split(" ");
		
		List<Naipe> naipes = new ArrayList<>();
		for(String c:cartas) {
			String rango;
			String palo;
			if(c.length()>2) {
				rango = c.substring(0, 2);
				palo = c.substring(2);
			}
			else {
				rango = c.substring(0,1);
				palo = c.substring(1);
			}
			
			Naipe n = new Naipe(rango,palo);
			naipes.add(n);
		}
		int puntos = 0;
		int puntosJugador;
		Iterator<Naipe> i = naipes.iterator();
		while(i.hasNext()) {
			puntos+=i.next().getPuntuacion();
		}
		
		if(jugadores.containsKey(nombre)) {
			puntosJugador = jugadores.get(nombre);
			puntosJugador += puntos;
		}else {
			puntosJugador = puntos;
		}
		jugadores.put(nombre, puntosJugador);
					
		return false;
		
	}
}
