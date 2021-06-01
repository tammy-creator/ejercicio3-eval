package unidad8.colecciones;

import java.util.Set;

public class PruebaPalabras {

	public static void main(String[] args) {
		Palabras p = new Palabras("esto es una prueba");
		Set<String> l = p.get(2);
		System.out.println(l);
		l.add("abc");
		System.out.println(p.get(2));
	}

}
