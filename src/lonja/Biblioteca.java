package lonja;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Biblioteca {
	ArrayList <Libro> estanteria;

	public Biblioteca() {
		super();
		estanteria=new ArrayList <Libro>();
	}
	
	public boolean añadirLibro(Libro libroNuevo){
		if(estanteria.contains(libroNuevo)){
			return false;
		}
		else{
			estanteria.add(libroNuevo);
			return true;
		}		
	}
	public int archivoLibros(ObjectOutputStream os){
		int cont=0;
		for (Libro l : estanteria) {
			try {
				os.writeObject(l);
				cont++;
			} catch (IOException e) {
				System.out.println("Error en la escritura");
			}
		}
		return cont;
	}
	public int recuperaLibros(ObjectInputStream is){
		Libro l;
		int cont = 0;
		try {
			while((l=(Libro) is.readObject())!=null){
					estanteria.add(l);
					cont++;
			}
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		return cont;
	}
	public boolean borraLibro(String isbn){
		if(estanteria.remove(new Libro(isbn)))return true;
		return false;
	}
	public Libro buscaLibro(String isbn){
		if(estanteria.contains(new Libro(isbn))){
			Libro l=estanteria.get(estanteria.indexOf(new Libro(isbn)));
			return l;
		}
		return null;
	}
	public Libro modificaLibro(String isbn,String titulo,String autor){
		
		if(estanteria.contains(new Libro(isbn))){
			Libro l=estanteria.get(estanteria.indexOf(new Libro(isbn)));
			if(!titulo.equals(null))l.setTitulo(titulo);
			if(!autor.equals(null))l.setAutor(autor);
			estanteria.remove(l);
			estanteria.add(l);
			return l;
		}
		return null;
	}
	public void mostrarPorAutor(){
		Libro l,l2;
		String autor,autor2;
		for(int i=0;i<estanteria.size();i++){
			l=estanteria.get(i);
			for(int j=i+1;j<estanteria.size();j++){
				autor=l.getAutor();
				l2=estanteria.get(j);
				autor2=l2.getAutor();
				if(autor.codePointAt(0)>autor2.codePointAt(0)){
					estanteria.remove(l);
					estanteria.remove(l2);
					estanteria.add(i, l2);
					estanteria.add(j,l);
					l=l2;
					
				}
			}
			
		}
		for(Libro l3:estanteria){
			if(!l3.equals(null))System.out.println(l3.toString());
		}
	}
	

}
