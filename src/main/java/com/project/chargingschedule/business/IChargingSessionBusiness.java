package com.project.chargingschedule.business;

import com.project.chargingschedule.models.ChargingSession;

public interface IChargingSessionBusiness {

    ChargingSession putChargingSession(ChargingSession chargingSession);

    int countChargingSessionInLastMinuteByStation(String station);
}
