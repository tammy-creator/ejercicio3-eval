package repasoColecciones;

import java.io.Serializable;
import java.util.Comparator;

public class Comparador implements Comparator<Alumno>, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public int compare(Alumno a1, Alumno a2) {
		int resultado = a1.getCiclo().compareTo(a2.getCiclo());
		if(resultado ==0) {
			resultado=a1.getCurso().compareTo(a2.getCurso());
			if(resultado==0) {
				resultado=a1.getApellidos().compareTo(a2.getApellidos());
				if(resultado==0) {
					resultado=a1.getNombre().compareTo(a2.getNombre());							
				}
			}
		}		
		return resultado;
	}

}
