package com.eurowings.steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Assert browser title: {browserTitle}")
    public void assertBrowserTitle(String browserTitle) {
        assertThat(flightStatusPage.getTitle()).as("Browser title is incorrect").isEqualTo(browserTitle);
    }

    @Step("Assert found flight routes")
    public void assertFoundFlightRoutes(List<List<String>> flightRoutes) {
        assertThat(flightStatusPage.getFoundFlightRoutes()).as("Flight routes are found incorrectly")
                .isEqualTo(flightRoutes);
    }

    @Step("Assert error message: {errorMessage}")
    public void assertErrorMessage(String errorMessage) {
        assertThat(flightStatusPage.getErrorMessage()).as("Error message is incorrect").isEqualTo(errorMessage);
    }
}
