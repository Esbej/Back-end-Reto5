package com.rentcloud.cloud.app.services;

import com.rentcloud.cloud.app.entities.admin;
import com.rentcloud.cloud.app.entities.user;
import com.rentcloud.cloud.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    /* ******************************************Creamos el CRUD************************************************/
    /* *************************************************Get/Read****************************************/
    /*Este sería el Get y nos retorna una lista de administradores*/
    public List<user> getAll(){
        return repository.getAll();
    }


    /*Este sería el Get con Id*/
    public Optional<user> getUser(int userId){
        return repository.getUser(userId);
    }
    /* *************************************************post/Create****************************************/

    /*sería el Post*/
    public user save(user user){
        //consulta si no se envía el Id
        if(user.getIdUser()==null){
            return repository.save(user);
        }else{//si envian el Id
            //consulta si existe el registro enviado creando un objeto de la clase Opcional de java.util
            Optional<user> existUser = repository.getUser(user.getIdUser());
            //si los datos ya existen retorne los datos enviados
            if(existUser.isPresent()){
                return user;//acá debería retornar una respuesta indicando que ya existe el dato
            }else{
                //si no existe regístrelo
                return repository.save(user);
            }
        }
    }
    /* *************************************************Put/Update****************************************/
    public user update(user user){
        //si el Id no es null, es decir si enviaron el Id
        if(user.getIdUser()!=null){
            //obtener el admin por id,creamos un objeto de la clase Optional de java.util
            Optional<user> existUser= repository.getUser(user.getIdUser());
            //si el admin existe
            if(existUser.isPresent()){
                //si el campo nombre no es null, reemplazar con los datos enviados
                if(user.getUserName()!=null){
                    existUser.get().setUserName(user.getUserName());
                }
                //si el campo email no es null, reemplazar con los datos enviados
                if(user.getMail()!=null){
                    existUser.get().setMail(user.getMail());
                }
                //si el campo password no es null, reemplazar con los datos enviados
                if(user.getPassword()!=null){
                    existUser.get().setPassword(user.getPassword());
                }
                if(user.getName()!=null){
                    existUser.get().setName(user.getName());
                }
                if(user.getIdUserType()!=null){
                    existUser.get().setIdUserType(user.getIdUserType());
                }
                //retorne los datos con el update implementado
                return repository.save(existUser.get());

            }else{//si el admin no existe retorne los datos enviados,se debería enviar una notificación que los datos no existen
                return user;
            }

        }else{//si no se envío el Id retorne los datos enviados
            return user;
        }
    }
    /* *************************************************Delete****************************************/


    /*este sería el Delete*/
    public boolean delete(int userId){
        //si obtiene el id, lo borramos y retornamos true
        return getUser(userId).map(user->{
            repository.delete(user);//ejecutamos una función anónima para eliminarlo y retornamos true
            return true;
        }).orElse(false);//si no obtiene el id retorna false

        //si obtiene Id, los mapea a una variable
        /* boolean respuesta=getAdmin(adminId).map(admin->{
          repository.delete(admin);//ejecutamos una función anónima para eliminarlo y retornamos true
          return true;
       }).orElse(false);//ni no lo elimina devuelve un false
        return respuesta;
    }*/
    }
}
