package com.restfulbooker.herokuapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Constant {

    PATH_FILE_EXCEL("src/test/resources/data/DataBooking.xlsx"),
    NAME_SHEET_EXCEL("DataBooking"),
    CONTENT_TYPE_NAME("Content-Type"),
    CONTENT_TYPE_VALUE("application/json"),
    STRUCTURE_POST_BOOKING("src/test/resources/templates/post_booking.json");

    private String constat;

}
