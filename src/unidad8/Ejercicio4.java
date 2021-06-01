package unidad8;


//import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4 {
	static Palabras palabras = new Palabras();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("> ");
		}while(ejecutar(teclado.nextLine()));
		
	}
	
	static boolean ejecutar(String linea) {
		Scanner teclado = new Scanner(linea);
		try {
			String consola = teclado.next("añadir:|lista|borrar$|borrar:|fin$");
			switch (consola) {
				case "añadir:":
					consolaAñadir(teclado);
					break;
				case "lista:": 
					consolaLista(teclado);
					break;
				case "borrar":
					
				case "borrar:":
					consolaBorrar(teclado);
					break;
				case "fin":
					return false;
			}
		}catch(Exception e) {
			System.out.println("no se reconoce el comando");
		}finally {
			teclado.close();
		}
		return true;
	}
	
	static void consolaAñadir(Scanner teclado) {
		palabras.addPalabras(teclado.nextLine());
	}
	
	static void consolaBorrar(Scanner teclado) {
		palabras.eliminarTodas();
		if(teclado.hasNext()) {
			consolaAñadir(teclado);
		}
	}
	
	static void consolaLista(Scanner teclado) {
		try {
			int longitud = teclado.nextInt();
			if (teclado.hasNext())
				System.out.println("error: no se esperaba: " + teclado.nextLine());
			else {
				Set<String> lista = palabras.get(longitud);
				System.out.println(lista == null ? "no hay palabras de longitud " + longitud : lista);
			}
		} catch (Exception e) {
			System.out.println("error: no es un número entero: " + teclado.next());
		};
	}
	
}
