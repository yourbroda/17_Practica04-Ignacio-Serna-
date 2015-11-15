package lonja;

import java.io.Serializable;

public class Libro implements Serializable {
	String autor="Ignacio";
	String titulo="Historias de un escalador";
	String ISBN;
	public Libro(String iSBN) {
		super();
		ISBN = iSBN;
	}
	public Libro(String iSBN,String autor, String titulo) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		ISBN = iSBN;
	}
	@Override
	public String toString() {
		return autor.toUpperCase() + ", " + titulo.toUpperCase() + ", " + ISBN.toUpperCase();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		return true;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
