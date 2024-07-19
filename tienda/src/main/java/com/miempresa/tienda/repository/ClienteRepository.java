package com.miempresa.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miempresa.tienda.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
