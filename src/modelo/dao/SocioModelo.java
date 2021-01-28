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

	

}