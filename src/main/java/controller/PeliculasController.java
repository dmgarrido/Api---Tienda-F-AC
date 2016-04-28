package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Libro;
import model.Pelicula;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.Repository;

@RestController
public class PeliculasController implements ProductosManager<Pelicula>{
	
	private List<Pelicula> peliculas = Repository.lista_peliculas;
	

	//
	//CONSULTA DE DATOS
	//
	@RequestMapping(value="/peliculas", method=RequestMethod.GET)
	public List<Pelicula> getAllProductos() {
		return peliculas;
	}

	@RequestMapping(value="/peliculas/{id}", method=RequestMethod.GET)
	public Pelicula getProductoById(@PathVariable Integer id) {
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getId() == id) {
				return pelicula;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/peliculas/", method=RequestMethod.GET)
	public List<Pelicula> getProductosByParams(@RequestParam (value="titulo", required=false, defaultValue="") String titulo, 
												@RequestParam (value="formato", required=false, defaultValue="") String formato) {
		
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		
		for(Pelicula pelicula : peliculas) {
			if(!titulo.equals("")) {
				if(!formato.equals("")) {
					if(pelicula.getTitulo().equals(titulo) && pelicula.getFormato().equals(formato)) {
						resultado.add(pelicula);
					}
				} else {
					if(pelicula.getTitulo().equals(titulo)) {
						resultado.add(pelicula);
					}
				}
			} else {
				if (pelicula.getFormato().equals(formato)) {
					resultado.add(pelicula);
				}
			}
		}
		
		return resultado;
	}

	
	//
	//CREACION
	//
	@RequestMapping(value="/peliculas", method = RequestMethod.POST)
	public void addProducto(@RequestBody Integer id, String titulo, String formato, Double precio) {
		
		Pelicula pelicula = new Pelicula(id, titulo, formato, precio);
		
		peliculas.add(pelicula);
	}

	
	//
	//MODIFICACION DE DATOS
	//
	@RequestMapping(value="/peliculas", method=RequestMethod.PUT)
	public void updatePrecioAll(@RequestBody Double precio) {
		for(Pelicula pelicula : peliculas){
			pelicula.setPrecio(precio);
		}
		
	}

	@RequestMapping(value="/peliculas/{id}", method=RequestMethod.PUT)
	public void updatePrecioById(@PathVariable Integer id, @RequestBody Double precio) {
		for(Pelicula pelicula : peliculas){
			if(pelicula.getId() == id) {
				pelicula.setPrecio(precio);
			}
		}
	}

	
	//
	//BORRADO
	//
	@RequestMapping(value="/peliculas", method=RequestMethod.DELETE)
	public void deleteProductosAll() {
		peliculas.clear();
		
	}

	@RequestMapping(value="/peliculas/{id}", method=RequestMethod.DELETE)
	public void deleteProductoById(@PathVariable Integer id) {

		Iterator<Pelicula> peliculasIterator = peliculas.iterator();
		
		while(peliculasIterator.hasNext()) {
			Pelicula pelicula = peliculasIterator.next();
			if(pelicula.getId() == id) {
				peliculasIterator.remove();
			}
		}
		
	}
}
