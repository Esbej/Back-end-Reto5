package com.rentcloud.cloud.app.repositories.crud;

import com.rentcloud.cloud.app.entities.reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/*en la interface definimos un modelo pero no lo implementamos, la implementación la hacemos en el Repository*/

public interface ReservationCrudRepository extends CrudRepository<reservation,Integer> {//se hace referencia a la entidad que va a implementar el crud y el tipo de llave primaria Integer
    //post, get, put, delete==create,read,upload,delete

    public List<reservation> findAllByStatus(String status);
    public  List<reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    @Query("SELECT c.client, COUNT(c.client) FROM reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();


}
