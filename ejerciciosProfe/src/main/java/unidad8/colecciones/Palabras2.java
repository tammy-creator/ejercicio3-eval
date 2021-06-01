package unidad8.colecciones;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras2 extends TreeMap<Integer, Set<String>> {

	private static final long serialVersionUID = 1L;

	public Palabras2() {
		super();
	}

	public Palabras2(String texto) {
		addPalabras(texto);
	}

	private void add(String palabra) {
		int longitud = palabra.length();
		Set<String> palabras = get(longitud);
		if (palabras == null)
			put(longitud, palabras = new TreeSet<String>());
		palabras.add(palabra);
	}

//	public void addPalabras(String texto) {
//		Scanner s = new Scanner(texto.toLowerCase());
//		s.useDelimiter("\\P{L}+");
//		while (s.hasNext())
//			add(s.next());
//		s.close();
//	}

	public void addPalabras(String texto) {
		for (String palabra : texto.replaceFirst("^\\P{L}+", "").toLowerCase().split("\\P{L}+"))
			add(palabra);
	}

	public boolean contiene(String palabra) {
		try {
			return get(palabra.length()).contains(palabra.toLowerCase());
		} catch (NullPointerException e) {
			return false;
		}
	}

}
