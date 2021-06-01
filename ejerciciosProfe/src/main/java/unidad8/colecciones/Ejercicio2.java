package unidad8.colecciones;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio2 {

	public static void main(String[] args) {
		Random r = new Random();
		List<Integer> lista = new LinkedList<>();
		for (int i=0; i<100; i++)
			lista.add(r.nextInt(1000) + 1);
		Iterator<Integer> i = lista.iterator();
		while (i.hasNext())
			System.out.print(i.next() + "  ");
		System.out.println();
		
		Set<Integer> set1 = new HashSet<>(lista);
		for (Integer n: set1)
			System.out.print(n + "  ");
		System.err.println();
		
		
		Set<Integer> set2 = new TreeSet<>(lista);
		set2.forEach(n -> System.out.print(n + "  "));
		System.err.println();
		
	}

}
