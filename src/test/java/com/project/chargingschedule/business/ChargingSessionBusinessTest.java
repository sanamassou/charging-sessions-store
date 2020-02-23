package com.project.chargingschedule.business;

import com.project.chargingschedule.dto.input.ChargingSessionDTO;
import com.project.chargingschedule.exceptions.TechnicalException;
import com.project.chargingschedule.helpers.DateFormatterHelper;
import com.project.chargingschedule.models.ChargingSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class ChargingSessionBusinessTest {

    @InjectMocks
    ChargingSessionBusiness business;

    @Test
    public void countChargingSessionInLastMinuteByStation_when_time_isExpired_and_station_match() throws TechnicalException {
        ChargingSessionDTO chargingSessionDTO = new ChargingSessionDTO("2019.01.01T15.10.18", " EVB-1");
        business.putChargingSession(ChargingSession.fromDTO(chargingSessionDTO));
        int response = business.countChargingSessionInLastMinuteByStation(chargingSessionDTO.getStation());
        assertEquals(0, response);
    }

    @Test
    public void countChargingSessionInLastMinuteByStation_when_time_not_expired_and_station_match() throws TechnicalException {

        ChargingSessionDTO chargingSessionDTO = new ChargingSessionDTO(DateFormatterHelper.getCurrentDateAsString(), "EVB-1");
        business.putChargingSession(ChargingSession.fromDTO(chargingSessionDTO));
        int response = business.countChargingSessionInLastMinuteByStation(chargingSessionDTO.getStation());
        assertEquals(1, response);
    }

    @Test
    public void countChargingSessionInLastMinuteByStation_when_time_not_expired_and_station_not_match() throws TechnicalException {

        ChargingSessionDTO chargingSessionDTO = new ChargingSessionDTO(DateFormatterHelper.getCurrentDateAsString(), "EVB-1");
        business.putChargingSession(ChargingSession.fromDTO(chargingSessionDTO));
        int response = business.countChargingSessionInLastMinuteByStation("EVB-2");
        assertEquals(0, response);
    }
}