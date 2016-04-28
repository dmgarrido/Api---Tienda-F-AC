package model;

public class Pelicula extends Producto{

	private String formato;
	
	private Pelicula() {}
	
	public Pelicula(Integer id, String titulo, String formato, Double precio) {
		super(id, titulo, precio);
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}
	
}
