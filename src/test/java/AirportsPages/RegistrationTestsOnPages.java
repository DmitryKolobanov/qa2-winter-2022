package AirportsPages;

import AirportsPages.pages.HomePage;
import AirportsPages.pages.PassengerInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobject.model.Passenger;

public class RegistrationTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private final By BOOK_BTN = By.id("book2");

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        Passenger passenger = new Passenger("Dima","Kolobok", "Hacker", 2,
                1, 2, "12-05-2018");

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfo infoPage = new PassengerInfo(baseFunc);
        infoPage.fillInPassengerInfo(passenger);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Wrong name!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFirstFromAirport(), "Error msg!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getSecondFromAirport(), "Error msg!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getFirstToAirport(), "Error msg!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getSecondToAirport(), "Error msg!");

        Assertions.assertTrue(infoPage.getPrice().length() > 0, "Error message!");

        baseFunc.click(BOOK_BTN);

    }
}
