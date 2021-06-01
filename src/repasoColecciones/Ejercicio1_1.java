package repasoColecciones;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner (System.in);
		Collection<String> lista = new LinkedHashSet<>();
		int n = s.nextInt();
		for(int i=0; i<n; i++) {
			String nombre = s.next();
			if(!lista.contains(nombre)) {
				lista.add(nombre);
			}
		}
		System.out.println(lista);
		s.close();
	}

}
