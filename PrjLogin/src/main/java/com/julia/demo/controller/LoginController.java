package com.julia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.julia.demo.entities.Usuario;
import com.julia.demo.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	private LoginService loginservice;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody Usuario usuario){
		boolean isValid = loginservice.validarLogin(usuario);
		if(isValid) {
			return ResponseEntity.ok("Login bem sucedido");
		}else {
			return ResponseEntity.status(401).body("credenciais invalidas");
		}
	}
}
