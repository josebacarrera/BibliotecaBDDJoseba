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


public class UsuarioModelo extends Conector{

	public ArrayList<Usuario> selectAllUsuarios() {

		ArrayList<Usuario> Lista = new ArrayList<Usuario>();

		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");

			while (rs.next()) {

				Usuario Usuario = new Usuario();

				Usuario.setId(rs.getInt("id"));
				Usuario.setNombre(rs.getString("nombre"));
				Usuario.setApellido(rs.getString("apellido"));
				Usuario.setDni(rs.getString("dni"));
				Usuario.setAdmin(rs.getInt("admin"));
				Usuario.setPassword(rs.getString("password"));

				Lista.add(Usuario);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public ArrayList<Usuario> buscarUsuarios() {

		ArrayList<Usuario> Lista = new ArrayList<Usuario>();

		try {

			System.out.println("Escribe una parte de un usuario(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuario where nombre like '%" + elegir + "%'");

			while (rs.next()) {

				Usuario Usuario = new Usuario();

				Usuario.setId(rs.getInt("id"));
				Usuario.setNombre(rs.getString("nombre"));
				Usuario.setApellido(rs.getString("apellido"));
				Usuario.setDni(rs.getString("dni"));
				Usuario.setAdmin(rs.getInt("admin"));
				Usuario.setPassword(rs.getString("password"));

				Lista.add(Usuario);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public void verUsuario() {

		try {

			System.out.println("Escribe una parte del libro(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios where titulo='" + elegir + "'");

			if (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setAdmin(rs.getInt("admin"));
				usuario.setPassword(rs.getString("password"));
				
				System.out.println(usuario.toString());

			} else {

				System.out.println("No existe ningun usuario con ese nombre");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void actualizarUsuario(String nombre, String password) {

			try {

				System.out.println("Escribe un usuario");
				Scanner sc = new Scanner(System.in);
				String elegir;
				elegir = sc.nextLine();

				Statement st = super.conexion.createStatement();
				ResultSet rs = st.executeQuery("select * from usuarios where usuario='" + elegir + " and where password='" + elegir + "'");

				if (rs.next()) {
					Usuario usuario = new Usuario();
					
					usuario.setId(rs.getInt("id"));
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellido(rs.getString("apellido"));
					usuario.setDni(rs.getString("dni"));
					usuario.setAdmin(rs.getInt("admin"));
					usuario.setPassword(rs.getString("password"));
					
					System.out.println(usuario.toString());

				} else {

					System.out.println("No existe ningun usuario con ese nombre o contraseña");
				}

			}

			catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void borrarUsuario(String dni) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from usuarios where dni=?");
			pst.setString(1, dni);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
	

