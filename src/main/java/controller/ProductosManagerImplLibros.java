package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import data.Repository;
import model.Libro;

public class ProductosManagerImplLibros implements ProductosManager<Libro>{

	@Override
	public List<Libro> getAllProductos() {
		return Repository.lista_libros;
	}

	@Override
	public List<Libro> getProductosByParams(String titulo, String autor) {
		
		List<Libro> resultado = new ArrayList<Libro>();
		
		for(Libro libro : getAllProductos()) {
			if(!titulo.equals("")) {
				if(!autor.equals("")) {
					if(libro.getTitulo().equals(titulo) && libro.getAutor().equals(autor)) {
						resultado.add(libro);
					}
				} else {
					if(libro.getTitulo().equals(titulo)) {
						resultado.add(libro);
					}
				}
			} else {
				if (libro.getAutor().equals(autor)) {
					resultado.add(libro);
				}
			}
		}
		return resultado;
	}

	@Override
	public Libro getProductoById(Integer id) {
		for(Libro libro : getAllProductos()) {
			if(libro.getId() == id) {
				return libro;
			}
		}
		return null;
	}

	@Override
	public void addProducto(Integer id, String titulo, String autor, Double precio) {
		Libro libro = new Libro(id, titulo, autor, precio);
		getAllProductos().add(libro);
		
	}

	@Override
	public void updatePrecioAll(Double precio) {
		for(Libro libro : getAllProductos()) {
			libro.setPrecio(precio);
		}
		
	}

	@Override
	public void updatePrecioById(Integer id, Double precio) {
		for(Libro libro : getAllProductos()) {
			if(libro.getId() == id) {
				libro.setPrecio(precio);
			}			
		}
		
	}

	@Override
	public void deleteProductosAll() {
		getAllProductos().clear();
		
	}

	@Override
	public void deleteProductoById(Integer id) {
		Iterator<Libro> librosIterator = getAllProductos().iterator();
		
		while(librosIterator.hasNext()) {
			Libro libro = librosIterator.next();
			if(libro.getId() == id) {
				librosIterator.remove();
			}
		}
		
	}

}
