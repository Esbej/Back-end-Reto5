package com.rentcloud.cloud.app.controllers;


import com.rentcloud.cloud.app.entities.admin;
import com.rentcloud.cloud.app.entities.login;
import com.rentcloud.cloud.app.services.AdminService;
import com.rentcloud.cloud.app.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Login")
@CrossOrigin(origins = "*")
public class LoginController {
    //Metodos
    @Autowired
    private LoginService service;//creamos objeto de tipo AdminService
    /* ******************************************Creamos el CRUD************************************************/
    /* *************************************************Get/Read****************************************/
    //get
    @GetMapping("/all")
    public List<login> getLogin(){
        return service.getAll();
    }

    //obtenemos el get con Id, le indicamos que le vamos a pasar un parámetro
    @GetMapping("/{id]")            //pasamos el Id por parámetro a la variable adminId
    public Optional<login> getLogin(@PathVariable("id") int loginId){
        return service.getLogin(loginId);
    }
    /* *************************************************Post/Create****************************************/

    //este es el Post
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)//para retornar el estado(201)
    public login save(@RequestBody login login){//requiéralo del cuerpo de la consulta
        return service.save(login);
    }
    /* *************************************************Put/Update****************************************/

    //este es el put
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)//para retornar el estado(201)
    public login update(@RequestBody login login){//requiéralo del cuerpo de la consulta
        return service.update(login);
    }
    /* *************************************************Delete****************************************/

    //este es el delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//Retorna Status 204
    public boolean delete(@PathVariable("id") int usuarioId){//con @PathVariable le indicamos que le vamos a enviar una variable a través del parámetro

        return service.delete(usuarioId);
    }
}
