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

public class SocioModelo extends Conector {

	public ArrayList<Socio> selectAllSocios() {

		ArrayList<Socio> Lista = new ArrayList<Socio>();

		try {

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios");

			while (rs.next()) {

				Socio Socio = new Socio();

				Socio.setId(rs.getInt("id"));
				Socio.setNombre(rs.getString("nombre"));
				Socio.setApellido(rs.getString("apellido"));
				Socio.setDireccion(rs.getString("direccion"));
				Socio.setPoblacion(rs.getString("poblacion"));
				Socio.setProvincia(rs.getString("provincia"));
				Socio.setDni(rs.getString("dni"));
				
				Lista.add(Socio);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public ArrayList<Socio> buscarSocios() {

		ArrayList<Socio> Lista = new ArrayList<Socio>();

		try {

			System.out.println("Escribe una parte del nombre(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios where nombre like '%" + elegir + "%'");

			while (rs.next()) {

				Socio Socio = new Socio();

				Socio.setId(rs.getInt("id"));
				Socio.setNombre(rs.getString("nombre"));
				Socio.setApellido(rs.getString("apellido"));
				Socio.setDireccion(rs.getString("direccion"));
				Socio.setPoblacion(rs.getString("poblacion"));
				Socio.setProvincia(rs.getString("provincia"));
				Socio.setDni(rs.getString("dni"));
				
				Lista.add(Socio);

			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		return Lista;
	}

	public void verSocio() {

		try {

			System.out.println("Escribe un nombre de socio(EN MAYUSCULAS)");
			Scanner sc = new Scanner(System.in);
			String elegir;
			elegir = sc.nextLine();

			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from socios where dni='" + elegir + "'");

			if (rs.next()) {
				
				Socio Socio = new Socio();
				
				Socio.setId(rs.getInt("id"));
				Socio.setNombre(rs.getString("nombre"));
				Socio.setApellido(rs.getString("apellido"));
				Socio.setDireccion(rs.getString("direccion"));
				Socio.setPoblacion(rs.getString("poblacion"));
				Socio.setProvincia(rs.getString("provincia"));
				Socio.setDni(rs.getString("dni"));
				System.out.println(Socio.toString());

			} else {

				System.out.println("No existe ningun socio con ese dni");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void actualizarSocio(String direccion,String pueblo,String provincia,int dni) {

		System.out.println("Escribe el dni del socio(EN MAYUSCULAS)");
		Scanner sc = new Scanner(System.in);
		String elegir;
		elegir = sc.nextLine();
		
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("update socios set direccion=? where dni=?");
			pst.setString(1, direccion);
			pst.setInt(2, dni);
			pst = super.conexion.prepareStatement("update socios set pueblo=? where dni=?");
			pst.setString(1, pueblo);
			pst.setInt(2, dni);
			pst = super.conexion.prepareStatement("update socios set provincia=? where dni=?");
			pst.setString(1, provincia);
			pst.setInt(2, dni);
		
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void borrarSocio(int dni) {

		PreparedStatement pst;
		try {
			pst = (PreparedStatement) super.conexion.prepareStatement("delete from socios where dni=?");
			pst.setInt(1, dni);
			pst.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}