package com.miempresa.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miempresa.tienda.model.Pedido;
import com.miempresa.tienda.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> getAllPedidos(){
		
		return pedidoService.getAllPedidos();
	}
	
	@GetMapping("/{id}")
	public Pedido getPedidoById(@PathVariable Long id) {
		return pedidoService.getPedidoById(id);
	}
	
	@PostMapping
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidoService.savePedido(pedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@PathVariable Long id) {
		pedidoService.deletePedido(id);
	}
	
	

}
