package com.rentcloud.cloud.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")

public class category implements Serializable {
    //le damos la llave primaria al id de la tabla category
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",length=45)
    private String name;
    @Column(name="description",length=250)
    private String description;

    /* *************************************** Empezamos a dar las relaciones entre tablas ****************************/
//relación uno a muchos, una categoria muchas nubes
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "category")
    //le decimos que al traer la lista de clouds ignore la lista de categorias para evitar redundancia de datos
    @JsonIgnoreProperties("category")
    //creamos una lista de tipo cloud
    private List<cloud> clouds;


}
