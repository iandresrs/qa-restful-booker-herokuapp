package com.restfulbooker.herokuapp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class BookingDates {

    private String checkin;
    private String checkout;
    
}
