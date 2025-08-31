package com.restfulbooker.herokuapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Exception {

    BOOKING_DATA_NOT_FOUND("Booking data not found for key:"),
    JSON_TEMPLATE_READ_ERROR("Error reading JSON template from path '%s'. \" +\r\n" +
            "                        \"Possible causes: file not found, insufficient permissions, or invalid format.\""),
    STATUS_CODE_ERROR("The service response code is not as expected.");

    private String exceptionText;

}
