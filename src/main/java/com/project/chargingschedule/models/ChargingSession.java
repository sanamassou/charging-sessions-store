package com.project.chargingschedule.models;

import java.util.Date;

import com.project.chargingschedule.dto.input.ChargingSessionDTO;
import com.project.chargingschedule.exceptions.TechnicalException;
import com.project.chargingschedule.helpers.DateFormatterHelper;
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
