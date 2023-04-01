package com.eurowings.steps;

import com.eurowings.pages.FlightStatusPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected FlightStatusPage flightStatusPage;

    protected AbstractStep(WebDriver webDriver) {
        flightStatusPage = new FlightStatusPage(webDriver);
    }
}
