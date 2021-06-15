package repasoColecciones;

import java.io.Serializable;
import java.time.LocalDate;


public class Alumno implements Comparable<Alumno>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String ciclo;
	private Integer curso;
	
	public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento, String ciclo, Integer curso) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.ciclo = ciclo;
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public Integer getCurso() {
		return curso;
	}

	public void setCurso(Integer curso) {
		this.curso = curso;
	}

	@Override
	public int compareTo(Alumno a) {
		int resultado = apellidos.compareTo(a.apellidos);
		if(resultado == 0) {
			resultado= nombre.compareTo(a.nombre);
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento
				+ ", ciclo=" + ciclo + ", curso=" + curso + "]\n";
	}

	
}
