package AirportsPages.pages;

import AirportsPages.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeatSelect {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_BOOKED = By.xpath(".//div[@id  = 'book']//div[@class = 'line']");
    private int seatPosition = 28;
    private BaseFunc baseFunc;

    public SeatSelect(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public String getSeatNumber() {
        return baseFunc.findElements(SEAT).get(seatPosition).getText();
    }
    public void clickSelectedSeat() {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        baseFunc.findElements(SEAT).get(seatPosition).click();
    }

    public String getSelectedSeat() {
        return baseFunc.findElement(SEAT_BOOKED).getText().substring(14);
    }

}
