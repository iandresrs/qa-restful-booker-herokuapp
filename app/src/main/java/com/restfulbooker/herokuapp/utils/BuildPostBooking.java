package com.restfulbooker.herokuapp.utils;

import java.util.HashMap;
import java.util.Map;

import com.restfulbooker.herokuapp.models.BookingDates;

public class BuildPostBooking {

    public static Map<String, Object> withData(String firstname, String lastname, Integer totalprice,
            Boolean depositpaid, BookingDates  bookingDates, String additionalneeds) {

        Map<String, Object> body = new HashMap<>();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("totalprice", totalprice);
        body.put("depositpaid", depositpaid);
        body.put("bookingDates", bookingDates);
        body.put("additionalneeds", additionalneeds);

        return body;

    }

}
