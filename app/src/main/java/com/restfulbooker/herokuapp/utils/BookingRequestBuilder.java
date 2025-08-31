package com.restfulbooker.herokuapp.utils;

import java.util.Map;

import com.restfulbooker.herokuapp.enums.Constant;
import com.restfulbooker.herokuapp.models.BookingDates;

public class BookingRequestBuilder {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingDate;
    private String additionalneeds;

    public BookingRequestBuilder withFirstName(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public BookingRequestBuilder withLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public BookingRequestBuilder withDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public BookingRequestBuilder withTotalPrice(Integer totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BookingRequestBuilder withBookingDate(BookingDates bookingDate) {
        this.bookingDate = bookingDate;
        return this;
    }

    public BookingRequestBuilder withAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }

    public String build() {
        String bookingDatesJson = String.format(
                "{ \"checkin\": \"%s\", \"checkout\": \"%s\" }",
                bookingDate.getCheckin(),
                bookingDate.getCheckout());

        return BuildBody.withTemplate(Constant.STRUCTURE_POST_BOOKING.getConstat())
                .withValueNew(Map.of(
                        "firstname", firstname,
                        "lastname", lastname,
                        "totalprice", totalprice,
                        "depositpaid", depositpaid,
                        "bookingdates", bookingDatesJson,
                        "additionalneeds", additionalneeds));
    }

}
