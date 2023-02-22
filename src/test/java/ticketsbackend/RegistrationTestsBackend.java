package ticketsbackend;

import org.junit.jupiter.api.AfterEach;
import ticketsbackend.model.FlightInfo;
import ticketsbackend.model.Passenger;
import ticketsbackend.pages.ConfirmPage;
import ticketsbackend.pages.HomePage;
import ticketsbackend.pages.PassengerInfoPage;
import ticketsbackend.pages.SeatSelectPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationTestsBackend {
    private final String URL = "http://www.qaguru.lv:8089/tickets/";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";


    private String seatNumber;
    private int seatPosition = 27;

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {

        Passenger passenger = new Passenger("Dimon", "Kolobkov");

        FlightInfo info = new FlightInfo("RIX", "SFO", "Hackers", 2, 1, 2, "12-05-2018", 27);
        info.setPassenger(passenger);

        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfoPage infoPage = new PassengerInfoPage(baseFunc);
        infoPage.fillInPassengerInfo(info);
        infoPage.getTicketPrice();


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
        seatNumber = Integer.toString(seatPosition);
        seatSelectPage.clickSeatByNumber(seatNumber);
        Assertions.assertEquals(seatNumber, seatSelectPage.getSelectedSeat(), "Seat numbers are " +
                "different!");

        seatSelectPage.clickLastBook();              //proceed to final page

        ConfirmPage confirmPage = new ConfirmPage(baseFunc);
        Assertions.assertTrue(confirmPage.isConfirmationPageLoaded(), "Page not found!");
        Assertions.assertTrue(confirmPage.isConfirmationAccepted(), "Wrong registration text");

    }
    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
