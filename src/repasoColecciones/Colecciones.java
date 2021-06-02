package repasoColecciones;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Colecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Set<String> cadena = new HashSet<>();
		cadena.add("hola");
		cadena.add("arbol");
		cadena.add("fds");
		
		eliminarLasDeLongitudPar(cadena);
		System.out.println(cadena);
		
		Set<Integer> cadena1 = new HashSet<>();
		cadena1.add(2);
		cadena1.add(2);
		cadena1.add(1);
		
		System.out.println(contieneImpares(cadena1));
		
		Map<String, String>mapa = new HashMap<>();
		mapa.put("Maria", "Maria");
		mapa.put("Luis", "Juan");
		mapa.put("Juan", "Juan");
		
		System.out.println(valoresUnicos(mapa));
		
		List<String> cadena = new LinkedList<>();
		cadena.add("hola");
		cadena.add("arbol");
		cadena.add("arbol");
		cadena.add("arbol");
		cadena.add("sol");
		System.out.println(cadena);
		System.out.println(algunaSeRepiteAlMenos3Veces(cadena));
		*/
		Deque<Integer>pila = new LinkedList<>();
		pila.add(89);
		pila.add(-55);
		pila.add(-19);
		pila.add(29);
		pila.add(37);
		pila.add(-5);
		pila.add(23);
		System.out.println(negativosAbajoPositivosArriba(pila));
	}
	public static void eliminarLasDeLongitudPar(Set<String> set) {
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			if(it.next().length()%2 == 0) {
				it.remove();
			}
		}
	}
	
	public static boolean contieneImpares(Set<Integer> set) {
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			if(it.next()%2!=0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean valoresUnicos(Map<String,String> mapa) {
		Iterator<Entry<String, String>> it = mapa.entrySet().iterator();
		List<String> valores = new ArrayList<>();
		while(it.hasNext()) {
			Entry pair = it.next();
			valores.add((String) pair.getValue());
		}
		for(int i=0; i<valores.size(); i++) {
			for(int j=i+1; j<valores.size(); j++) {
				if(valores.get(i).contains(valores.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean algunaSeRepiteAlMenos3Veces(List<String> set) {
		Map<String, Integer> mapa = new HashMap<>();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String palabra = it.next();
			if(mapa.containsKey(palabra)) {
				if(mapa.get(palabra)==2) {
					return true;
				}
				mapa.put(palabra, mapa.get(palabra)+1);
			}else {
				mapa.put(palabra, 1);
			}
		}
		return false;		
	}
	public static Deque<Integer> negativosAbajoPositivosArriba(Deque<Integer> pila) {
		Queue<Integer> cola = new LinkedList<Integer>();
		while(!pila.isEmpty()) {
			cola.offer(pila.poll());
		}
		while(!cola.isEmpty()) {
			int aux=cola.poll();
			if(aux>0) {
				pila.offerFirst(aux);
			}else {
				pila.offerLast(aux);
			}
		}
		return pila;
	}
	public static int moda(List<Integer> lista) {
		Map<Integer,Integer> mapa = new HashMap<>();
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) {
			int aux = it.next();
			if(mapa.containsKey(aux)) {
				mapa.replace(aux, mapa.get(aux)+1);
			}else {
				mapa.put(aux,1);
			}
		}
		
		Integer auxValue = lista.get(0);
		Integer auxKey = mapa.get(lista.get(0));
		Iterator<Entry<Integer, Integer>> ite = mapa.entrySet().iterator();
		while(ite.hasNext()) {
			Entry<Integer, Integer> pair = ite.next();
			Integer pairKey = pair.getKey();
			Integer pairValue = pair.getValue();
			if(pairValue>auxValue) {
				auxValue=pairValue;
				auxKey=pairKey;
			}
		}
		return auxKey;
	}
}
