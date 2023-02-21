package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import ticketsbackend.BaseFunc;
import ticketsbackend.model.FlightInfo;
import ticketsbackend.model.Passenger;
import ticketsbackend.pages.ConfirmPage;
import ticketsbackend.pages.HomePage;
import ticketsbackend.pages.PassengerInfoPage;
import ticketsbackend.pages.SeatSelectPage;

import java.util.Map;

public class TicketsBackendStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage;
    private SeatSelectPage seatSelectPage;
//
    private ConfirmPage confirmPage;
    private BaseFunc baseFunc = new BaseFunc();
    private String seatNumber;
    private String price;


    private final String URL = "qaguru.lv:8089/tickets/";


    @Given("flight_info")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"),
                params.get("discount_code"), Integer.parseInt(params.get("adults")),
                Integer.parseInt(params.get("kids")), Integer.parseInt(params.get("bags")),
                params.get("flight_date"), (params.get("seat")));
    }

    @Given("passenger_info is")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page opened")
    public void open_home_page() {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports() {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void check_airports() {
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFirstFromAirport(), "Incorrect FROM " +
                "airport before pax form filled!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getFirstToAirport(), "Incorrect TO " +
                "airport before pax filled!");
    }

    @Then("we are filling in passenger registration form")
    public void filling_data() {
        infoPage.fillInPassengerInfo(flightInfo);
    }

    @Then("requesting price")
    public void requestPrice() {
        infoPage.getTicketPrice();
    }

    @Then("we are pressing Book button")
    public void proceedToSeats() {
        infoPage.clickSBookBtn();
    }

    @Then("passenger name and airports appears")
    public void nameAndAirportsCheck() {
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), infoPage.getPassengerName(), "Wrong " +
                "passenger name!");
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getSecondFromAirport(), "Incorrect " +
                "FROM airport after 'Get Price' btn pressed!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getSecondToAirport(), "Incorrect TO " +
                "airport after 'Get Price' btn pressed!");
    }

    @Then("price is 2140 EUR")
    public void checkTicketPrice() {
        price = infoPage.getPrice();
        Assertions.assertEquals(price, "2140", "Incorrect price!");
    }

    @Then("selecting seat")
    public void selectSeat()    {
        seatSelectPage = new SeatSelectPage(baseFunc);
        seatNumber = String.valueOf(flightInfo.getSeatNr());
        seatSelectPage.clickSeatByNumber(seatNumber);
    }

    @Then("correct seat number appears")
    public void checkSeatNumber()   {
        Assertions.assertEquals(seatNumber, seatSelectPage.getSelectedSeat(), "Seat numbers are " +
                "different!");
    }

    @Then("we are booking selected ticket")
    public void confirmingTicket() {
        seatSelectPage.clickLastBook();
    }

    @Then("successful registration message appears")
    public void checkSuccess()  {
        confirmPage = new ConfirmPage(baseFunc);
        Assertions.assertTrue(confirmPage.isConfirmationAccepted(), "Wrong registration text");
    }

}

