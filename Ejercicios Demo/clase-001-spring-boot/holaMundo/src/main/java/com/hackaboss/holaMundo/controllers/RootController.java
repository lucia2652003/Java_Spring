package com.hackaboss.holaMundo.controllers;

import com.hackaboss.holaMundo.entities.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RootController {

    @GetMapping                             //endpoint de bienvenida
    public String bienvenida(){
        return "Mensaje de Bienvenida!!!";
    }

    @GetMapping("/saludo")           //endpoint de saludo
    public String saludo(){
        return "Hola a todos";
    }

    @GetMapping("/usuario")
    public Usuario retornarUsuario(){
        return  new Usuario(1L, "Brian","Gomez");
    }

    @GetMapping("/listaUsuarios")
    public List<Usuario> listaUsuarios(){
        List<Usuario> listado = new ArrayList<>();
        listado.add(new Usuario(1L, "Brian","Gomez"));
        listado.add(new Usuario(2L, "Carlos","Andrade"));
        return listado;
    }
}
