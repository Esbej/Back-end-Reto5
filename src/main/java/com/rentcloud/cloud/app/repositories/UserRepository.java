package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.admin;
import com.rentcloud.cloud.app.entities.user;
import com.rentcloud.cloud.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;
    /* **********************************Creamos el CRUD *******************************************************************/
    /*Select * from
     * retorna todos los registros*/
    public List<user> getAll(){
        return (List<user>) repository.findAll();//busca todos los registros de la tabla admin
    }

    /*select * from table where ID=id
     * retorna un registro por el id*/
    //devuelve algo opcional devuelve nulo o e valor
    public Optional<user> getUser(int id){
        return repository.findById(id);
    }

    /*Insert y Update
     * actualiza o crea nuevo registro*/
    public  user save(user user){
        return repository.save(user);
    }

    /*delete from table*/
    public void delete(user user){
        repository.delete(user);
    }
}
