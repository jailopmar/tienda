package com.miempresa.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.tienda.model.Cliente;
import com.miempresa.tienda.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();

	}

	public Cliente getClienteById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);

	}

	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente updateClientePassword(Long id, Cliente cliente) {
		Optional<Cliente> existingCliente = clienteRepository.findById(id);
		if (existingCliente.isPresent()) {
			Cliente updatedCliente = existingCliente.get();
			updatedCliente.setPassword(cliente.getPassword());
			return clienteRepository.save(updatedCliente);
		} else {
			throw new RuntimeException("User not found with this id: " + id);
		}
	}

	public Cliente updateClienteEmail(Long id, Cliente cliente) {
		Optional<Cliente> existingCliente = clienteRepository.findById(id);
		if (existingCliente.isPresent()) {
			Cliente updatedCliente = existingCliente.get();
			updatedCliente.setEmail(cliente.getEmail());
			return clienteRepository.save(updatedCliente);
		} else {
			throw new RuntimeException("User not found with this id: " + id);
		}
	}

}
