package com.evbox.chargingschedule.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum ExceptionsEnum {
    BAD_DATE_FORMAT_ERROR_CODE("T0001"),
    BAD_DATE_FORMAT_ERROR_MESSAGE("time must be a string formatted as : \"yyyy.MM.dd'T'HH.mm.ss\"\n");

    @Getter
    private final String label;

}
