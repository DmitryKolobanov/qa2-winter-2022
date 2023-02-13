package requesters;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import model.WeatherResponse;
import org.springframework.web.client.RestTemplate;

public class WeatherRequester {
    private final String PREFIX = "http://qaguru.lv:8089/tickets/getWeather.php?id=";

    public WeatherResponse requestWeather(long cityId) throws JsonProcessingException {  //readValue exception
        String url = PREFIX + cityId;

        RestTemplate restTemplate = new RestTemplate();
//        String jsonToParse =  restTemplate.getForEntity(url, WeatherResponse.class); // OR
        String jsonToParse =  restTemplate.getForEntity(url, String.class).getBody();  //read json

        ObjectMapper objectMapper = new ObjectMapper();// convert json <-> object (part of Jackson)
        return objectMapper.readValue(jsonToParse, WeatherResponse.class);
    }
}
