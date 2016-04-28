package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.Repository;
import model.Disco;
import model.Libro;

@RestController
public class DiscosController implements ProductosManager<Disco>{
	
	private static List<Disco> discos = Repository.lista_discos;

	//
	//CONSULTA DE DATOS
	//
	@RequestMapping(value = "/discos", method = RequestMethod.GET)
	public List<Disco> getAllProductos() {
		return discos;
	}
	
	@RequestMapping(value="/discos/{id}", method=RequestMethod.GET)
	public Disco getProductoById(@PathVariable Integer id) {
		for(Disco disco : discos) {
			if(disco.getId() == id) {
				return disco;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/discos/", method = RequestMethod.GET)
	public List<Disco> getProductosByParams(@RequestParam(value="titulo", required=false, defaultValue = "") String titulo, 
											@RequestParam(value="artista", required=false, defaultValue="") String artista) {
		
		List<Disco> resultado = new ArrayList<Disco>();
		
		for(Disco disco : discos) {
			if(!titulo.equals("")) {
				if(!artista.equals("")) {
					if(disco.getTitulo().equals(titulo) && disco.getArtista().equals(artista)) {
						resultado.add(disco);
					}
				} else {
					if(disco.getTitulo().equals(titulo)) {
						resultado.add(disco);
					}
				}
			} else {
				if (disco.getArtista().equals(artista)) {
					resultado.add(disco);
				}
			}
			
		}

		return resultado;
	}

	//
	//CREACION
	//
	@RequestMapping(value="/discos", method = RequestMethod.POST)
	public void addProducto(@RequestBody Integer id, String titulo, String artista, Double precio) {
		Disco disco = new Disco(id, titulo, artista, precio);
		discos.add(disco);
	}
	
	
	//
	//MODIFICACION DE DATOS
	//
	@RequestMapping(value="/discos", method=RequestMethod.PUT)
	public void updatePrecioAll(@RequestBody Double precio) {
		for(Disco disco : discos) {
			disco.setPrecio(precio);
		}
	}
	
	@RequestMapping(value="/discos/{id}", method=RequestMethod.PUT)
	public void updatePrecioById(@PathVariable Integer id, @RequestBody Double precio) {
		for(Disco disco : discos) {
			if(disco.getId() == id) {
				disco.setPrecio(precio);
			}			
		}
	}
	
	//
	//BORRADO
	//
	@RequestMapping(value="/discos", method=RequestMethod.DELETE)
	public void deleteProductosAll() {
		discos.clear();
	}
	
	@RequestMapping(value="/discos/{id}", method=RequestMethod.DELETE)
	public void deleteProductoById(@PathVariable Integer id) {
		
		Iterator<Disco> discosIterator = discos.iterator();
		
		while(discosIterator.hasNext()) {
			Disco disco = discosIterator.next();
			if(disco.getId() == id) {
				discosIterator.remove();
			}
		}
	}
}
