package unidad8.colecciones;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Collection<String> lista = new LinkedHashSet<>();
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			String nombre = in.next();
//			if (!lista.contains(nombre))
				lista.add(nombre);
		}
		System.out.println(lista);
		in.close();
	}

}
