package edu.educacionit.primerms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

	List<String> usuarios = new ArrayList<>();
	{
		usuarios.add("Franco");
		usuarios.add("Pablo");
	}
	
	@GetMapping("/usuario")
	public List<String> getUsuarios() {
		System.out.println("IN");
		return usuarios;
	}
	
	@GetMapping("/usuario/{index}")
	public String getUsuario(@PathVariable Integer index) {
		System.out.println("IN");
		return usuarios.get(index);
	}
}
