package com.restfulbooker.herokuapp.stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.restfulbooker.herokuapp.models.Booking;
import com.restfulbooker.herokuapp.models.HaspDataBooking;
import com.restfulbooker.herokuapp.questions.ResponseCode;
import com.restfulbooker.herokuapp.questions.ResponseMatchesBookingData;
import com.restfulbooker.herokuapp.tasks.CreateNewBookingTask;
import com.restfulbooker.herokuapp.utils.ReadConfiguration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PostBookingStepDefinition {

    HaspDataBooking data = new HaspDataBooking();

    @Given("I can consume the booking service")
    public void iCanConsumeTheBookingService() {
        theActorInTheSpotlight().whoCan(
                CallAnApi.at(ReadConfiguration.getUrl("baseurl")));
    }

    @When("i validate the booking {string} information")
    public void iValidateTheBookingInformation(String booking) {
        theActorInTheSpotlight().attemptsTo(
                CreateNewBookingTask.withDataBooking(data, booking));
    }

    @Then("the service responds with status code {int}")
    public void theServiceRespondsWithStatusCode(Integer code) {
        theActorInTheSpotlight().should(
                seeThat(ResponseCode.code(code)));
    }

    @And("the response contains the booking data provided from the data source {string}")
    public void theResponseContainsTheBookingDataProvidedFromTheDataSource(String key) {
        Booking expectedData = data.getDataBookingExcel().get(key);
        theActorInTheSpotlight().should(
            seeThat(ResponseMatchesBookingData.from(expectedData), is(true))
        );
    }

}
