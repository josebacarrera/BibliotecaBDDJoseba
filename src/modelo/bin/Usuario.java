package modelo.bin;
import java.util.*;
import java.io.*;
import java.sql.*;
public class Usuario {

	//ATRIBUTOS
	int id;
	String nombre;
	String apellido;
	String dni;
	int admin;
	String password;
	
	
	//CONSTRUCTORES
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(int id, String nombre, String apellido, String dni, int admin, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.admin = admin;
		this.password = password;
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


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public int getAdmin() {
		return admin;
	}


	public void setAdmin(int admin) {
		this.admin = admin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	//METODOS
	
	//METODOS SELECT
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", admin="
				+ admin + ", password=" + password + "]";
	}
	
}
