package unidad8;

import java.util.Arrays;

public class Naipe {
	private String r;
	private String p;
	
	public Naipe(String r, String p) {
		super();
		this.r = r;
		this.p = p;
	}

	public String getR() {
		return r;
	}

	public String getP() {
		return p;
	}
	
	public int getPuntuacion() {
		String[] rango = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] palos = new String[]{"C","D","H","S"};
		int puntuacion = (Arrays.asList(rango).indexOf(r)+2)*(Arrays.asList(palos).indexOf(p)+1);
		return puntuacion;
	}
	
}
