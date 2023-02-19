package ticketsbackend.pages;

import ticketsbackend.BaseFunc;
import ticketsbackend.model.Passenger;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class PassengerInfoPage {
    private final By FIRST_NAME = By.id("name");
    private final By LAST_NAME = By.id("surname");
    private final By DISCOUNT = By.id("discount");
    private final By ADULTS = By.id("adults");
    private final By CHILDREN = By.id("children");
    private final By BAG = By.id("bugs");
    private final By FLIGHT = By.id("flight");
    private final By GET_PRICE_BTN = By.xpath(".//span[@onclick = 'setLang();']");
    private final By DATA_ON_FORM = By.xpath(".//span[@class = 'bTxt']");
    private final By RESPONSE = By.id("response");
    private final By BOOK_BTN = By.id("book2");
    private BaseFunc baseFunc;

    public PassengerInfoPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void fillInPassengerInfo(Passenger passenger)   {
        baseFunc.type(FIRST_NAME, passenger.getFirstName());
        baseFunc.type(LAST_NAME, passenger.getLastName());
        baseFunc.type(DISCOUNT, passenger.getDiscount());
        baseFunc.type(ADULTS, passenger.getPeopleCount());
        baseFunc.type(CHILDREN, passenger.getChildCount());
        baseFunc.type(BAG, passenger.getBagCount());
        baseFunc.selectByText(FLIGHT, passenger.getDate());
        baseFunc.click(GET_PRICE_BTN);
        baseFunc.waitForElementsCountToBe(DATA_ON_FORM, 5);
    }
    public String getFirstFromAirport() {
        return baseFunc.findElements(DATA_ON_FORM).get(0).getText();
    }

    public String getFirstToAirport() {
        return baseFunc.findElements(DATA_ON_FORM).get(1).getText();
    }

    public String getSecondFromAirport() {
        return baseFunc.findElements(DATA_ON_FORM).get(3).getText();
    }

    public String getSecondToAirport() {
        return baseFunc.findElements(DATA_ON_FORM).get(4).getText();
    }

    public String getPassengerName() {
        String name = baseFunc.findElements(DATA_ON_FORM).get(2).getText(); //Dima!
        return name.substring(0, name.length() - 1);
    }

    public String getPrice() {
        String text = baseFunc.findElement(RESPONSE).getText();
        return StringUtils.substringBetween(text, "for ", " EUR");
    }
    public void clickSBookBtn() {
        baseFunc.click(BOOK_BTN);
    }
}