package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Reservation;
import org.junit.jupiter.api.Assertions;
import requesters.TicketsRequester;
import ticketsbackend.BaseFunc;
import ticketsbackend.model.FlightInfo;
import ticketsbackend.model.Passenger;
import ticketsbackend.pages.ConfirmPage;
import ticketsbackend.pages.HomePage;
import ticketsbackend.pages.PassengerInfoPage;
import ticketsbackend.pages.SeatSelectPage;

import java.util.List;
import java.util.Map;

public class TicketsBackendStepDefs {
    private FlightInfo flightInfo; //null
    private HomePage homePage; //null
    private PassengerInfoPage infoPage;
    private List<Reservation> reservations;
    private Reservation reservationFromApi; //null
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
                params.get("flight_date"), Integer.parseInt(params.get("seat")));
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

    @When("we are filling in passenger registration form")  //
    public void filling_data() {
        infoPage.fillInPassengerInfo(flightInfo);
    }

    @When("requesting price")  //
    public void requestPrice() {
        infoPage.getTicketPrice();
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

    @When("we are pressing Book button")
    public void proceedToSeats() {
        infoPage.clickSBookBtn();
    }

    @When("selecting seat")  //
    public void selectSeat() {
        seatSelectPage = new SeatSelectPage(baseFunc);
        seatNumber = Integer.toString(flightInfo.getSeatNr());
        seatSelectPage.clickSeatByNumber(seatNumber);
    }

    @Then("correct seat number appears")  //
    public void checkSeatNumber() {
        Assertions.assertEquals(seatNumber, seatSelectPage.getSelectedSeat(), "Seat numbers are " +
                "different!");
    }

    @When("we are booking selected ticket")  //
    public void confirmingTicket() {
        seatSelectPage.clickLastBook();
    }


    @Then("successful registration message appears") //
    public void checkSuccess() {
        confirmPage = new ConfirmPage(baseFunc);
        Assertions.assertTrue(confirmPage.isConfirmationAccepted(), "Wrong registration text");
    }

    @When("we are requesting reservations data")
    public void request_reservations() throws JsonProcessingException {
        TicketsRequester requester = new TicketsRequester();
        reservations = requester.getReservations();
    }

    @Then("current reservation is in the list")
    public void find_reservation() {
        for (Reservation r : reservations) {
            if (r.getName().equals(flightInfo.getPassenger().getFirstName())) {
                reservationFromApi = r;
                break;
            }
        }

        Assertions.assertNotNull(reservationFromApi, "Reservation in not found!");
    }

    @Then("all reservation data are correct")
    public void check_reservation_data() {
        System.out.println("Reservation Id: " + reservationFromApi.getId());

        System.out.println("Name in reservation: " + flightInfo.getPassenger().getFirstName() +
                "   Name on Server: " + reservationFromApi.getName());
        Assertions.assertEquals(flightInfo.getPassenger().getFirstName(), reservationFromApi.getName(),
                "Wrong passenger name!");

        System.out.println("Surname in reservation: " + flightInfo.getPassenger().getLastName() +
                "   Surname on Server: " + reservationFromApi.getSurname());
        Assertions.assertEquals(flightInfo.getPassenger().getLastName(), reservationFromApi.getSurname(),
                "Wrong passenger surname!");

        System.out.println("Departure in reservation: " + flightInfo.getDeparture() +
                "   Departure on Server: " + reservationFromApi.getDeparture());
        Assertions.assertEquals(flightInfo.getDeparture(), reservationFromApi.getDeparture(),
                "Wrong departure airport!");

        System.out.println("Arrival in reservation: " + flightInfo.getDestination() +
                "   Arrival on Server: " + reservationFromApi.getArrival());
        Assertions.assertEquals(flightInfo.getDestination(), reservationFromApi.getArrival(),
                "Wrong arrival airport!");

        System.out.println("Bags count in reservation: " + flightInfo.getBagsCount() +
                "   Bags count on Server: " + reservationFromApi.getBagCount());
        Assertions.assertEquals(flightInfo.getBagsCount(), reservationFromApi.getBagCount(),
                "Wrong bags count!");

        System.out.println("Discount code in reservation: " + flightInfo.getDiscount() +
                "   Discount code on Server: " + reservationFromApi.getDiscount());
        Assertions.assertEquals(flightInfo.getDiscount(), reservationFromApi.getDiscount(),
                "Wrong discount code!");

        System.out.println("Children count in reservation: " + flightInfo.getChildCount() +
                "   Children count on Server: " + reservationFromApi.getChildrenCount());
        Assertions.assertEquals(flightInfo.getChildCount(), reservationFromApi.getChildrenCount(),
                "Wrong children count!");

        System.out.println("Flight date in reservation: " + flightInfo.getFlightDate() +
                "   Flight date on Server: " + reservationFromApi.getFlightDate());
        Assertions.assertEquals(flightInfo.getFlightDate().substring(0, 2), reservationFromApi.getFlightDate(),
                "Wrong adults count!");


        System.out.println("Adults count in reservation: " + flightInfo.getAdultsCount() +
                "   Adults count on Server: " + reservationFromApi.getAdultsCount());
        Assertions.assertEquals(flightInfo.getAdultsCount(), reservationFromApi.getAdultsCount(),
                "Wrong adults count!");

        System.out.println("Seat Nr. in reservation: " + flightInfo.getSeatNr() +
                "   Seat Nr. on Server: " + reservationFromApi.getSeatNum());
        Assertions.assertEquals(flightInfo.getSeatNr(), reservationFromApi.getSeatNum(),
                "Wrong seat Nr.!");

    }
}

