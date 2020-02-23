
package com.project.chargingschedule.business;

import com.project.chargingschedule.models.ChargingSession;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChargingSessionBusiness implements IChargingSessionBusiness {
    private static final int SIXTY_SECONDS = 60 * 1000;
    Map<String, TreeSet<Date>> chargingSessionsMap = new HashMap<>();

    @Override
    public ChargingSession putChargingSession(ChargingSession chargingSession) {
        TreeSet<Date> set = new TreeSet();
        String station = chargingSession.getStation();
        Date time = chargingSession.getTime();

        if(chargingSessionsMap.containsKey(station) )
        {
            set = chargingSessionsMap.get(station);
            set.add(time); // O(log n)
            chargingSessionsMap.put(station,set);
        }else{
            set.add(time);// O(log n)
            chargingSessionsMap.put(station,set);
        }
        return chargingSession;
    }

    @Override
    public int countChargingSessionInLastMinuteByStation(String station) {
         int count = 0;
        long timeNowTimeStamp = System.currentTimeMillis();
        Date timeNow = new Date(timeNowTimeStamp);
        Date timeSixtySecondsAgo = new Date(timeNowTimeStamp- SIXTY_SECONDS);

        if(chargingSessionsMap.containsKey(station) ){
            TreeSet<Date> set = chargingSessionsMap.get(station);

            set= (TreeSet<Date>) set.subSet(timeSixtySecondsAgo, true, timeNow, true);

            count = set.size();
        }
        return count;

    }

}