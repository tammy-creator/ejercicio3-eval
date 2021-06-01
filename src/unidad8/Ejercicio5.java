package unidad8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio5 {
	static boolean encontrado = false;
	static int numEncontrado = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ejecutar();
		if(encontrado== false) {
			System.out.println(numEncontrado);
		}else {
			System.out.println(encontrado);
		}
	}

	static boolean ejecutar() throws Exception {
		Scanner teclado = new Scanner(System.in);
		String linea = teclado.nextLine();
		String[] primeraLinea =  linea.split(" ");
		int elementsQueue = Integer.parseInt(primeraLinea[0]);
		int removeElements = Integer.parseInt(primeraLinea[1]);
		int locateElement = Integer.parseInt(primeraLinea[2]);
		int i=0;
		
		Deque<Integer> cola = new LinkedList<Integer>();
		linea = teclado.nextLine();
		for(String num: linea.split(" ")) {
			if(i > elementsQueue-1) {
				throw new Exception("Demasiados elementos en linea");
			}
			cola.add(Integer.parseInt(num));
			i++;
		}
		if(i < elementsQueue-1) {
			throw new Exception("Demasiados pocos elementos en linea");
		}
			
		for(i=0; i<removeElements; i++) {
			int eliminado = cola.removeLast();
			if(eliminado == locateElement) {
				encontrado = true;
				return true;
			}
		}
		
		List<Integer> cola1 = new ArrayList<>();
		cola1.addAll(cola);
		
		Collections.sort(cola1);
		numEncontrado = cola1.get(0);
		
		encontrado = false;
		return false;
		
	}
	
}
