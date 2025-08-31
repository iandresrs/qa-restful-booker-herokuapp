package com.restfulbooker.herokuapp.tasks;

import java.util.Map;

import com.restfulbooker.herokuapp.enums.Constant;
import com.restfulbooker.herokuapp.exeptions.GenerateException;
import com.restfulbooker.herokuapp.models.HaspDataBooking;
import com.restfulbooker.herokuapp.utils.BookingRequestBuilder;
import com.restfulbooker.herokuapp.utils.ReadConfiguration;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class CreateNewBookingTask implements Task {

    private String booking;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = buildBodyFromData();

        actor.attemptsTo(
                Post.to(ReadConfiguration.getEndpoint("post_booking"))
                        .with(
                                rq -> rq
                                        .headers(contentTypeHeader())
                                        .relaxedHTTPSValidation()
                                        .body(body)));
    }

    private static Map<String, Object> contentTypeHeader() {
        return Map.of(
                Constant.CONTENT_TYPE_NAME.getConstat(),
                Constant.CONTENT_TYPE_VALUE.getConstat());
    }

    private String buildBodyFromData() {
        var dataBooking = HaspDataBooking.dataBookingExcel.get(booking);

        if (dataBooking == null)
            throw new IllegalArgumentException(GenerateException.BOOKING_DATA_NOT_FOUND);

        return new BookingRequestBuilder()
                .withFirstName(dataBooking.getFirstname())
                .withLastName(dataBooking.getLastname())
                .withTotalPrice(dataBooking.getTotalprice())
                .withDepositpaid(dataBooking.getDepositpaid())
                .withBookingDate(dataBooking.getBookingdates())
                .withAdditionalneeds(dataBooking.getAdditionalneeds())
                .build();
    }

    public static CreateNewBookingTask withDataBooking(HaspDataBooking data, String booking) {
        return instrumented(CreateNewBookingTask.class, data, booking);
    }

}
