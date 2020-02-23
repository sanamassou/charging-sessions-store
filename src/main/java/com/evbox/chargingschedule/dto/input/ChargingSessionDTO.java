package com.evbox.chargingschedule.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargingSessionDTO {
    private String time;
    private String station;

}
