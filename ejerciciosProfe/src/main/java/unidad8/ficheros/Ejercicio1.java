package unidad8.ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		File file;
		if (args.length == 0) {
			Scanner s = new Scanner(System.in);
			System.out.print("Ruta: ");
			file = new File(s.nextLine());
		}
		else
			file = new File(args[0]);
		if (file.exists()) {
			System.out.println("Nombre: " + file.getName());
			System.out.print("Tipo: ");
			if (file.isFile())
				System.out.println("fichero\nLongitud: " + file.length() + " bytes");
			else
				System.out.println("directorio\nContiene " + file.list().length + " elementos");
			System.out.println("Permisos: " + (file.canWrite() ? "escritura " : "") + (file.canRead() ? "lectura " : "") + (file.canExecute() ? "ejecución" : ""));
		}
		else
			System.out.println("El fichero o directorio no existe");

	}

}
