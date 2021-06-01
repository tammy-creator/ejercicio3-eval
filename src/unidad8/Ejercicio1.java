package unidad8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int num = teclado.nextInt();
		teclado.nextLine();
		int aux=0;
		Collection<String> lista = new ArrayList<String>();
		do {
			String nombre = teclado.nextLine();
			if(!lista.contains(nombre)) {
				lista.add(nombre);
			}
			aux++;
			
		}while(aux<num);
		for(String l:lista) {
			System.out.println(l);
		}
		
	}

}
