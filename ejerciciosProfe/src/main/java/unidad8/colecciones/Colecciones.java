package unidad8.colecciones;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Colecciones {

	public static void eliminarLasDeLongitudPar(Set<String> set) {
		
		/*
		 * Una forma de hacerlo
		 */
		
//		Iterator<String> i = s.iterator();
//		while(i.hasNext())
//			if(i.next().length() % 2 == 0)
//				i.remove();
		
		/* 
		 * Otra forma de hacerlo
		 */
		
//		Predicate<String> p = new Predicate<String>() {
//			@Override
//			public boolean test(String s) {
//				return s.length() % 2 == 0;
//			}
//		};
		
//		Predicate<String> p = (String s) -> { return s.length() % 2 == 0; };
		
//		Predicate<String> p = s -> s.length() % 2 == 0;
//		
//		set.removeIf(p);
				
		/*
		 * Lo mismo que la anterior, pero sin usar la variable
		 */
		
//		set.removeIf(new Predicate<String>() {
//			@Override
//			public boolean test(String s) {
//				return s.length() % 2 == 0;
//			}
//		});
		
//		set.removeIf((String s) -> { return s.length() % 2 == 0; });

		set.removeIf(s -> s.length() % 2 == 0);
	}
	
	public static boolean contieneImpares(Set<Integer> set) {
		
		/*
		 * Una forma de hacerlo
		 */
		
//		for (int n: set)
//		if (n % 2 == 1)
//			return true;
//		return false;
		
		/* 
		 * Otra forma de hacerlo
		 */
		
		return set.stream().anyMatch(n -> n % 2 == 1);
	}
	
	public static boolean valoresUnicos(Map<String, String> mapa) {
		
		/*
		 * Una forma de hacerlo
		 */
		
//		Collection<String> v1 = mapa.values();
//		HashSet<String> v2 = new HashSet<>(v1);
//		return v1.size() == v2.size();
		
		/* 
		 * Otra forma de hacerlo
		 */
		
		return mapa.values().stream().distinct().count() == mapa.values().size();
	}
	
	public static boolean seRepiteAlMenos3Veces(List<String> lista) {
		Map<String, Integer> mapa = new HashMap<>();
		for (String s: lista)
			if (mapa.containsKey(s))
				if (mapa.get(s) == 2)
					return true;
				else
					mapa.put(s, mapa.get(s) + 1);
			else
				mapa.put(s, 1);
		return false;
		
//		return lista.stream().collect(HashMap<String, Integer>::new, (a, b) -> a.put(b, a.containsKey(b) ? a.get(b) + 1 : 1), (a, b) -> {}).values().stream().anyMatch(value -> value >= 3);
	}
	
	public static void duplicar(Deque<Integer> pila) {
		Deque<Integer> aux = new LinkedList<>();
		while (!pila.isEmpty())
			aux.push(pila.pop());
		while (!aux.isEmpty()) {
			int n = aux.pop();
			pila.push(n);
			pila.push(n);
		}
	}
	
	/*
	 * Método llamado eliminarSiMayoresEncima que acepte una pila de números enteros como parámetro
	 * y elimine de ella los elementos que tienen por encima alguno cuyo valor sea mayor.Por ejemplo,
	 * suponiendoque una pila almacena los siguientes números:
	 * Tope →[2, 7, 12, 5, 14, 9, 7, 10, 17, 17, 22, 6]
	 * Los números 5, 9, 7, 10 y 6 deben eliminarse porque todos ellos tienen algún número mayor por encima.
	 * Sólo se permite el uso de otras pilas o colas para solucionar este problema.
	 */
	
	public static void eliminarSiMayoresEncima(Deque<Integer> pila) {
		Deque<Integer> aux = new LinkedList<>();
		
		// pila : Tope →[2, 7, 12, 5, 14, 9, 7, 10, 17, 17, 22, 6]
		while (!pila.isEmpty()) {
			int tope = pila.pop();
			aux.push(tope);
			while (!pila.isEmpty() && pila.peek() < tope)
				pila.pop();
		}
		
//		int max = Integer.MIN_VALUE;
//		while (!pila.isEmpty()) {
//			int n = pila.pop();
//			if (n >= max) {
//				max = n;
//				aux.push(n);
//			}	
//		}
		// aux : Tope →[6, 22, 17, 17, 10, 7, 9, 14, 5, 12, 7, 2]
		while (!aux.isEmpty()) 
			pila.push(aux.pop());
	}
	
	
	/*
	 * {Fernando=53, Manuela=29, Ana=41, Luis=65, Mario=33, Adrián=21, Carmen=39, Elena=19}
	 * {Valentina=37, Ana=41, Mario=33, Benito=67, Carmen=39, Ramón=44, Elena=19, Hugo=32}
	 * 
	 * {Ana=41, Mario=33, Carmen=39, Elena=19}
	 */
	
	public static Map<String, Integer> interseccion(Map<String, Integer> m1, Map<String, Integer> m2) {
		Map<String, Integer> mapa = new TreeMap<>();
		Set<Entry<String, Integer>> set = new HashSet<>(m1.entrySet());
		set.retainAll(m2.entrySet());
		set.forEach(e -> mapa.put(e.getKey(), e.getValue()));
//		for (Entry<String, Integer> e: m1.entrySet()) {
//			if (m2.entrySet().contains(e))
//				mapa.put(e.getKey(), e.getValue());
//		}
		return mapa;
	}
	
	public static void main(String[] args) {
		Map<String, Integer> mapa1 = new TreeMap<>();
		mapa1.put("Fenando", 53);
		mapa1.put("Manuela", 29);
		mapa1.put("Ana", 41);
		mapa1.put("Luis", 65);
		mapa1.put("Mario", 33);
		mapa1.put("Adrián", 21);
		mapa1.put("Carmen", 39);
		mapa1.put("Elena", 19);
		Map<String, Integer> mapa2= new TreeMap<>();
		mapa2.put("Valentina", 37);
		mapa2.put("Ana", 41);
		mapa2.put("Mario", 33);
		mapa2.put("Benito", 67);
		mapa2.put("Carmen", 39);
		mapa2.put("Ramón", 44);
		mapa2.put("Elena", 19);
		mapa2.put("Hugo", 32);
		System.out.println(interseccion(mapa1, mapa2));
	}
	
	
	
}
