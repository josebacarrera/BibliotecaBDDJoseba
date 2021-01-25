package modelo.dao;

import java.util.*;


import modelo.bin.*;
import modelo.dao.*;
import modelo.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class LibroModelo extends Conector {

	public ArrayList<Libro> selectAllLibros() {

		ArrayList<Libro> Lista = new ArrayList<Libro>();

		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros");

			while (rs.next()) {

				Libro Libro = new Libro();

				Libro.setId(rs.getInt("id"));
				Libro.setTitulo(rs.getString("titulo"));
				Libro.setAutor(rs.getString("autor"));
				Libro.setNumPaginas(rs.getInt("num_pag"));

				Lista.add(Libro);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public ArrayList<Libro> buscarLibros() {

		ArrayList<Libro> Lista = new ArrayList<Libro>();

		try {

			System.out.println("Escribe una parte del libro(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where titulo like '%" + elegir + "%'");

			while (rs.next()) {

				Libro Libro = new Libro();

				Libro.setId(rs.getInt("id"));
				Libro.setTitulo(rs.getString("titulo"));
				Libro.setAutor(rs.getString("autor"));
				Libro.setNumPaginas(rs.getInt("num_pag"));

				Lista.add(Libro);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public void verLibro() {

		try {

			System.out.println("Escribe una parte del libro(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where titulo='" + elegir + "'");

			if (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumPaginas(rs.getInt("num_pag"));
				System.out.println(libro.toString());

			} else {

				System.out.println("No existe ningun libro con ese titulo");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void actualizarLibro(int numPaginas, String titulo) {

		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update libros set num_pag=? where titulo=?");
			pst.setInt(1, numPaginas);
			pst.setString(2, titulo);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void borrarLibro(int id) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from libros where id=?");
			pst.setInt(1, id);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}