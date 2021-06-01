package unidad8.colecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File(System.getProperty("user.home") + "/Documentos/robots1.txt"));
		procesar(leerRobots2(in), leerHora(in), leerProductos(in));
	}
	
	static Robot crearRobot(String robot) {
		String [] aux = robot.split("-");
		return new Robot(aux[0], Integer.parseInt(aux[1]));
	}
	
	static Queue<Robot> leerRobots(Scanner in) {
		Queue<Robot> robots = new LinkedList<>();
		String linea = in.nextLine();
		for (String robot: linea.split(";")) 
			robots.offer(crearRobot(robot));
		return robots;
	}
	
	static Queue<Robot> leerRobots2(Scanner in) {
		return Arrays.stream(in.nextLine().split(";")).map(Ejercicio9::crearRobot).collect(LinkedList<Robot>::new, (a, b) -> a.offer(b), (a, b) -> {});
	}
	
	static LocalTime leerHora(Scanner in) {
		return LocalTime.parse(in.nextLine());
	}
	
	static Queue<String> leerProductos(Scanner in) {
		Queue<String> productos = new LinkedList<>();
		String linea = in.nextLine();
		while (!linea.equalsIgnoreCase("fin")) {
			productos.offer(linea);
			linea = in.nextLine();
		}
		return productos;
	}
	
	static void procesar(Queue<Robot> robots, LocalTime hora, Queue<String> productos) {
		List<Robot> activos = new ArrayList<>();
		while (!productos.isEmpty()) {
			hora = hora.plusSeconds(1);
			String producto = productos.poll();
			if (robots.isEmpty())
				productos.offer(producto);
			else {
				Robot robot = robots.poll();
				robot.asignar(producto, hora.toString());
				activos.add(robot);
			}
			Iterator<Robot> i = activos.iterator();
			while (i.hasNext()) {
				Robot robot = i.next();
				if (robot.procesar()) {
					i.remove();
					robots.offer(robot);
				}
			}
		}
	}

	/*
ROB-15;SS2-10;NX8000-3
08:00:00
disco duro
procesador
memoria RAM
placa base
fin

	 */
	
}
