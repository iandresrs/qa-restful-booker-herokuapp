package com.restfulbooker.herokuapp.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class HaspDataBooking {

    public static Map<String, Booking> dataBookingExcel = new LinkedHashMap<>();

    public Map<String, Booking> getDataBookingExcel() {
        return dataBookingExcel;
    }

}
