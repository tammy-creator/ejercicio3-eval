package unidad8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio6 { 
	static List<Contacto> contactos = new ArrayList<>();
	static Iterator<Contacto> iter;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		do {
			System.out.print("> ");
		}while(ejecutar(teclado.nextLine()));
	}
	static boolean ejecutar(String linea) {
		Scanner teclado = new Scanner(linea);
		String contacto = teclado.nextLine();
		try {
			if(!contacto.startsWith("buscar:")&& !contacto.startsWith("eliminar:")&& !contacto.equals("contactos")&& !contacto.equals("salir")) {
				contactoAñadir(contacto);
			}else {
				String[] comando = contacto.split(":");
				
				switch (comando[0]) {
				case "buscar": 
					consolaBuscar(comando[1]);
					break;
				case "eliminar":
					consolaBorrar(comando[1]);
					break;
				case "contactos":
					consolaContactos();
					break;
				case "salir":
					return false;
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.toString());
			System.out.println("no se reconoce el comando");
		}finally {
			teclado.close();
		}
		return true;
	}
	static void contactoAñadir(String contacto) {		
		String[] contacts = contacto.split(":");
		Contacto c;
		try {
			c = new Contacto(contacts[0], Integer.parseInt(contacts[1]));
		}
		catch(NumberFormatException e) {
			System.out.println("Error: El número de teléfono ha de ser numérico");
			return;
		}
		iter=contactos.iterator();
		while(iter.hasNext()) {
			Contacto contactoIter = iter.next();
			if(contactoIter.getNombre().equals(c.getNombre()) && contactoIter.getTelefono() == c.getTelefono()) {
				System.out.println("El contacto ya existe");
				return;
			}			
		}
		contactos.add(c);		
	}
	
	static void consolaBuscar(String nombreContacto) {
		iter=contactos.iterator();
		int aux=0;
		int[] telefonos = new int[contactos.size()];
		while(iter.hasNext()) {
			Contacto contAux = iter.next();
			if(contAux.getNombre().equals(nombreContacto)) {
				telefonos[aux++]=contAux.getTelefono();
			}			
		}
		if(aux==0) {
			System.out.println("no existe el contacto en la agenda");
		}else {
			for(int i=0; i<aux; i++) {
				System.out.print(telefonos[i]+",");
			}		
			System.out.println();
		}
	}
	
	static void consolaBorrar(String nombreContacto) {
		boolean encontrado = false;
		for(int i=0; i<contactos.size(); i++) {
			if(contactos.get(i).getNombre().equals(nombreContacto)){
				contactos.remove(i);
				encontrado=true;
			}
		}
		if(encontrado==false) {
			System.out.println("El nombre no existe en la lista de contactos");
		}
	}
	static void consolaContactos() {
		iter=contactos.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}
}
