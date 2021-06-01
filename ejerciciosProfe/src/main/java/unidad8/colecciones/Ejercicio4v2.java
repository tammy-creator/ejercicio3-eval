package unidad8.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio4v2 {

	static Palabras palabras = new Palabras();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
        } while (execute(in.readLine()));
    }

    static boolean execute(String cmdLine) {
        Scanner s = new Scanner(cmdLine);
        String cmd;
        try {
            cmd = s.skip("\\s*(añadir|borrar|lista|fin)").match().group().trim();
            switch (cmd) {
                case "añadir":
                    cmdAñadir(s);
                    break;
                case "borrar":
                    cmdBorrar(s);
                    break;
                case "lista":
                    cmdLista(s);
                    break;
                case "fin":
                    return false;
            }
        } catch (NoSuchElementException e) {
            String linea = s.nextLine();
            System.out.println("error: comando incorrecto: " + linea.substring(0, 20) + (linea.length() > 20 ? " ..." : ""));
        } finally {
            s.close();
        }
        return true;
    }

    static void cmdAñadir(Scanner s) {
        try {
            s.skip("\\s*:\\s*");
            añadir(s);
        } catch (NoSuchElementException e) {
            System.out.println("error: se esperaba el carácter ':'");
        }
    }

    static void añadir(Scanner s) {
        try {
            String nuevas = s.skip("([^\\p{L}-]*[\\p{L}-]+)+[^\\p{L}-]*").match().group();
            palabras.addPalabras(nuevas);
        } catch (NoSuchElementException e) {
            System.out.println("error: no se han encontrado palabras");
        }
    }

    static void cmdBorrar(Scanner s) {
        try {
            String sgte = s.skip("\\s*:\\s*|\\s*$").match().group().trim();
            palabras.eliminarTodas();
            if (sgte.equals(":"))
                añadir(s);
        } catch (NoSuchElementException e) {
            if (s.hasNext())
                System.out.println("error: se esperaba el carácter ':'");
        }
    }

    static void cmdLista(Scanner s) {
        try {
            int longitud = s.nextInt();
            if (s.hasNext())
                System.out.println("error: no se esperaba: " + s.nextLine());
            else {
				Set<String> lista = palabras.get(longitud);
				System.out.println(lista == null ? "no hay palabras de longitud " + longitud : lista);
			}
        } catch (NoSuchElementException e) {
            System.out.println("error: no es un número entero: " + s.next());
        }
    }
	
}
