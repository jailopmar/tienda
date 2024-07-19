package com.miempresa.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.tienda.model.Producto;
import com.miempresa.tienda.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}

	public Producto getProductoById(Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	public void deleteProducto(Long id) {

		productoRepository.deleteById(id);
	}
	
	public Producto updateProductoStock(Long id, Producto producto) {
		Optional<Producto> existingProducto = productoRepository.findById(id);
		if(existingProducto.isPresent()) {
			Producto updatedProducto = existingProducto.get();
			updatedProducto.setStock(producto.getStock());
			return productoRepository.save(updatedProducto);
		}else {
			throw new RuntimeException("Producto not found with this id: " + id);
		}
	}

}
