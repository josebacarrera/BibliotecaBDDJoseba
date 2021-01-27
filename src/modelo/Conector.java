package modelo;
import java.util.*;
import java.io.*;
import java.sql.*;

public class Conector {

	protected Connection conexion;
	
	public Conector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conexion=DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD,Config.USERNAME,Config.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	public class Conector2 {

		protected Connection conexion2;
		
		public Conector2() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				this.conexion2=DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD,Config.USERNAME,Config.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		public Connection getConexion2() {
			return conexion2;
		}

		public void setConexion2(Connection conexion2) {
			this.conexion2 = conexion2;
		}
	
	}
	
}
