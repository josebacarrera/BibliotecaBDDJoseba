package principal;
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

public class MAIN01 {
	// TODO poner las opciones del menu
	private static final int SALIR = 0;
	private static final int LISTAR_LIBROS = 1;
	

	public static void main(String[] args) {
		
		//LIBRO
		ArrayList <Libro> Lista = new ArrayList<Libro>();
		
		LibroModelo LM = new LibroModelo();
		
		//SOCIO
		ArrayList <Socio> Soci = new ArrayList<Socio>();
		
		SocioModelo sm = new SocioModelo();
		
		
		//USUARIO
				ArrayList <Usuario> Usu = new ArrayList<Usuario>();
				
				UsuarioModelo um = new UsuarioModelo();
		
		Scanner sc = new Scanner(System.in);
		//TODO realizar la conexiÃ³n a la base de datos
		
		
		
		Scanner scan = new Scanner(System.in);
		
		
		
		int opcion;
		do { 
			System.out.println("Escoge una opción");
			System.out.println("1-Listar libros");
			System.out.println("2-Buscar libros");
			System.out.println("3-Ver libros");
			System.out.println("4-Editar libro");
			System.out.println("5-Eliminar libro");
			System.out.println("6-Listar socios");
			System.out.println("7-Buscar socios");
			System.out.println("8-Ver socios");
			System.out.println("9-Editar socios");
			System.out.println("10-Eliminar socio");
			System.out.println("0-Para cerrar el programa");
			
			
			menuPrincipal();

			opcion = Integer.parseInt(scan.nextLine());

			
			switch (opcion) {
			case 1:
				Lista = LM.selectAllLibros();
				for (int i = 0; i < Lista.size(); i++) {
					
					System.out.println(Lista.get(i).toString());
				} 
				
				break;
				
			case 2:
				
				ArrayList <Libro> Lista2;
				
				Lista2=LM.buscarLibros();
				
				for (int i = 0; i < Lista2.size(); i++) {
					
					System.out.println(Lista2.get(i).toString());
				} 
				
				
				break;
			case 3:
									
				LM.verLibro();
				
			break;
				
			case 4:
				updateLibro();
				break;
	
			case 5:
				borrarLibro();
				break;
	
			case 6:
				Soci = sm.selectAllSocios();
				for (int i = 0; i < Soci.size(); i++) {
					
					System.out.println(Soci.get(i).toString());
				} 
				break;
				
			case 7:
				ArrayList<Socio> Soci2;
				
				Soci2=sm.buscarSocios();
				
				for (int i = 0; i < Soci2.size(); i++) {
					
					System.out.println(Soci2.get(i).toString());
				} 
				break;
				
			case 8:
				sm.verSocio();
				break;
		
			case 9:
				updateSocio();
				break;
		
			case 10:
				borrarSocio();
				break;
				
			case 11:
				Usu = um.selectAllUsuarios();
				for (int i = 0; i < Usu.size(); i++) {
					
					System.out.println(Usu.get(i).toString());
				} 
				break;
				
			case 12:
				ArrayList<Usuario> Soci3;
				
				Soci3=um.buscarUsuarios();
				
				for (int i = 0; i < Soci3.size(); i++) {
					
					System.out.println(Soci3.get(i).toString());
				} 
				break;
				
			case 13:
				um.verUsuario();
				break;
		
			case 14:
				updateContraseñaUsuario();
				break;
		
			case 15:
				borrarUsuario();
				break;
				
			case 0:
				System.out.println("El programa se ha cerrado....");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
				
			}

		} while (opcion !=0);
	}

	

	private static void menuPrincipal() {
		// TODO implemnetar el menu
		
	}
	
	//LIBROS
	
	private static void updateLibro() {
	
	LibroModelo LM = new LibroModelo();
	String titulo;
	int numPaginas;
	Scanner sc = new Scanner(System.in);
	System.out.println("Escribe el titulo de un libro para modificarlo(EN MAYUSCULAS)");
	titulo = sc.nextLine();
	System.out.println("Escribe el numero de paginasque quieras modificar(EN MAYUSCULAS)");
	numPaginas = Integer.parseInt(sc.nextLine());
	LM.actualizarLibro(numPaginas, titulo);
	
	}
	
	private static void borrarLibro() {
		
		LibroModelo LM = new LibroModelo();
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id(EN MAYUSCULAS)");
		id = Integer.parseInt(sc.nextLine());
		LM.borrarLibro(id);
		
		}
	//SOCIO
	private static void updateSocio() {
		
		SocioModelo sm = new SocioModelo();
		String direccion,poblacion,provincia;
		String dni;
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe el dni(EN MAYUSCULAS)");
		dni = sc.nextLine();
		System.out.println("Escribe la direccion(EN MAYUSCULAS)");
		direccion = sc.nextLine();
		System.out.println("Escribe el nombre del pueblo(EN MAYUSCULAS)");
		poblacion = sc.nextLine();
		System.out.println("Escribe el nombre de la provincia(EN MAYUSCULAS)");
		provincia = sc.nextLine();
		sm.actualizarSocio(direccion,poblacion,provincia,dni);
		
		}
		private static void borrarSocio() {
			
			SocioModelo sm = new SocioModelo();
			String dni;
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el dni(EN MAYUSCULAS)");
			dni= sc.nextLine();
			sm.borrarSocio(dni);
			
			}
		
		//USUARIO
		
		private static void updateContraseñaUsuario() {
			
			UsuarioModelo um = new UsuarioModelo();
			Scanner sc= new Scanner(System.in);
			boolean dni;
			int password;

				
					while((nombre==nombre)||(password==password)&& (cont<max)){
						
						System.out.print("introduzca un usuario: ");
						nombre=sc.nextInt();
						System.out.print("Introduzca su password:");
						password=sc.nextInt();
						
						if(cont==3){
							System.out.println("acceso denegado..");
							cont=cont-max;
						}
					
						cont++;
				}
				System.out.println("usuario y password, correctos...");
				um.actualizarUsuario(nombre, password);
		}
			

			private static void borrarUsuario() {
				
				UsuarioModelo sm = new UsuarioModelo();
				String dni;
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduce el dni(EN MAYUSCULAS)");
				dni= sc.nextLine();
				sm.borrarUsuario(dni);
				
				}
	

}