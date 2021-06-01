package unidad8.colecciones;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras {
	
	private Map<Integer, Set<String>> mapa;
	
	public Palabras() {
		mapa = new TreeMap<>();
	}
	
	public Palabras(String texto) {
		this();
		addPalabras(texto);
	}
	
	private void add(String palabra) {
		int longitud = palabra.length();
		Set<String> palabras = mapa.get(longitud);
		if (palabras == null)
			mapa.put(longitud, palabras = new TreeSet<>());
		palabras.add(palabra);
	}
	
	public void addPalabras(String texto) {
		Scanner s = new Scanner(texto);
		s.useDelimiter("\\P{L}+");
		while (s.hasNext())
			add(s.next());
		s.close();
	}
	
//	public void addPalabras(String texto) {
//		for(String palabra: texto.split("\\P{L}+"))
//			add(palabra);
//	}
	
	public boolean contiene(String palabra) {
		try {
			return mapa.get(palabra.length()).contains(palabra);
		} catch (NullPointerException e) {
			return false;
		}
	}
	
//	public String [] get(int longitud) {
//		String [] a = new String[mapa.get(longitud).size()];
//		mapa.get(longitud).toArray(a);
//		return a;
//	}
	
	public Set<String> get(int longitud) {
		return Collections.unmodifiableSet(mapa.get(longitud));
	}
	
	public void eliminarTodas() {
		mapa.clear();
	}
}
