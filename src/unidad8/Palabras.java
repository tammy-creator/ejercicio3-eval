package unidad8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras {
	private Map<Integer, Set<String>> mapa;

	public Palabras() {
		this.mapa= new TreeMap<>();
	}
	
	public Palabras(String txt) {
		this(); 
		addPalabras(txt);
	}
	
	public void add(String palabra) {
		int longitud = palabra.length();
		Set<String> palabras = mapa.get(longitud);
		if(palabras == null) {
			mapa.put(longitud, palabras = new TreeSet<>());
		}
		palabras.add(palabra);	
	}
	public void addPalabras(String texto) {
		for(String palabra: texto.split("\\P{L}+"))
			add(palabra);
	}	
	
	public boolean repetidas(String palabra) {
		if(mapa.containsValue(palabra)) {
			return true;
		}
		return false;
	}
	
	public void eliminarTodas() {
		mapa.clear();
	}
	public Set<String> get(int longitud) {
		return Collections.unmodifiableSet(mapa.get(longitud));
	}
	
}
