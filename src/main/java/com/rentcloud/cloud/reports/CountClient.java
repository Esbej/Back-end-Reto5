package com.rentcloud.cloud.reports;
import com.rentcloud.cloud.app.entities.client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountClient {

    //atributos
    private Long total;
    private client client;
}
