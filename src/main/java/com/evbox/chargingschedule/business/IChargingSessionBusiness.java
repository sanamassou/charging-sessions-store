package com.evbox.chargingschedule.business;

import com.evbox.chargingschedule.models.ChargingSession;

public interface IChargingSessionBusiness {

    ChargingSession putChargingSession(ChargingSession chargingSession);

    int countChargingSessionInLastMinuteByStation(String station);
}
