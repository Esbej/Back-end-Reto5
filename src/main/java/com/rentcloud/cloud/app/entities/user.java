package com.rentcloud.cloud.app.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//definimos nuestras entidades
@Table(name="usuario")//definimos a qué tabla hace referencia
public class user implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(length=45)
    private String userName;
    @Column(length=50)
    private String mail;
    @Column(length=50)
    private String password;
    @Column(length=50)
    private String name;
    private Integer idUserType;

    @OneToOne
    //le decimos que al traer la lista de reservas ignore la lista de calificaciones para evitar redundancia de datos
    @JsonIgnoreProperties("user")
    //creamos un objeto de la clase reservation para mostrar la reserva a la que hace referencia esta calificación
    private login login;
}
