package edu.educacionit.primerms.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    @ResponseBody
    @RequestMapping(value="/usuario", method=RequestMethod.GET)
    public Object get() {
        return "ACA DEBE RETORNAR EL USUARIO";
    }
}
