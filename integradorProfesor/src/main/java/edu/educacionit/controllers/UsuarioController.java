package edu.educacionit.controllers;

import edu.educacionit.components.CreadorUsuarios;
import edu.educacionit.model.Usuario;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private CreadorUsuarios creadorUsuarios;
    
    @RequestMapping(value = "/diez", method = RequestMethod.GET)
    public List<Usuario> todos() {
        return creadorUsuarios.crearUsuarios(10);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario soloUno(@PathVariable("id") String id) {
        return creadorUsuarios.crearUsuarios(1).get(0);
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> buscarNombre(@RequestParam String nombre) {
        return creadorUsuarios.crearUsuarios(1000)
                .stream()
                .filter( z -> z.getNombreUsuario().startsWith(nombre))
                .collect(Collectors.toList());
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity modificar(
            @PathVariable("id") String id,
            @RequestBody Usuario usuario) {
        
        return new ResponseEntity<>("Recibi: " + usuario.getNombreUsuario(), HttpStatus.NOT_MODIFIED);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> insertar(@RequestBody Usuario usuario) {
        // Falta implementacion en base de datos
        return new ResponseEntity<>("Recibi: " + usuario.getNombreUsuario(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String borrar(@PathVariable String id) {
        throw new RuntimeException("No se puede borrar aun");
    }
}
