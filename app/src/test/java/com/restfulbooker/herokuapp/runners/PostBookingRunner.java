package com.restfulbooker.herokuapp.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    plugin = "pretty",
    glue = "com.restfulbooker.herokuapp.stepDefinitions",
    features = "src/test/resources/features/post_booking.feature",
    tags = "@PostBooking",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class PostBookingRunner {

}
