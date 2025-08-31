package com.restfulbooker.herokuapp.stepDefinitions.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.actors.OnStage.*;

import com.restfulbooker.herokuapp.enums.Actor;
import com.restfulbooker.herokuapp.enums.Constant;
import com.restfulbooker.herokuapp.utils.FeedData;

public class Hook {

    @Before
    public void setupStage() {
        setTheStage(new OnlineCast());
        theActor(Actor.ACTOR.getNameActor());
        FeedData feedData = new FeedData();
        feedData.extractData(
                Constant.PATH_FILE_EXCEL.getConstat(),
                Constant.NAME_SHEET_EXCEL.getConstat());

    }

}
