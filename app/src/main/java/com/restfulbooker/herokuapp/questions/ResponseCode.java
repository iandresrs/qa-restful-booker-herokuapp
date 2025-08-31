package com.restfulbooker.herokuapp.questions;

import com.restfulbooker.herokuapp.exeptions.GenerateException;

import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ResponseCode implements Question<Boolean> {

    private Integer expectedCode;

    @Override
    public Boolean answeredBy(Actor actor) {
        Integer realCode = SerenityRest.lastResponse().getStatusCode();
        
        if (!expectedCode.equals(realCode))
            throw new GenerateException(GenerateException.STATUS_CODE_ERROR);

        return true;
    }

    public static ResponseCode code(Integer statusCode) {
        return new ResponseCode(statusCode);
    }

}
