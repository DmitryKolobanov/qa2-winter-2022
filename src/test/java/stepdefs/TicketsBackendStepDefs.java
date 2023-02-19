package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import ticketsbackend.BaseFunc;
import ticketsbackend.model.FlightInfo;
import ticketsbackend.model.Passenger;
import ticketsbackend.pages.HomePage;
import ticketsbackend.pages.PassengerInfoPage;

import java.util.Map;

public class TicketsBackendStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage;
    private BaseFunc baseFunc = new BaseFunc();

    private final String URL = "qaguru.lv:8089/tickets/";


    @Given("flight_info")
    public void set_flight_info(Map<String, String> params) {
        flightInfo = new FlightInfo(params.get("destination"), params.get("departure"),
                params.get("discount"), Integer.parseInt(params.get("adults")),
                Integer.parseInt(params.get("kids")), Integer.parseInt(params.get("bags")),
                params.get("flight_date"), params.get("seat"));
    }

    @Given("passenger_info is")
    public void set_passenger_info(Map<String, String> params) {
        Passenger passenger = new Passenger(params.get("first_name"), params.get("last_name"));
        flightInfo.setPassenger(passenger);
    }

    @Given("home page opened")
    public void open_home_page()    {
        baseFunc.openUrl(URL);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting airports")
    public void select_airports()   {
        homePage.selectAirports(flightInfo.getDeparture(), flightInfo.getDestination());
        infoPage = new PassengerInfoPage(baseFunc);
    }

    @Then("selected airports appears on the next page")
    public void check_airports()    {
        Assertions.assertEquals(flightInfo.getDeparture(), infoPage.getFirstFromAirport(), "Error msg!");
        Assertions.assertEquals(flightInfo.getDestination(), infoPage.getFirstToAirport(), "Error msg!");
    }
}
