package com.evbox.chargingschedule.models;

import java.util.Date;

import com.evbox.chargingschedule.dto.input.ChargingSessionDTO;
import com.evbox.chargingschedule.exceptions.TechnicalException;
import com.evbox.chargingschedule.helpers.DateFormatterHelper;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChargingSession {
    private Date time;
    private String station;

    public static ChargingSession fromDTO(ChargingSessionDTO chargingSessionDTO) throws TechnicalException {
        return new ChargingSession(DateFormatterHelper.getDateFromString(chargingSessionDTO.getTime()), chargingSessionDTO.getStation());
    }
}
