package unidad8;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);
		String linea = teclado.nextLine();
		String[] primeraLinea =  linea.split(" ");
		int n = Integer.parseInt(primeraLinea[0]);
		int m = Integer.parseInt(primeraLinea[1]);
		
		Deque<Integer> colaN = new LinkedList<Integer>();
		Deque<Integer> colaM = new LinkedList<Integer>();
		linea = teclado.nextLine();
		String[] segundaLinea =  linea.split(" ");
		
		List<Integer> num = new ArrayList<>();		
		for(int i=0; i<segundaLinea.length; i++) {
			num.add(Integer.parseInt(segundaLinea[i]));
		}
		for(int i=0; i<n ; i++) {
			colaN.offer(num.get(i));
		}
		for(int i=n; i<n+m; i++) {
			colaM.offer(num.get(i));
		}
		
		
		Deque<Integer>repetidos = new LinkedList<Integer>();
		
		
		for(int numero: colaN) {
			if(colaM.contains(numero)) {
				repetidos.add(numero);
			}
		}
		
		for(int rep: repetidos)
		System.out.print(rep+" ");
	}
	
}
