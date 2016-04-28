import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import model.Libro;

import org.junit.Test;

import controller.LibrosController;
import data.Repository;


public class TestLibros {
	
	LibrosController librosController;
	
	public TestLibros() {
		librosController = new LibrosController();
	}

	
	@Test
	public void testGetAllLibros() {
		int initSize = Repository.lista_libros.size();
		
		List<Libro> libros = librosController.getAllProductos();
		
		assertEquals(initSize, libros.size());
	}
	
	@Test
	public void testGetLibroById() {
		Integer id = 100;
		
		librosController.addProducto(id, "titulo100", "autor100", 100.0);
		
		Libro libro = librosController.getProductoById(id);
		
		assertNotNull(libro);
		
	}
	
	@Test
	public void testGetLibrosByTitulo() {
		librosController.addProducto(99, "titulo99", "autor99", 99.0);
		
		List<Libro> libros = librosController.getProductosByParams("titulo99", "");
		
		assertFalse(libros.size() == 0);
	}
	
	@Test
	public void testGetLibrosByAutor() {
		librosController.addProducto(98, "titulo98", "autor98", 98.0);
		
		List<Libro> libros = librosController.getProductosByParams("", "autor98");
		
		assertFalse(libros.size() == 0);
	}
	
	@Test
	public void testGetLibrosByTituloAndAutor() {
		librosController.addProducto(97, "titulo97", "autor97", 97.0);
		
		List<Libro> libros = librosController.getProductosByParams("titulo97", "autor97");
		
		assertFalse(libros.size() == 0);
	}
	
	@Test
	public void testAddLibro() {
		
		librosController.addProducto(96, "titulo96", "autor96", 96.0);
		
		assertNotNull(librosController.getProductoById(96));
		
	}
	
	@Test
	public void testUpdatePrecioById() {
		
		librosController.addProducto(95, "titulo95", "autor95", 95.0);
		
		librosController.updatePrecioById(95, 0.0);
		
		Libro libro = librosController.getProductoById(95);
		
		assertEquals(0.0, libro.getPrecio(), 0);
	}
	
	@Test
	public void testUpdatePrecioAll() {
		librosController.addProducto(94, "titulo94", "autor94", 94.0);
		librosController.addProducto(93, "titulo93", "autor93", 93.0);
		
		librosController.updatePrecioAll(100.0);
		
		List<Libro> libros = librosController.getAllProductos();
		
		for(Libro libro : libros) {
			if(libro.getPrecio() != 100.0) {
				fail();
			}
		}
	}
	
	@Test
	public void testDeleteById() {
		
		librosController.addProducto(92, "titulo92", "autor92", 92.0);
		
		librosController.deleteProductoById(92);
		
		assertNull(librosController.getProductoById(92));
	}
	
	@Test
	public void testDeleteAll() {
		librosController.addProducto(91, "titulo91", "autor91", 91.0);
				
		librosController.deleteProductosAll();
		
		assertEquals(0,  Repository.lista_libros.size());
	}
}
