package clases;

public class estudiante {
String cedula;
String nombre;
String apellido;

	public estudiante() {
	this.cedula="";
	this.nombre="";
	this.apellido="";
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
}