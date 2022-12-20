package AirportsPages;

import AirportsPages.pages.ConfirmPage;
import AirportsPages.pages.HomePage;
import AirportsPages.pages.PassengerInfo;
import AirportsPages.pages.SeatSelect;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.model.Passenger;

public class RegistrationTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private final By BOOK_BTN = By.id("book2");
    private final By BOOK_LAST_BTN = By.id("book3");

    String seatNumber;

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        Passenger passenger = new Passenger("Dima", "Kolobok", "Hacker", 2,
                1, 2, "12-05-2018");

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfo infoPage = new PassengerInfo(baseFunc);
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

        baseFunc.click(BOOK_BTN);                   //proceed to seat select

        SeatSelect seatSelect = new SeatSelect(baseFunc);
        seatNumber = seatSelect.getSeatNumber();
        seatSelect.clickSelectedSeat();
        Assertions.assertEquals(seatNumber, seatSelect.getSelectedSeat(), "Seat numbers are " +
                "different!");

        baseFunc.click(BOOK_LAST_BTN);              //proceed to final page

        ConfirmPage confirmPage = new ConfirmPage(baseFunc);

        try {
            confirmPage.confirmationAccept();
            System.out.println("Reservation is successful. All tests passed!");
        } catch (TimeoutException e) {
            System.out.println("No confirmation message displayed. Test is not passed!");
        }
    }
    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
