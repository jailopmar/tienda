package com.miempresa.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.tienda.model.Cliente;
import com.miempresa.tienda.model.Pedido;
import com.miempresa.tienda.repository.ClienteRepository;
import com.miempresa.tienda.repository.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido getPedidoById(Long id) {
		return pedidoRepository.findById(id).orElse(null);
	}

	@Transactional
	public Pedido savePedido(Pedido pedido) {
		Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente())
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

		pedido.setCliente(cliente);
		return pedidoRepository.save(pedido);
	}

	public void deletePedido(Long id) {
		pedidoRepository.deleteById(id);

	}

}
