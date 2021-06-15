package repasoColecciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

public class Frecuencia {
	Map<String, Integer> palabras = new TreeMap<>();
	
	public Frecuencia(File file, Charset charset) throws IOException {
		try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset))){
			String linea;
			while((linea = in.readLine())!= null) {
				for(String palabra: linea.toLowerCase().split("\\P{L}+")) {
					int frecuencia = palabras.containsKey(palabra) ? palabras.get(palabra) + 1 : 1;
					palabras.put(palabra, frecuencia);
				}
			}
		}
	}
	
	public int getFrecuencia(String palabra) {
		Integer frecuencia = palabras.get(palabra);
		return frecuencia == null ? 0 : frecuencia;
	}
	
}
