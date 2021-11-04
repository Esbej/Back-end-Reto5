package com.rentcloud.cloud.app.controllers;

import com.rentcloud.cloud.app.entities.admin;
import com.rentcloud.cloud.app.entities.user;
import com.rentcloud.cloud.app.services.AdminService;
import com.rentcloud.cloud.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//le indicamos que es un controlador, encargado de gestionar las peticiones o HTTP Request, define la URL
@RequestMapping("User")//le damos una URL base, no importa si lleva o no el / antes
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService service;
    /* ******************************************Creamos el CRUD************************************************/
    /* *************************************************Get/Read****************************************/
    //get
    @GetMapping("/all")
    public List<user> getUser(){
        return service.getAll();
    }

    //obtenemos el get con Id, le indicamos que le vamos a pasar un parámetro
    @GetMapping("/{id]")            //pasamos el Id por parámetro a la variable adminId
    public Optional<user> getUser(@PathVariable("id") int userId){
        return service.getUser(userId);
    }
    /* *************************************************Post/Create****************************************/

    //este es el Post
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//para retornar el estado(201)
    public user save(@RequestBody user user){//requiéralo del cuerpo de la consulta
        return service.save(user);
    }
    /* *************************************************Put/Update****************************************/

    //este es el put
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//para retornar el estado(201)
    public user update(@RequestBody user user){//requiéralo del cuerpo de la consulta
        return service.update(user);
    }
    /* *************************************************Delete****************************************/

    //este es el delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//Retorna Status 204
    public boolean delete(@PathVariable("id") int userId){//con @PathVariable le indicamos que le vamos a enviar una variable a través del parámetro

        return service.delete(userId);
    }
}
