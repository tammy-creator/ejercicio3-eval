package unidad8.ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio10v2 {

	static private Map<String, Set<String>> agenda = new TreeMap<>();	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		System.out.print("> ");
		linea = in.readLine();
		while (!linea.equalsIgnoreCase("salir")) {
			ejecutarComando(linea);
			System.out.print("> ");
			linea = in.readLine();
		}
	}
	
	static void ejecutarComando(String linea) {
		String [] cmd = linea.split(":");
		switch (cmd[0]) {
		case "buscar":
			System.out.println(agenda.get(cmd[1]));
			break;
		case "eliminar":
			agenda.remove(cmd[1]);
			break;
		case "contactos":
			Set<Entry<String, Set<String>>> contactos = agenda.entrySet();
			System.err.println(contactos);
			break;
		case "cargar":
			cargar(cmd[1]);
			break;
		case "guardar":
			guardar(cmd[1]);
			break;
		default:
			if (agenda.containsKey(cmd[0])) {
				agenda.get(cmd[0]).add(cmd[1]);
			}
			else {
				Set<String> telefonos = new HashSet<>();
				telefonos.add(cmd[1]);
				agenda.put(cmd[0], telefonos);
			}
		}
	}

	static void guardar(String ruta) {
		File fichero = new File(ruta);
		if (fichero.exists())
			cargar(ruta);
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)))) {
			out.writeObject(agenda);
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	static void cargar(String ruta) {
//		Map<String, Set<String>> agenda = new TreeMap<>();
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta)))) {
			agenda = (Map<String, Set<String>>) in.readObject();
			// mezclar la agenda leida con la agenda que está en memoria
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
}
