package com.miempresa.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.tienda.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
