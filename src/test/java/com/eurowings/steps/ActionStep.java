package com.eurowings.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open site: {url}")
    public void openSite(String url) {
        flightStatusPage.openSite(url);
        flightStatusPage.acceptCookie();

    }

    @Step("Select flight route: {departureAirport}, {destinationAirport}, {date}")
    public void selectFlightRoute(String departureAirport, String destinationAirport, String date) {
        flightStatusPage.selectFlightRoute(departureAirport, destinationAirport, date);
    }
}
