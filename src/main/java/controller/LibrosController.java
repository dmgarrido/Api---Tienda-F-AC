package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.Repository;
import model.Libro;

@RestController
public class LibrosController implements ProductosManager<Libro>{
	
	private List<Libro> libros = Repository.lista_libros;

	//
	//CONSULTA DE DATOS
	//
	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public List<Libro> getAllProductos() {
		return libros;
	}

	@RequestMapping(value = "/libros/", method = RequestMethod.GET)
	public List<Libro> getProductosByParams(@RequestParam(value="titulo", required=false, defaultValue="") String titulo, 
											@RequestParam(value="autor", required=false, defaultValue="") String autor) {
		List<Libro> resultado = new ArrayList<Libro>();
		
		for(Libro libro : libros) {
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

	@RequestMapping(value="/libros/{id}", method=RequestMethod.GET)
	public Libro getProductoById(@PathVariable Integer id) {
		for(Libro libro : libros) {
			if(libro.getId() == id) {
				return libro;
			}
		}
		return null;
	}

	
	//
	//CREACION
	//
	@RequestMapping(value="/libros", method = RequestMethod.POST)
	public void addProducto(@RequestBody Integer id, String titulo, String autor, Double precio) {
		Libro libro = new Libro(id, titulo, autor, precio);
		libros.add(libro);
	}

	
	//
	//MODIFICACION DE DATOS
	//
	@RequestMapping(value="/libros", method=RequestMethod.PUT)
	public void updatePrecioAll(@RequestBody Double precio) {
		for(Libro libro : libros) {
			libro.setPrecio(precio);
		}		
	}

	@RequestMapping(value="/libros/{id}", method=RequestMethod.PUT)
	public void updatePrecioById(@PathVariable Integer id, @RequestBody Double precio) {
		for(Libro libro : libros) {
			if(libro.getId() == id) {
				libro.setPrecio(precio);
			}			
		}		
	}

	
	//
	//BORRADO
	//
	@RequestMapping(value="/libros", method=RequestMethod.DELETE)
	public void deleteProductosAll() {
		libros.clear();
	}

	@RequestMapping(value="/libros/{id}", method=RequestMethod.DELETE)
	public void deleteProductoById(@PathVariable Integer id) {
		
		Iterator<Libro> librosIterator = libros.iterator();
		
		while(librosIterator.hasNext()) {
			Libro libro = librosIterator.next();
			if(libro.getId() == id) {
				librosIterator.remove();
			}
		}

	}

}
