package controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Libro;

@RestController
public class LibrosController {
	
	private ProductosManagerImplLibros librosManager;
	
	public LibrosController() {
		librosManager = new ProductosManagerImplLibros();
	}

	//
	//CONSULTA DE DATOS
	//
	@RequestMapping(value = "/libros", method = RequestMethod.GET)
	public List<Libro> getAllProductos() {
		
		return librosManager.getAllProductos();
		
	}
				
	@RequestMapping(value = "/libros/", method = RequestMethod.GET)
	public List<Libro> getProductosByParams(@RequestParam(value="titulo", required=false, defaultValue="") String titulo, 
											@RequestParam(value="autor", required=false, defaultValue="") String autor) {
		
		return librosManager.getProductosByParams(titulo, autor);

	}

	@RequestMapping(value="/libros/{id}", method=RequestMethod.GET)
	public Libro getProductoById(@PathVariable Integer id) {
		
		return librosManager.getProductoById(id);
		
	}

	
	//
	//CREACION
	//
	@RequestMapping(value="/libros", method = RequestMethod.POST)
	public void addProducto(@RequestBody Integer id, String titulo, String autor, Double precio) {
		
		librosManager.addProducto(id, titulo, autor, precio);

	}

	
	//
	//MODIFICACION DE DATOS
	//
	@RequestMapping(value="/libros", method=RequestMethod.PUT)
	public void updatePrecioAll(@RequestBody Double precio) {
		
		librosManager.updatePrecioAll(precio);
	
	}

	@RequestMapping(value="/libros/{id}", method=RequestMethod.PUT)
	public void updatePrecioById(@PathVariable Integer id, @RequestBody Double precio) {
		
		librosManager.updatePrecioById(id, precio);
	
	}

	
	//
	//BORRADO
	//
	@RequestMapping(value="/libros", method=RequestMethod.DELETE)
	public void deleteProductosAll() {
		
		librosManager.deleteProductosAll();
	}

	@RequestMapping(value="/libros/{id}", method=RequestMethod.DELETE)
	public void deleteProductoById(@PathVariable Integer id) {
		
		librosManager.deleteProductoById(id);

	}

}
