package ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio4 {
	final static String archivoBin ="ejercicio4.bin";
	final static String archivoTxt="ejercicio4.txt";
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
		/*System.out.println("Número de caracteres: " + contCaracteres+ "\n");
		System.out.println("Número de palabras: " + contPalabras + "\n");
		System.out.println("Número de líneas: " + contLineas + "\n");*/
		
		guardarBinario(archivo,contCaracteres,contPalabras,contLineas);
		leerFicheroBinario(archivoBin);
		guardarTxt(archivoTxt,contCaracteres,contPalabras,contLineas);
	}
	
	
	static void leerFicheroBinario(String archivo) {
		try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)))) {
				
			try {
				while (true) {
					System.out.println("PROCESANDO DATOS DE NUEVO FICHERO");
					System.out.println("Nombre fichero: " + in.readUTF());
					System.out.println("Número de caracteres: " + in.readInt()+ "\n");
					System.out.println("Número de palabras: " + in.readInt() + "\n");
					System.out.println("Número de líneas: " + in.readInt() + "\n");
				}				
			} 
			catch (EOFException e) {
				
			}		
		}
		catch (IOException e) {
			System.out.println("EL fichero es invalido "+e.getMessage());	
		}
	
	}
	static void guardarBinario(String nombreArchivo, int caracteres, int palabras, int lineas) {
	
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivoBin, true)))) {
				out.writeUTF(nombreArchivo);
				out.writeInt(caracteres);
				out.writeInt(palabras);
				out.writeInt(lineas);
		} catch (IOException e) {
			System.out.println("EL fichero es invalido "+e.getMessage());	
		}
		
	}
	static void guardarTxt (String nombreArchivo, int caracteres, int palabras, int lineas) throws IOException {
		FileWriter fileWriter = new FileWriter(archivoTxt);
	    PrintWriter printWriter = new PrintWriter(fileWriter);
	    printWriter.print("Nombre fichero: "+nombreArchivo + "\n");
	    printWriter.print("Número de caracteres: " +caracteres+ "\n");
	    printWriter.print("Número de palabras: " +palabras+ "\n");
	    printWriter.print("Número de líneas: " +lineas);
	    printWriter.close();
		
	}
		
}
