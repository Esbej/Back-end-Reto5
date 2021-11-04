package com.rentcloud.cloud.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationStatus {

    private Integer completed;
    private Integer cancelled;
}
