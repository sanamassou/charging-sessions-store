package com.project.chargingschedule.resources;

import com.project.chargingschedule.business.IChargingSessionBusiness;
import com.project.chargingschedule.dto.input.ChargingSessionDTO;
import com.project.chargingschedule.dto.output.ChargingSessionResponse;
import com.project.chargingschedule.exceptions.TechnicalException;
import com.project.chargingschedule.models.ChargingSession;
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
