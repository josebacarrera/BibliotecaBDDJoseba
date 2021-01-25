package modelo.bin;
import java.util.*;
import java.io.*;
import java.sql.*;
public class Libro {
	
	//ATRIBUTOS
	
	int id;
	String titulo;
	String autor;
	int numPaginas;
	
	//CONSTRUCTORES
	
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(int id, String titulo, String autor, int numPaginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	//GETTERS Y SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	
	//METODOS
	
	//METODOS SELECT
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", numPaginas=" + numPaginas + "]";
	}

	
	
	
	
	
}
