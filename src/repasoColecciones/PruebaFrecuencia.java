package repasoColecciones;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PruebaFrecuencia {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		Frecuencia quijote = new Frecuencia(new File("El Quijote ISO-8859-1.txt"), StandardCharsets.ISO_8859_1);
		String palabra;
		System.out.print("palabra (0 para salir) > ");
		while (!(palabra = s.nextLine()).equals("0")) {
			System.out.println("Frecuencia: " + quijote.getFrecuencia(palabra));
			System.out.print("palabra (0 para salir) > ");
		}
		s.close();
	}

}


