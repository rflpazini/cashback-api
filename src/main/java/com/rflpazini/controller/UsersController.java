package com.rflpazini.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rflpazini.model.Users;
import com.rflpazini.service.UserService;

@RestController
public class UsersController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Users> getUsers() {
		List<Users> listOfUsers = userService.getAllUsers();
		return listOfUsers;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Users getUserById(@PathVariable("id") int id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "/users/cpf/{cpf}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Users getUserByCpf(@PathVariable String cpf) {
		return userService.getUserByCpf(cpf);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> addUser(@RequestBody Users user) {
		 return userService.addUser(user);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateUser(@RequestBody Users user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}

}
