package unidad8;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random aleatorio = new Random();
		Collection<Integer> numeros = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			int num = aleatorio.nextInt(100)+1;
			numeros.add(num);
		}
		/*Iterator<Integer> i = numeros.iterator();
		while (i.hasNext()) {
			int num = i.next();
			System.out.println(num);
		}
		*/
		List<Integer> noRepetidos = new ArrayList<Integer>();
		
		for(Integer n:numeros) {
			if(!noRepetidos.contains(n)) {
				noRepetidos.add(n);
			}
		}
		/*for(Integer m:noRepetidos) {
			System.out.print(m+",");
		}*/
		Collection<Integer>ordenados = new ArrayList<Integer>();
		Collections.sort(noRepetidos);
		noRepetidos.forEach(noRepetido->ordenados.add(noRepetido));
		ordenados.forEach(numero->System.out.println(numero));
	}

}
