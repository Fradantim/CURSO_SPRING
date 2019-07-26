package edu.educacionit.primerms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.educacionit.primerms.model.Usuario;

@RestController
public class UsuarioController {

	private static Integer id = 0; 

	private static List<Usuario> usuarios;
	static{
		usuarios = new ArrayList<>();
		usuarios.add(new Usuario(id++, "Franco"));
		usuarios.add(new Usuario(id++, "Pablo"));
	}
	
	@GetMapping("/usuario")
	public List<Usuario> getUsuarios() {
		System.out.println("IN");
		return usuarios;
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable Integer id) {
		System.out.println("IN");
		return usuarios.get(usuarios.indexOf(new Usuario(id, "")));
	}
}
