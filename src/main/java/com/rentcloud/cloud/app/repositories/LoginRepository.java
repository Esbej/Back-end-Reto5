package com.rentcloud.cloud.app.repositories;
import com.rentcloud.cloud.app.entities.admin;
import com.rentcloud.cloud.app.entities.login;
import com.rentcloud.cloud.app.repositories.crud.LoginCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LoginRepository {

    @Autowired
    private LoginCrudRepository repository;

    /* **********************************Creamos el CRUD *******************************************************************/
    /*Select * from
     * retorna todos los registros*/
    public List<login> getAll(){
        return (List<login>) repository.findAll();//busca todos los registros de la tabla admin
    }

    /*select * from table where ID=id
     * retorna un registro por el id*/
    //devuelve algo opcional devuelve nulo o e valor
    public Optional<login> getLogin(int id){
        return repository.findById(id);
    }

    /*Insert y Update
     * actualiza o crea nuevo registro*/
    public  login save(login login){
        return repository.save(login);
    }

    /*delete from table*/
    public void delete(login login){
        repository.delete(login);
    }
}
