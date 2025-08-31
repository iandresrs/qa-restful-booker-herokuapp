package com.restfulbooker.herokuapp.exeptions;

import com.restfulbooker.herokuapp.enums.Exception;

public class GenerateException extends AssertionError {

    public static final String BOOKING_DATA_NOT_FOUND = Exception.BOOKING_DATA_NOT_FOUND.getExceptionText();
    public static final String JSON_TEMPLATE_READ_ERROR = Exception.JSON_TEMPLATE_READ_ERROR.getExceptionText();
    public static final String STATUS_CODE_ERROR = Exception.STATUS_CODE_ERROR.getExceptionText();

    public GenerateException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenerateException(String message) {
        super(message);
    }

}
