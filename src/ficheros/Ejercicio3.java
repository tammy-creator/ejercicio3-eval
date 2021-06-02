package ficheros;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String archivo;
		if(args.length<2) {
			System.out.println("Ruta: ");
			Scanner s = new Scanner(System.in);
			archivo = s.nextLine();
			
		}else {
			archivo = args[1];
		}
		
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		
		int contCaracteres = 0;
		int contPalabras = 0;
		int contLineas = 0;
		String line;
		while ((line = br.readLine()) != null) {
			contLineas++;
			for (String palabra : line.split("\\P{L}+")) {
				contPalabras++;
				contCaracteres += palabra.length();
			}
		}
		System.out.println("Número de caracteres: " + contCaracteres+ "\n");
		System.out.println("Número de palabras: " + contPalabras + "\n");
		System.out.println("Número de líneas: " + contLineas + "\n");
	}

}
