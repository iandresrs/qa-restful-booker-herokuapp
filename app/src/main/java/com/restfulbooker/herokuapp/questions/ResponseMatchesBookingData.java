package com.restfulbooker.herokuapp.questions;

import org.assertj.core.api.SoftAssertions;

import com.restfulbooker.herokuapp.models.Booking;
import lombok.AllArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class ResponseMatchesBookingData implements Question<Boolean> {

    private final Booking expectedData;

    @Override
    public Boolean answeredBy(Actor actor) {

        Booking actualData = SerenityRest.lastResponse()
                .jsonPath()
                .getObject("booking", Booking.class);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(actualData.getFirstname()).isEqualTo(expectedData.getFirstname());
        softly.assertThat(actualData.getLastname()).isEqualTo(expectedData.getLastname());
        softly.assertThat(actualData.getTotalprice()).isEqualTo(expectedData.getTotalprice());
        softly.assertThat(actualData.getDepositpaid()).isEqualTo(expectedData.getDepositpaid());
        softly.assertThat(actualData.getBookingdates().getCheckin())
                .isEqualTo(expectedData.getBookingdates().getCheckin());
        softly.assertThat(actualData.getBookingdates().getCheckout())
                .isEqualTo(expectedData.getBookingdates().getCheckout());
        softly.assertThat(actualData.getAdditionalneeds())
                .isEqualTo(expectedData.getAdditionalneeds());

        
        return softly.errorsCollected().isEmpty();
    }

    public static ResponseMatchesBookingData from(Booking data) {
        return new ResponseMatchesBookingData(data);
    }

}
