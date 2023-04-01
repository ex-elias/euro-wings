package com.eurowings.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightStatusPage extends AbstractPage {

    private static final String DATE_INPUT_XPATH = "//input[@value='%s']";

    @FindBy(xpath = "//div[contains(@class,'origin')]")
    private WebElement departureButton;

    @FindBy(id = "station-select-198-input")
    private WebElement departureInput;

    @FindBy(xpath = "//div[contains(@class,'destination')]")
    private WebElement destinationButton;

    @FindBy(id = "station-select-199-input")
    private WebElement destinationInput;

    @FindBy(css = "li .o-station-select__new-station-list__label-text")
    private List<WebElement> foundAirports;

    @FindBy(className = "m-form-datepicker")
    private WebElement datePicker;

    @FindBy(css = ".fieldset-form-footer button")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='detail-section'][1]/p[2]")
    private List<WebElement> departureTimes;

    @FindBy(xpath = "//div[@class='detail-section'][2]/p[2]")
    private List<WebElement> arrivalTimes;

    @FindBy(xpath = "//div[@class='o-search-flight-status__card-flight-number']/p")
    private List<WebElement> flightNumbers;

    @FindBy(css = ".o-search-flight-status__display-info h2")
    private WebElement errorMessage;

    public FlightStatusPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectFlightRoute(String departureAirport, String destinationAirport, String date) {
        departureButton.click();
        departureInput.sendKeys(departureAirport);
        foundAirports.get(0).click();
        destinationButton.click();
        destinationInput.sendKeys(destinationAirport);
        foundAirports.get(0).click();
        datePicker.click();
        webDriver.findElement(By.xpath(String.format(DATE_INPUT_XPATH, date))).click();
        submitButton.click();
    }

    public List<List<String>> getFoundFlightRoutes() {
        List<List<String>> foundFlightRoutes = new ArrayList<>();
        for (int i = 0; i < flightNumbers.size(); i++) {
            foundFlightRoutes.add(List.of(departureTimes.get(i).getText(), arrivalTimes.get(i).getText(),
                    flightNumbers.get(i).getText()));
        }
        return foundFlightRoutes;
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
