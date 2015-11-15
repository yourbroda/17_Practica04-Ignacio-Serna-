package lonja;

import Exceptions.LeerTeclado;


public class Menu {
	LeerTeclado teclado;
	public Menu() {
		teclado=new LeerTeclado();
	}
	public int dameOpcion(){
		while(true){
			System.out.println("1.-Añadir Libro");
			System.out.println("2.-Borrar Libro");
			System.out.println("3.-Mostrar Libros");
			System.out.println("4.-Buscar Libro");
			System.out.println("5.-Modificar Libro");
			System.out.println("6.-Salir");
			int opcion=teclado.leerEntero("Introduce una opcion:");
			if(opcion<7)return opcion;
		}
		
	}
}
