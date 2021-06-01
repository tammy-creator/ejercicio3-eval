package unidad8;

import java.time.LocalTime;

public class Robot {
	private String nombre;
	private int segundos;
	private int cuentaAtras;
	
	public Robot(String nombre, int segundos) {
		super();
		this.nombre = nombre;
		this.segundos = segundos;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getSegundos() {
		return segundos;
	}



	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}



	public void asignar(LocalTime hora,String producto) {
		cuentaAtras = segundos;		
		System.out.println(nombre + " - " + producto + "[" + hora + "]");
	}
	
	public boolean procesar() {
		if (cuentaAtras > 0)
			cuentaAtras--;
		return cuentaAtras == 0;
	}
	
}
