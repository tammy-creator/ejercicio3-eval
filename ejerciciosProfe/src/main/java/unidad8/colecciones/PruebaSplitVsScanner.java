package unidad8.colecciones;

import java.util.Arrays;
import java.util.Scanner;

public class PruebaSplitVsScanner {

	public static void main(String[] args) {
        final String DELIMITADOR = "\\P{L}+";
        final String TEXTO = "**a**b**c";
        pruebaSplit(TEXTO, DELIMITADOR);
        pruebaScanner(TEXTO, DELIMITADOR);
    }

    static void pruebaSplit(String texto, String delimitador) {
        System.out.println("String.split:");
        String [] split = texto.split(delimitador);
        
        /*
         * la sentencia comentada evitaría que se incluya la cadena vacía en el array
         */
        
//        String [] split = texto.replaceFirst("^" + delimitador, "").split(delimitador);
        
        System.out.println(Arrays.toString(split) + " - " + split.length);
    }

    static void pruebaScanner(String texto, String delimitador) {
        System.out.println("Scanner:");
        Scanner s = new Scanner(texto);
        s.useDelimiter(delimitador);
        System.out.print("[");
        while (s.hasNext())
            System.out.print(s.next() + (s.hasNext() ? ", " : "]"));
        System.out.println();
        s.close();
    }

}
