package modelo.bin;
import java.util.*;
import java.io.*;
import java.sql.*;
public class Socio {

	//ATRIBUTOS
	int id;
	String nombre;
	String apellido;
	String direccion;
	String poblacion;
	String provincia;
	String dni;
	
	//CONSTRUCTORES
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Socio(int id, String nombre, String apellido, String direccion, String poblacion, String provincia,
			String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.dni = dni;
	}
	
	//GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
	//METODOS
	
	//METODOS SELECT
	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", poblacion=" + poblacion + ", provincia=" + provincia + ", dni=" + dni + "]";
	}
	
	
}
