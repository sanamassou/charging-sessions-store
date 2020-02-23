package com.evbox.chargingschedule.resources;

import com.evbox.chargingschedule.business.IChargingSessionBusiness;
import com.evbox.chargingschedule.dto.input.ChargingSessionDTO;
import com.evbox.chargingschedule.dto.output.ChargingSessionResponse;
import com.evbox.chargingschedule.exceptions.TechnicalException;
import com.evbox.chargingschedule.models.ChargingSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChargingSessionResource {


    @Autowired
    IChargingSessionBusiness chargingSessionBusiness;

    @PutMapping("/chargingSession")
    public void putChargingSession(@RequestBody ChargingSessionDTO chargingSession) throws TechnicalException {
        chargingSessionBusiness.putChargingSession(ChargingSession.fromDTO(chargingSession));
    }

    @GetMapping("/summary")
    public ChargingSessionResponse countChargingSessionInLastMinuteByStation(@RequestParam String station) {
        return new ChargingSessionResponse(chargingSessionBusiness.countChargingSessionInLastMinuteByStation(station));
    }
}
