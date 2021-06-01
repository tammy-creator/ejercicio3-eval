package unidad8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		String linea = teclado.nextLine();
		
		Collection<String> noRep = new ArrayList<String>();
		Collection<String> siRep = new ArrayList<String>();
		
		String[] strPart = linea.split("\\s");
		
		
		for(int i=0; i<strPart.length-1; i++) {
			for(int j=i+1; j<strPart.length; j++) {
				if(strPart[i]==strPart[j]) {
					siRep.add(strPart[i]);
				}else {
					noRep.add(strPart[i]);
				}
			}
		}
		
		for(String n:noRep) {
			System.out.print(n+", ");
		}
		System.out.println();
		for(String s:siRep) {
			System.out.print(s+", ");
		}
	}

}
