package com.rentcloud.cloud.app.repositories;

import com.rentcloud.cloud.app.entities.client;
import com.rentcloud.cloud.app.entities.reservation;
import com.rentcloud.cloud.app.repositories.crud.ReservationCrudRepository;
import com.rentcloud.cloud.reports.CountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired /*acá es como crear un objeto del interface ReservationCrudRepository
    la cual usaremos para la conexión a la base de datos*/
    private ReservationCrudRepository repository;


    /* **********************************Creamos el CRUD *******************************************************************/

    /*Select * from
     * retorna todos los registros*/
    public List<reservation> getAll(){
        return (List<reservation>) repository.findAll();//busca todos los registros de la tabla admin
    }
    /*select * from table where ID=id
     * retorna un registro por el id*/
    //devuelve algo opcional devuelve nulo o e valor
    public Optional<reservation> getReservation(int id){
        return repository.findById(id);
    }

    /*Insert y Update
     * actualiza o crea nuevo registro*/
    public  reservation save(reservation reservation){
        return repository.save(reservation);
    }

    /*delete from table*/
    public void delete(reservation reservation){
        repository.delete(reservation);
    }

    public List<reservation>getReservationByStatus(String status){
        return repository.findAllByStatus(status);
    }
    public List<reservation>getReservationPeriod(Date dateOne, Date dateTwo){
        return repository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    public List<CountClient>getTopClients(){
        List<CountClient>clientList=new ArrayList<>();
        List<Object[]>report=repository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            clientList.add(new CountClient((Long)report.get(i)[1],(client)report.get(i)[0]));
        }
        return clientList;
    }
}
