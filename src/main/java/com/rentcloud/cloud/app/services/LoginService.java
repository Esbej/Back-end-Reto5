package com.rentcloud.cloud.app.services;
import com.rentcloud.cloud.app.entities.login;
import com.rentcloud.cloud.app.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired//le inyectamos las dependencias
    private LoginRepository repository;

    /* ******************************************Creamos el CRUD************************************************/
    /* *************************************************Get/Read****************************************/
    /*Este sería el Get y nos retorna una lista de administradores*/
    public List<login> getAll(){
        return repository.getAll();
    }


    /*Este sería el Get con Id*/
    public Optional<login> getLogin(int loginId){
        return repository.getLogin(loginId);
    }

    /* *************************************************post/Create****************************************/

    /*sería el Post*/
    public login save(login login){
        //consulta si no se envía el Id
        if(login.getId()==null){
            return repository.save(login);
        }else{//si envian el Id
            //consulta si existe el registro enviado creando un objeto de la clase Opcional de java.util
            Optional<login> existLogin = repository.getLogin(login.getId());
            //si los datos ya existen retorne los datos enviados
            if(existLogin.isPresent()){
                return login;//acá debería retornar una respuesta indicando que ya existe el dato
            }else{
                //si no existe regístrelo
                return repository.save(login);
            }
        }
    }
    /* *************************************************Put/Update****************************************/
    public login update(login login){
        //si el Id no es null, es decir si enviaron el Id
        if(login.getId()!=null){
            //obtener el admin por id,creamos un objeto de la clase Optional de java.util
            Optional<login> existLogin= repository.getLogin(login.getId());
            //si el admin existe
            if(existLogin.isPresent()){
                //si el campo nombre no es null, reemplazar con los datos enviados
                if(login.getName()!=null){
                    existLogin.get().setName(login.getName());
                }
                //si el campo email no es null, reemplazar con los datos enviados
                if(login.getId()!=null){
                    existLogin.get().setId(login.getId());
                }

                //retorne los datos con el update implementado
                return repository.save(existLogin.get());

            }else{//si el admin no existe retorne los datos enviados,se debería enviar una notificación que los datos no existen
                return login;
            }

        }else{//si no se envío el Id retorne los datos enviados
            return login;
        }
    }
    /* *************************************************Delete****************************************/


    /*este sería el Delete*/
    public boolean delete(int loginId){
        //si obtiene el id, lo borramos y retornamos true
        return getLogin(loginId).map(login->{
            repository.delete(login);//ejecutamos una función anónima para eliminarlo y retornamos true
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
