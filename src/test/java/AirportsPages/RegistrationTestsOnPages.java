package AirportsPages;

import AirportsPages.pages.ConfirmPage;
import AirportsPages.pages.HomePage;
import AirportsPages.pages.PassengerInfoPage;
import AirportsPages.pages.SeatSelectPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import pageobject.model.Passenger;

public class RegistrationTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";


    String seatNumber;

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        Passenger passenger = new Passenger("Dima", "Kolobok", "Hacker", 2,
                1, 2, "12-05-2018");

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(passenger);

        Assertions.assertEquals(passenger.getFirstName(), infoPage.getPassengerName(), "Wrong passenger name!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getFirstFromAirport(), "Incorrect FROM airport before " +
                "pax form filled!");
        Assertions.assertEquals(FROM_AIRPORT, infoPage.getSecondFromAirport(), "Incorrect FROM airport after" +
                "'Get Price' pressed!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getFirstToAirport(), "Incorrect TO airport before pax" +
                "form filled!");
        Assertions.assertEquals(TO_AIRPORT, infoPage.getSecondToAirport(), "Incorrect TO airport after 'Get" +
                " Price' pressed!");

        Assertions.assertTrue(infoPage.getPrice().length() > 0, "No price received!");


        infoPage.clickSBookBtn();                   //proceed to seat select

        SeatSelectPage seatSelectPage = new SeatSelectPage(baseFunc);
        seatNumber = seatSelectPage.getSeatNumber();
        seatSelectPage.clickSelectedSeat();
        Assertions.assertEquals(seatNumber, seatSelectPage.getSelectedSeat(), "Seat numbers are " +
                "different!");

        seatSelectPage.clickLastBook();              //proceed to final page

        ConfirmPage confirmPage = new ConfirmPage(baseFunc);
        Assertions.assertTrue(confirmPage.isConfirmationPageLoaded(),  "Page not found!");
        Assertions.assertTrue(confirmPage.isConfirmationAccepted(), "Wrong registration text");

    }
    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
