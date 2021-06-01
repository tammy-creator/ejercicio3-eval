package unidad8;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MainColecciones {

	public static void main(String[] args) {
		Colecciones main = new Colecciones();
		// TODO Auto-generated method stub
		/*Set<String> cadenas = new HashSet<>();
		cadenas.add("hola");
		cadenas.add("adios");
		cadenas.add("hola");
		cadenas.add("hola");
		
		Colecciones main = new Colecciones();
		main.eliminarLasDeLongitudPar(cadenas);
		
		Iterator<String> i = cadenas.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		Set<Integer> cadenasEnteros = new HashSet<>();
		cadenasEnteros.add(2);
		cadenasEnteros.add(2);
		cadenasEnteros.add(2);
		
		System.out.println(main.contieneImpares(cadenasEnteros));
		
		Map<String,String> mapa = new HashMap<>();
		mapa.put("uno", "uno");
		mapa.put("dos", "dos");
		mapa.put("dos", "tres");
		mapa.put("tres", "cuatro");
		mapa.put("cuatro", "uno");
		
		System.out.println(main.valoresUnicos(mapa));
		
		List<String> cadenas2 = new ArrayList<>();
		cadenas2.add("hola");
		cadenas2.add("adios");
		cadenas2.add("hola");
		cadenas2.add("hola");
		
		System.out.println(main.algunaSeRepiteAlMenos3Veces(cadenas2));
		
		Stack<Integer> pila = new Stack<>();
		pila.push(89);
		pila.push(-55);
		pila.push(-19);
		pila.push(29);
		pila.push(37);
		pila.push(-5);
		pila.push(23);
		main.negativosAbajoPositivosArriba(pila);
		System.out.println(pila);
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(1);
		numeros.add(4);
		numeros.add(3);
		numeros.add(3);
		numeros.add(2);
		numeros.add(2);
		System.out.println(main.moda(numeros));
		
		Stack<Integer> pila = new Stack<>();
		pila.push(2);
		pila.push(7);
		pila.push(12);
		pila.push(5);
		pila.push(14);
		pila.push(9);
		pila.push(7);
		pila.push(10);
		pila.push(17);
		pila.push(17);
		pila.push(22);
		pila.push(6);
		
		System.out.println(main.eliminarSiMayoresEncima(pila));
		
		Map<String,Integer> map1 = new HashMap<>();
		map1.put("Fernando", 53);
		map1.put("Manuela", 29);
		map1.put("Ana", 41);
		map1.put("Luis", 65);
		map1.put("Mario", 33);
		Map<String,Integer> map2 = new HashMap<>();
		map2.put("Valentina", 37);
		map2.put("Ana", 41);
		map2.put("Benito", 67);
		map2.put("Carmen", 39);
		map2.put("Mario", 33);
		
		System.out.println(main.interseccion(map1, map2));
		
		Map<String,Integer> map2 = new HashMap<>();
		map2.put("Valentina", 33);
		map2.put("Ana", 33);
		map2.put("Benito", 23);
		map2.put("Carmen", 59);
		map2.put("Mario", 23);
		
		System.out.println(main.valorMenosRepetido( map2));
		
		List<String> lista = new ArrayList<>();
		lista.add("banana");
		lista.add("pera");
		lista.add("malon");
		lista.add("o");
		lista.add("sandia");
		System.out.println(main.cuentaPares(lista));
		
		List<Integer> lista1 = new ArrayList<>();
		lista1.add(1);
		lista1.add(2);
		lista1.add(3);
		lista1.add(4);
		
		List<Integer> lista2 = new ArrayList<>();
		lista2.add(1);
		lista2.add(2);
		lista2.add(3);
		lista2.add(3);

		System.out.println(main.contarComunes(lista1, lista2));
		*/
		Deque<Integer> pila = new LinkedList<>();
		pila.push(7);
		pila.push(6);
		pila.push(2);
		pila.push(9);
		pila.push(5);
		System.out.println(main.duplicar(pila));
	}

}
