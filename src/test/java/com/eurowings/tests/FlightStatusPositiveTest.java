package com.eurowings.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class FlightStatusPositiveTest extends BaseTest {

    @Feature("Test functionality of Eurowings site")
    @Story("Test functionality of Flight Status page")
    @Test(dataProvider = "flightRoutesPositiveDataProvider", dataProviderClass = FlightStatusDataProvider.class,
            description = "Verify that flight routes with different travel dates are shown with the selected dates")
    public void findFlightRoutesPositiveTest(String departureAirport, String destinationAirport, String date,
                                             List<List<String>> flightRoutes) {
        actionStep.selectFlightRoute(departureAirport, destinationAirport, date);
        assertStep.assertFoundFlightRoutes(flightRoutes);
    }
}
