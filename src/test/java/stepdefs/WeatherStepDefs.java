package stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import model.Weather;
import model.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.List;
import java.util.Map;

public class WeatherStepDefs {

    private long cityId;
    private WeatherResponse response;   //null
    private String convert;     //for convertors to String

    @Given("city ID is: {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;               //makes cityId available to all
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {      //if requester is empty exception
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("coordinates are:")
    public void check_coordinates(Map<String, Double> params) {
        Assertions.assertEquals(params.get("latitude"), response.getLat(), "Wrong Lat!");
        Assertions.assertEquals(params.get("longitude"), response.getLon(), "Wrong Lon!");
    }

    @Then("timezone information is:")
    public void check_timezone(Map<String, String> params) {
        Assertions.assertEquals(params.get("timezone"), response.getTimezone(), "Wrong timezone!");
        convert = String.valueOf(response.getTimezoneOffset());
        Assertions.assertEquals(params.get("offset"), convert, "Wrong timezone offset!");
    }

    @Then("current weather data is:")
    public void check_current_weather(Map<String, String> params) {

        convert = String.valueOf(response.getCurrent().getDt());
        Assertions.assertEquals(params.get("time"), convert, "Wrong time!");

        convert = String.valueOf(response.getCurrent().getSunrise());
        Assertions.assertEquals(params.get("sunrise"), convert, "Wrong sunrise!");

        convert = String.valueOf(response.getCurrent().getSunset());
        Assertions.assertEquals(params.get("sunset"), convert, "Wrong sunset!");

        convert = String.valueOf(response.getCurrent().getTemp());
        Assertions.assertEquals(params.get("temperature"), convert, "Wrong temperature!");

        convert = String.valueOf(response.getCurrent().getFeelsLike());
        Assertions.assertEquals(params.get("feeling"), convert, "Wrong feels like!");

        convert = String.valueOf(response.getCurrent().getPressure());
        Assertions.assertEquals(params.get("pressure"), convert, "Wrong pressure!");

        convert = String.valueOf(response.getCurrent().getHumidity());
        Assertions.assertEquals(params.get("humidity"), convert, "Wrong humidity");

        convert = String.valueOf(response.getCurrent().getDewPoint());
        Assertions.assertEquals(params.get("dew"), convert, "Wrong Dew Point!");

        convert = String.valueOf(response.getCurrent().getUvi());
        Assertions.assertEquals(params.get("ultraviolet"), convert, "Wrong uvi!");

        convert = String.valueOf(response.getCurrent().getClouds());
        Assertions.assertEquals(params.get("clouds"), convert, "Wrong clouds!");

        convert = String.valueOf(response.getCurrent().getVisibility());
        Assertions.assertEquals(params.get("visibility"), convert, "Wrong visibility!");

    }

    @Then("current wind is:")
    public void check_current_wind(Map<String, String> params) {

        convert = String.valueOf(response.getCurrent().getWindSpeed());
        Assertions.assertEquals(params.get("speed"), convert, "Wrong wind speed!");

        convert = String.valueOf(response.getCurrent().getWindDeg());
        Assertions.assertEquals(params.get("degrees"), convert, "Wrong wind degrees!");

        convert = String.valueOf(response.getCurrent().getWindGust());
        Assertions.assertEquals(params.get("gust"), convert, "Wrong wind gust!");

    }

    @Then("current weather condition Nr. {int} is:")
    public void check_current_condition(int index, Map<String, String> params) {

        convert = String.valueOf(response.getCurrent().getWeather().get(0).getId());
        Assertions.assertEquals(params.get("id"), convert, "Wrong current weather ID!");

        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeather().get(0).getMain(),
                "Wrong current main!");

        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeather().get(0).getDescription(),
                "Wrong current description!");

        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeather().get(0).getIcon(),
                "Wrong current icon!");

    }

    @Then("minutely data Nr. {int} are:")
    public void check_minutely_data (int index, Map<String, String> params) {

        convert = String.valueOf(response.getMinutely().get(0).getDt());
        Assertions.assertEquals(params.get("time"), convert, "Wrong time!");

        convert = String.valueOf(response.getMinutely().get(0).getPrecipitation());
        Assertions.assertEquals(params.get("precipitation"), convert, "Wrong precipitation!");

    }

    @Then("hourly weather data Nr. {int} are:")
    public void check_hourly_weather(int index, Map<String, String> params) {

        convert = String.valueOf(response.getHourly().get(0).getDt());
        Assertions.assertEquals(params.get("time"), convert, "Wrong time!");

        convert = String.valueOf(response.getHourly().get(0).getTemp());
        Assertions.assertEquals(params.get("temperature"), convert, "Wrong temperature!");

        convert = String.valueOf(response.getHourly().get(0).getFeelsLike());
        Assertions.assertEquals(params.get("feeling"), convert, "Wrong feeling!");

        convert = String.valueOf(response.getHourly().get(0).getPressure());
        Assertions.assertEquals(params.get("pressure"), convert, "Wrong pressure!");

        convert = String.valueOf(response.getHourly().get(0).getHumidity());
        Assertions.assertEquals(params.get("humidity"), convert, "Wrong humidity!");

        convert = String.valueOf(response.getHourly().get(0).getDewPoint());
        Assertions.assertEquals(params.get("dew"), convert, "Wrong Dew Point!");

        convert = String.valueOf(response.getHourly().get(0).getUvi());
        Assertions.assertEquals(params.get("ultraviolet"), convert, "Wrong ultraviolet!");

        convert = String.valueOf(response.getHourly().get(0).getClouds());
        Assertions.assertEquals(params.get("clouds"), convert, "Wrong clouds!");

        convert = String.valueOf(response.getHourly().get(0).getVisibility());
        Assertions.assertEquals(params.get("visibility"), convert, "Wrong visibility!");

        convert = String.valueOf(response.getHourly().get(0).getWindSpeed());
        Assertions.assertEquals(params.get("speed"), convert, "Wrong wind speed!");

        convert = String.valueOf(response.getHourly().get(0).getWindDeg());
        Assertions.assertEquals(params.get("degrees"), convert, "Wrong wind degrees!");

        convert = String.valueOf(response.getHourly().get(0).getWindGust());
        Assertions.assertEquals(params.get("gust"), convert, "Wrong wind gust !");

    }

    @Then("hourly weather condition Nr. {int} is:")
    public void check_hourly_condition(int index, Map<String, String> params) {

        convert = String.valueOf(response.getHourly().get(0).getWeather().get(0).getId());
        Assertions.assertEquals(params.get("id"), convert, "Wrong weather id!");

        convert = String.valueOf(response.getHourly().get(0).getWeather().get(0).getMain());
        Assertions.assertEquals(params.get("main"), convert, "Wrong weather main!");

        convert = String.valueOf(response.getHourly().get(0).getWeather().get(0).getDescription());
        Assertions.assertEquals(params.get("description"), convert, "Wrong weather description!");

        convert = String.valueOf(response.getHourly().get(0).getWeather().get(0).getIcon());
        Assertions.assertEquals(params.get("icon"), convert, "Wrong weather icon!");

    }

    @Then("probability of precipitation is:")
    public void check_hourly_pop(Map<String, Double> params) {

        Assertions.assertEquals(params.get("pop"), response.getHourly().get(0).getPop(), "Wrong pop!");

    }

    @Then("day data Nr. {int} are:")
    public void check_day_data(int index, Map<String, String> params) {
        convert = String.valueOf(response.getDaily().get(0).getDt());
        Assertions.assertEquals(params.get("time"), convert, "Wrong day data/time!");

        convert = String.valueOf(response.getDaily().get(0).getSunrise());
        Assertions.assertEquals(params.get("sunrise"), convert, "Wrong day sunrise!");

        convert = String.valueOf(response.getDaily().get(0).getSunset());
        Assertions.assertEquals(params.get("sunset"), convert, "Wrong day sunset!");

        convert = String.valueOf(response.getDaily().get(0).getMoonrise());
        Assertions.assertEquals(params.get("moonrise"), convert, "Wrong day moonrise!");

        convert = String.valueOf(response.getDaily().get(0).getMoonset());
        Assertions.assertEquals(params.get("moonset"), convert, "Wrong day moonset!");

        convert = String.valueOf(response.getDaily().get(0).getMoonPhase());
        Assertions.assertEquals(params.get("moonphase"), convert, "Wrong day moon phase!");

    }

    @Then("day temperature for day Nr. {int} is:")
    public void check_day_temp(int index, Map<String, Double> params) {

        Assertions.assertEquals(params.get("daytemp"), response.getDaily().get(0).getTemp().getDay(),
                "Wrong day temperature!");

        Assertions.assertEquals(params.get("minimum"), response.getDaily().get(0).getTemp().getMin(),
                "Wrong minimum temperature!");

        Assertions.assertEquals(params.get("maximum"), response.getDaily().get(0).getTemp().getMax(),
                "Wrong maximum temperature!");

        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getTemp().getNight(),
                "Wrong night temperature!");

        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getTemp().getEve(),
                "Wrong evening temperature!");
//
        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getTemp().getMorn(),
                "Wrong morning temperature!");

    }

    @Then("day feeling for day Nr. {int} is like:")
    public void check_day_feeling(int index, Map<String, Double> params) {

        Assertions.assertEquals(params.get("dayfeel"), response.getDaily().get(0).getFeelsLike().getDay(),
                "Wrong day feels like!");

        Assertions.assertEquals(params.get("night"), response.getDaily().get(0).getFeelsLike().getNight(),
                "Wrong night feels like!");

        Assertions.assertEquals(params.get("evening"), response.getDaily().get(0).getFeelsLike().getEve(),
                "Wrong evening feels like!");

        Assertions.assertEquals(params.get("morning"), response.getDaily().get(0).getFeelsLike().getMorn(),
                "Wrong morning feels like!");

    }

    @Then("day air data for day Nr. {int} are:")
    public void check_air_data(int index, Map<String, String> params) {

        convert = String.valueOf(response.getDaily().get(0).getPressure());
        Assertions.assertEquals(params.get("pressure"), convert, "Wrong day pressure!");

        convert = String.valueOf(response.getDaily().get(0).getHumidity());
        Assertions.assertEquals(params.get("humidity"), convert, "Wrong day humidity!");

        convert = String.valueOf(response.getDaily().get(0).getDewPoint());
        Assertions.assertEquals(params.get("dew"), convert, "Wrong day Dew Point!");

    }

    @Then("day wind for day Nr. {int} is:")
    public void check_day_wind(int index, Map<String, String> params) {

        convert = String.valueOf(response.getDaily().get(0).getWindSpeed());
        Assertions.assertEquals(params.get("speed"), convert, "Wrong day wind speed!");

        convert = String.valueOf(response.getDaily().get(0).getWindDeg());
        Assertions.assertEquals(params.get("degrees"), convert, "Wrong day wind degrees!");

        convert = String.valueOf(response.getDaily().get(0).getWindGust());
        Assertions.assertEquals(params.get("gust"), convert, "Wrong day wind gust!");

    }

    @Then("day weather condition Nr. {int} is:")
    public void check_day_condition(int index, Map<String, String> params) {

        convert = String.valueOf(response.getDaily().get(0).getWeather().get(0).getId());
        Assertions.assertEquals(params.get("id"), convert, "Wrong weather id!");

        convert = String.valueOf(response.getDaily().get(0).getWeather().get(0).getMain());
        Assertions.assertEquals(params.get("main"), convert, "Wrong weather main!");

        convert = String.valueOf(response.getDaily().get(0).getWeather().get(0).getDescription());
        Assertions.assertEquals(params.get("description"), convert, "Wrong weather description!");

        convert = String.valueOf(response.getDaily().get(0).getWeather().get(0).getIcon());
        Assertions.assertEquals(params.get("icon"), convert, "Wrong weather icon!");

    }

    @Then("day sky condition for day Nr. {int} is:")
    public void check_sky_condition(int index, Map<String, String> params) {

        convert = String.valueOf(response.getDaily().get(0).getClouds());
        Assertions.assertEquals(params.get("clouds"), convert, "Wrong day clouds!");

        convert = String.valueOf(response.getDaily().get(0).getPop());
        Assertions.assertEquals(params.get("pop"), convert, "Wrong day pop!");

        convert = String.valueOf(response.getDaily().get(0).getRain());
        Assertions.assertEquals(params.get("rain"), convert, "Wrong day rain!");

        convert = String.valueOf(response.getDaily().get(0).getUvi());
        Assertions.assertEquals(params.get("ultraviolet"), convert, "Wrong day uvi!");

    }

    @Then("alert Nr. {int} received:")
    public void check_alert(int index, Map<String, String> params) {

        convert = String.valueOf(response.getAlerts().get(0).getSenderName());
        Assertions.assertEquals(params.get("sender"), convert, "Wrong sender name!");

        convert = String.valueOf(response.getAlerts().get(0).getEvent());
        Assertions.assertEquals(params.get("event"), convert, "Wrong event name!");

        convert = String.valueOf(response.getAlerts().get(0).getStart());
        Assertions.assertEquals(params.get("start"), convert, "Wrong start date / time!");

        convert = String.valueOf(response.getAlerts().get(0).getEnd());
        Assertions.assertEquals(params.get("end"), convert, "Wrong end date / time!");

        convert = String.valueOf(response.getAlerts().get(0).getDescription());
        Assertions.assertEquals(params.get("description"), convert, "Wrong description!");

        convert = String.valueOf(response.getAlerts().get(0).getTags());
        Assertions.assertEquals(params.get("tags"), convert, "Wrong tags!");

    }

    @Then("tags for an alert Nr. {int} are:")
    public void check_tags(int index, List<String> tags) {

    }
}
