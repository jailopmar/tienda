package com.miempresa.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.tienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
