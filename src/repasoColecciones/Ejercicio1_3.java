package repasoColecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio1_3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea = in.readLine();
		String  [] palabras = linea.split("\\P{L}+");
		Set<String> sinRepetir = new TreeSet<>();
		Set<String> repetidas = new TreeSet<>();
		for(String palabra: palabras)
			if (!sinRepetir.add(palabra))
				repetidas.add(palabra);
		sinRepetir.removeAll(repetidas);
		System.out.println("Palabras que no se repiten: " + sinRepetir);
		System.out.println("Palabras que si se repiten: " + repetidas);
	}

}
