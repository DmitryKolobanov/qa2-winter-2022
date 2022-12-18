package AirportsPages;

import AirportsPages.pages.HomePage;
import AirportsPages.pages.PassengerInfo;
import AirportsPages.pages.SeatSelect;
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

        baseFunc.click(BOOK_BTN);

        SeatSelect seatSelect = new SeatSelect(baseFunc);
        System.out.println(seatSelect.getSeatNumber());
        seatSelect.clickSelectedSeat();
        System.out.println(seatSelect.getSelectedSeat());
        Assertions.assertEquals(seatSelect.getSeatNumber(), seatSelect.getSelectedSeat(), "Seat numbers are " +
                "different!");
    }
}
