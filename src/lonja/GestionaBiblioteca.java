package lonja;

import java.io.File;

import Exceptions.LeerTeclado;


public class GestionaBiblioteca {

	public static void main(String[] args) {
		Biblioteca b=new Biblioteca();
		LeerTeclado teclado=new LeerTeclado();
		File f=new  File("objetos.obj");
		if (f.exists()){
			LectorFichLibros lector= new LectorFichLibros("objetos.obj");
			int cont=lector.recuperaBiblioteca(b);
			System.out.println("Se han recuperado "+cont+" libros");
		}
		Menu menu=new Menu();
		int opcion=0;
		while (opcion!=6){
			switch(opcion=menu.dameOpcion()){
			
			case 1:
				String isbn=teclado.leerTexto("Introduce ISBN:");
				String autor=teclado.leerTexto("Introduce autor:");
				String titulo=teclado.leerTexto("Introduce titulo:");
				Libro l=new Libro(isbn,autor,titulo);
				b.añadirLibro(l);
				break;
			case 2:
				String isbn2=teclado.leerTexto("Introduce ISBN:");
				b.borraLibro(isbn2);
				break;
			case 3:
				b.mostrarPorAutor();
				break;
			case 4:
				String isbn3=teclado.leerTexto("Introduce ISBN:");
				Libro l2=b.buscaLibro(isbn3);
				if(!(l2==null))System.out.println(l2.toString());
				else System.out.println("Libro no encontrado");
				break;
			case 5:
				String isbn4=teclado.leerTexto("Introduce ISBN:");
				String autor4=teclado.leerTexto("Introduce autor:");
				String titulo4=teclado.leerTexto("Introduce titulo:");
				b.modificaLibro(isbn4, titulo4, autor4);
				break;
			case 6:break;
			default:System.out.println("Inutil introduce una opcion correcta!");
			
		}
		LectorFichLibros lector= new LectorFichLibros("objetos.obj");
		lector.archivaBiblioteca(b);
		
		}

	}

}
