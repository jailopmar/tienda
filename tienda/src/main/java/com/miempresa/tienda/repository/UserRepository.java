package com.miempresa.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miempresa.tienda.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
