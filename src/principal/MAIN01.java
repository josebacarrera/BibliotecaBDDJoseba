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
		
		ArrayList <Libro> Lista = new ArrayList<Libro>();
		
		LibroModelo LM = new LibroModelo();
		
		
		
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
				update();
				break;
	
			case 5:
				borrar();
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
	
	private static void update() {
	
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
	
	private static void borrar() {
		
		LibroModelo LM = new LibroModelo();
		int id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id(EN MAYUSCULAS)");
		id = Integer.parseInt(sc.nextLine());
		LM.borrarLibro(id);
		
		}
	

}