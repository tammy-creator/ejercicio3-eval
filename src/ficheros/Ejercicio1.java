package ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file;
		Scanner s = new Scanner(System.in);
		System.out.println("Ruta: ");
		file = new File (s.nextLine());	
			
		
		if(file.exists()) {
			System.out.println("Nombre: "+ file.getName());
			System.out.print("Tipo: ");
			if(file.isFile()) {
				System.out.println("fichero\nLongitud: "+ file.length() + " bytes");
			}else {
				System.out.println("directorio\nContiene "+ file.list().length+" elementos");
			}
			System.out.println("Permisos: " + (file.canWrite() ? "escritura " : "") + (file.canRead() ? "lectura " : "") + (file.canExecute() ? "ejecución" : ""));
		}else {
			System.out.println("El fichero o directorio no existe");
		}
	}

}
