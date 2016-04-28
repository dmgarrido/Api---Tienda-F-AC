package model;

public class Disco extends Producto{

	private String artista;
	
	private Disco() {}
	
	public Disco(Integer id, String titulo, String artista, Double precio) {
		super(id, titulo, precio);
		this.artista = artista;
	}
	
	public String getArtista() {
		return artista;
	}
	
}
