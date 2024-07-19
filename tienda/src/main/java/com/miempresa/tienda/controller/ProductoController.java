package com.miempresa.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.tienda.model.Producto;
import com.miempresa.tienda.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> getAllProductos(){
		return productoService.getAllProductos();
	}
	
	@GetMapping("/{id}")
	public Producto getProductoById(@PathVariable Long id) {
		return productoService.getProductoById(id);
	}
	
	@PostMapping
	public Producto createProducto(@RequestBody Producto producto) {
		return productoService.saveProducto(producto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProducto(@PathVariable Long id) {
		
		productoService.deleteProducto(id);
	}
	
	@PutMapping("/{id}/actualizarstock")
	public Producto updateStock(@PathVariable Long id, @RequestBody Producto producto) {
		return productoService.updateProductoStock(id, producto);
	}

}
