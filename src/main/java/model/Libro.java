package model;

public class Libro extends Producto{

	private String autor;
	
	private Libro() {}
	
		public Libro(Integer id, String titulo, String autor, Double precio) {
		super(id, titulo, precio);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

}
