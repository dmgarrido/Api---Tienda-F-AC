package controller;

import java.util.List;

public interface ProductosManager<Producto> {

	List<Producto> getAllProductos();
	
	List<Producto> getProductosByParams(String titulo, String param);

	Producto getProductoById(Integer id);
	
	void addProducto(Integer id, String titulo, String param, Double precio);
	
	void updatePrecioAll(Double precio);
	
	void updatePrecioById(Integer id, Double precio);
	
	void deleteProductosAll();
	
	void deleteProductoById(Integer id);
}
