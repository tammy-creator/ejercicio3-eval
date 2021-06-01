package unidad8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class Colecciones {
	public void eliminarLasDeLongitudPar(Set<String> cadenas) {
		Iterator<String> i = cadenas.iterator();
		while(i.hasNext()) {
			if(i.next().length()%2 == 0) {
				i.remove();
			}
		}
	}
	public boolean contieneImpares(Set<Integer> set) {
		Iterator<Integer> i = set.iterator();
		while(i.hasNext()) {
			if(i.next()%2!=0) {
				return true;
			}
		}
		return false;
	}
	public boolean valoresUnicos(Map<String,String> cadenas) {
		Iterator<Entry<String, String>> it = cadenas.entrySet().iterator();
		ArrayList<String> valores = new ArrayList<>();
		
		while(it.hasNext()) {
			Entry pair = it.next();
			valores.add((String) pair.getValue());
		}
		
		for(int i=0; i<valores.size(); i++) {
			for(int j=i+1; j<valores.size(); j++) {
				if(valores.get(i).equals(valores.get(j))) {
					return true;
				}
			}
		}
		return false;
	}
	public boolean algunaSeRepiteAlMenos3Veces(List<String> cadenas) {
		Map<String,Integer> aux = new HashMap<>();
		Iterator<String> it = cadenas.iterator();
		while(it.hasNext()) {
			String palabra = it.next();
			if(aux.containsKey(palabra)) {
				if(aux.get(palabra)==2) {
					return true;
				}
				aux.put(palabra, aux.get((Object)palabra)+1);
			}else {
				aux.put(palabra, 1);
			}
		}
		/*List<Integer> repeticiones = new ArrayList<>();
		repeticiones.addAll(aux.values());
		Collections.sort(repeticiones);
		//Collections.reverse(repeticiones);
		if(repeticiones.get(repeticiones.size()-1)>=3) {
			return true;
		}*/
		return false;
	}
	public void negativosAbajoPositivosArriba(Stack<Integer> pila) {
		Deque<Integer> cola = new LinkedList<>();
		while(!pila.isEmpty()) {
			int aux = pila.pop();
			if(aux<0) {
				cola.offerLast(aux);
			}else {
				cola.offerFirst(aux);
			}			
		}
		while(!cola.isEmpty()) {
			pila.push(cola.pop());
		}		
	}
	public Integer moda(List<Integer> lista) {
		if(lista.isEmpty()) {
			return 0;
		}
		Map<Integer, Integer> mapa = new HashMap<>();
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) {
			int n = it.next();
			if(mapa.containsKey(n)) {
				mapa.put(n, mapa.get((Object)n)+1);
			}else {
				mapa.put(n, 1);
			}
		}
		Integer aux= mapa.get(lista.get(0));
		Integer auxkey = lista.get(0);
		Iterator<Entry<Integer, Integer>> ite = mapa.entrySet().iterator();
		while(ite.hasNext()) {
			Entry<Integer, Integer> pair = ite.next();
			Integer valuePair = (Integer) pair.getValue();
			Integer keyPair = (Integer) pair.getKey();
			if(valuePair>aux) {
				aux=valuePair;
				auxkey = keyPair;
			}
		}
		return auxkey;
		
	}
	public Stack eliminarSiMayoresEncima(Stack<Integer> pila) {
		Stack<Integer> pilaux = new Stack<>();
		Stack<Integer> eliminados = new Stack<>();
		while(!pila.isEmpty()) {
			int aux = pila.pop();
			boolean detectado = false;
			while(!pila.isEmpty()) {
				int aux2 = pila.pop();
				pilaux.add(aux2);
				if(aux2>aux && !detectado) {
					eliminados.add(aux);
					detectado = true;
				}
				
			}
			while(!pilaux.isEmpty()) {
				pila.add(pilaux.pop());
			}
		}
		return eliminados;	
	}
	public Map interseccion(Map<String, Integer>map1, Map<String, Integer>map2) {
		Map<String, Integer>resultado = new HashMap<>();
		Iterator<Entry<String, Integer>> ite = map1.entrySet().iterator();
		while(ite.hasNext()) {
			Entry<String, Integer> pair = ite.next();			
			if(map2.containsKey(pair.getKey())&& map2.get(pair.getKey())==pair.getValue()) {
				resultado.put(pair.getKey(), pair.getValue());
			}
		}
		return resultado;
	}
	public Integer valorMenosRepetido(Map<String, Integer>mapa) {
		Map<Integer,Integer> mapAux = new HashMap<>();
		
		ArrayList<Integer> edades = new ArrayList<>(mapa.values());
		Iterator<Integer> ite = edades.iterator();
		while(ite.hasNext()) {
			int edad = ite.next();			
			if(mapAux.containsKey(edad)) {
				mapAux.put(edad, mapAux.get(edad)+1);
			}else {
				mapAux.put(edad, 1);
			}
		}
		Iterator<Entry<Integer, Integer>> it = mapAux.entrySet().iterator();
		
		int min=mapAux.get(edades.get(0));
		boolean firstAgeMin = true;
		int minAge = 0;
		while(it.hasNext()) {
			Entry<Integer, Integer> pair = it.next();	
			if(pair.getValue()<=min) {
				min=pair.getValue();
				if(firstAgeMin) {
					minAge = pair.getKey();
					firstAgeMin = false;
				}
				else {
					if(pair.getKey() < minAge)
						minAge = pair.getKey();
				}
			}
		}
		return minAge;
	}
	
			
	public Map cuentaPares(List<String> lista) {
		Map<String, Integer> contador = new HashMap<>();
		String aux;
		for(String palabra:lista) {
			for(int i=0;i<palabra.length()-1;i++) {
				if(palabra.length()>1) {
					aux=palabra.substring(i,i+2);
					if(!contador.containsKey(aux)) {
						contador.put(aux, 1);
					}else {
						contador.put(aux, contador.get(aux)+1);
					}
				}
				
			}
		}
		return contador;
	}
	
	public int contarComunes(List<Integer>lista1, List<Integer>lista2) {
		int repetidos=0;
		Set<Integer> lista1NoRep = new HashSet<>(lista1);
		Set<Integer> lista2NoRep = new HashSet<>(lista2);
		Iterator<Integer> it = lista1NoRep.iterator();
		while(it.hasNext())
			if(lista2NoRep.contains(it.next())) {
				repetidos++;
			}
		return repetidos;
	}
	
	public Deque duplicar(Deque<Integer> pila) {
		Deque<Integer> pilAux = new LinkedList<>();
		while(!pila.isEmpty()) {
			int aux = pila.pop();
			pilAux.push(aux);
			pilAux.push(aux);
		}
		while(!pilAux.isEmpty()) {
			pila.push(pilAux.pop());
		}
		return pila;
	}
}
