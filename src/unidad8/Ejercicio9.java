package unidad8;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio9 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		ejecutar(leerRobots(teclado),leerHora(teclado),leerProductos(teclado));
	}
	static Queue<Robot> leerRobots(Scanner teclado) {
		Queue<Robot> robots = new LinkedList<>();
		String[] linea = teclado.nextLine().split(";");
		for(String l:linea) {
			String[] r = l.split("-");
			robots.add(new Robot(r[0],Integer.parseInt(r[1])));
		}
		return robots;
	}
	static LocalTime leerHora(Scanner teclado) {
		return LocalTime.parse(teclado.nextLine());
		
	}
	static Queue<String> leerProductos(Scanner teclado) {
		String linea = teclado.nextLine();
		Queue<String> productos = new LinkedList<>();
		while(!linea.equals("fin")) {
			productos.add(linea);
			linea = teclado.nextLine();
		}
		return productos;
	}
	static void ejecutar(Queue<Robot> robots, LocalTime hora, Queue<String> productos) {
		List<Robot> activos = new ArrayList<>();
		while(!productos.isEmpty()) {
			hora=hora.plusSeconds(1);
			String producto=productos.poll();
			if(robots.isEmpty()) {
				productos.offer(producto);
			}else {
				Robot robot = robots.poll();
				robot.asignar(hora, producto);
				activos.add(robot);
			}
			if(robots.size()>3) {
				System.out.println("Más de 3 robots");
			}
			Iterator<Robot> i = activos.iterator();
			while(i.hasNext()) {
				Robot r = i.next();
				if(r.procesar()) {
					i.remove();
					robots.offer(r);
				}
				
				
				
			}
			
			
		}
	}
	
}
