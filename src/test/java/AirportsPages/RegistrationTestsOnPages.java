package AirportsPages;

import AirportsPages.pages.HomePage;
import AirportsPages.pages.PassengerInfo;
import org.junit.jupiter.api.Test;

public class RegistrationTestsOnPages {
    private final String URL = "http://www.qaguru.lv:8089/tickets//";
    private final String FROM_AIRPORT = "RIX";
    private final String TO_AIRPORT = "SFO";
    private final String paxName = "Vasja";

    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void successfulRegistrationTest() {
        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.selectAirports(FROM_AIRPORT, TO_AIRPORT);

        PassengerInfo infoPage = new PassengerInfo(baseFunc);
    }
}
