package lonja;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LectorFichLibros {
	File fichero;
	LectorFichLibros(String nombre){
		fichero=new File(nombre);
	}
	public int recuperaBiblioteca(Biblioteca b){
		int cont = 0;
		try {
			if(fichero.exists()){
				FileInputStream fis=new FileInputStream(fichero);
				ObjectInputStream is=new ObjectInputStream(fis);
				cont=b.recuperaLibros(is);
				fis.close();
				is.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cont;
	}
	
	public int archivaBiblioteca(Biblioteca b){
		int cont = 0;
		try {
		
				FileOutputStream fos=new FileOutputStream(fichero);
				ObjectOutputStream os=new ObjectOutputStream(fos);
				cont=b.archivoLibros(os);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cont;
	}
	
}
