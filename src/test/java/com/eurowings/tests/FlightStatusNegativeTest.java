package com.eurowings.tests;

import com.eurowings.dataproviders.FlightStatusDataProvider;
import com.eurowings.utils.RetryAnalyzer;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class FlightStatusNegativeTest extends BaseTest {

    private static final String ERROR_MESSAGE = "Unfortunately, we could not find any results for your search.";

    @Feature("Test functionality of Eurowings site")
    @Story("Test functionality of Flight Status page")
    @Test(dataProvider = "flightRoutesNegativeDataProvider", dataProviderClass = FlightStatusDataProvider.class,
            description = "Verify that error message is shown for non-existent flight routes",
            retryAnalyzer = RetryAnalyzer.class)
    public void findFlightRoutesPositiveTest(String departureAirport, String destinationAirport, String date) {
        actionStep.selectFlightRoute(departureAirport, destinationAirport, date);
        assertStep.assertErrorMessage(ERROR_MESSAGE);
    }
}
