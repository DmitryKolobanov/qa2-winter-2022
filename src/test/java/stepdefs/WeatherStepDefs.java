package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {

    @Given("city ID is: {long}")
    public void set_city_id(long id) {

    }

    @When("we are requesting weather forecast")
    public void request_weather() {

    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {

    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {

    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {

    }

    @Then("current wind is:")
    public void check_current_wind(Map<String, String> params) {


    }

    @Then("current weather condition is:")
    public void check_current_condition(List<Map<String, String>> params) {


    }

    @Then("minutely data is:")
    public void check_minutely_data(List<Map<String, String>> params) {


    }

    @Then("hourly weather data is:")
    public void check_hourly_weather(List<Map<String, String>> params) {


    }

    @Then("hourly wind is:")
    public void check_hourly_wind(Map<String, String> params) {


    }

    @Then("hourly weather condition is:")
    public void check_hourly_condition(List<Map<String, String>> params) {


    }

    @Then("probability of precipitation is:")
    public void check_hourly_pop(Map<String, Double> params) {


    }
//

    @Then("day data is:")
    public void check_day_data(Map<String, String> params) {


    }

    @Then("day temperature is:")
    public void check_day_temp(Map<String, Double> params) {


    }

    @Then("day feeling is like:")
    public void check_day_feeling(Map<String, Double> params) {


    }

    @Then("day air data is:")
    public void check_air_data(Map<String, String> params) {


    }

    @Then("day wind is:")
    public void check_day_wind(Map<String, String> params) {


    }

    @Then("day weather condition is:")
    public void check_day_condition(Map<String, String> params) {


    }

    @Then("day sky condition is:")
    public void check_sky_condition(Map<String, String> params) {


    }

    //
    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {

    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {

    }
}
