package unidad8.colecciones;

public class Robot {

	private String nombre;
	private int segundos;
	private int cuentaAtras;
	
	public Robot(String nombre, int segundos) {
		super();
		this.nombre = nombre;
		this.segundos = segundos;
	}
	
	public void asignar(String producto, String hora) {
		System.out.println(nombre + " - " + producto + "[" + hora + "]");
		cuentaAtras = segundos;
	}
	
	public boolean procesar() {
		if (cuentaAtras > 0)
			cuentaAtras--;
		return cuentaAtras == 0;
	}
	
}
