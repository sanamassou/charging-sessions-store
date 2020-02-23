package com.evbox.chargingschedule.helpers;

import com.evbox.chargingschedule.exceptions.ExceptionsEnum;
import com.evbox.chargingschedule.exceptions.TechnicalException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterHelper {

    public static Date getDateFromString(String time) throws TechnicalException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd'T'HH.mm.ss");
        Date formattedTime = null;
        try {
            formattedTime = sdf.parse(time);
        } catch (ParseException e) {
            throw new TechnicalException(ExceptionsEnum.BAD_DATE_FORMAT_ERROR_CODE.getLabel()
                    , ExceptionsEnum.BAD_DATE_FORMAT_ERROR_MESSAGE.getLabel());
        }
        return formattedTime;
    }

    public static String getCurrentDateAsString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd'T'HH.mm.ss");
        return sdf.format(new Date());
    }
}
