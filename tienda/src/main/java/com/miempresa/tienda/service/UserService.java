package com.miempresa.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.tienda.model.User;
import com.miempresa.tienda.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() { // Obtener todos los usuarios
		return userRepository.findAll();
	}

	public User getUserById(Long id) { // Obtener Usuario por Id
		return userRepository.findById(id).orElse(null);
	}

	public User saveUser(User user) { // Guardar un usuario (POST)

		return userRepository.save(user);

	}

	public void deleteUser(Long id) {

		userRepository.deleteById(id);
	}

	//Actualizar Usuario
	public User updateUserUsuario(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updateduser = existingUser.get();
			updateduser.setUsuario(user.getUsuario());
			return userRepository.save(updateduser);
		} else {
			throw new RuntimeException("User not found with this id: " + id);
		}
	}

	//Actualizar Password
	public User updateUserPassword(Long id, User user) {
		Optional<User> existingUser = userRepository.findById(id);
		if (existingUser.isPresent()) {
			User updateduser = existingUser.get();
			updateduser.setPassword(user.getPassword());
			return userRepository.save(updateduser);
		} else {
			throw new RuntimeException("User not found with this id: " + id);
		}
	}

}
