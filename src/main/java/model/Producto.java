package model;


public class Producto {
	private Integer id;
	private String titulo;
	private Double precio;
	
	protected Producto() {}
	
	public Producto(Integer id, String titulo, Double precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}
	
	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
}
