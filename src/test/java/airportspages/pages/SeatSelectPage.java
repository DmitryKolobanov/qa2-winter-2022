package airportspages.pages;

import airportspages.BaseFunc;
import org.openqa.selenium.By;

public class SeatSelectPage {
    private final By SEAT = By.xpath(".//div[@class = 'seat']");
    private final By SEAT_BOOKED = By.xpath(".//div[@id  = 'book']//div[@class = 'line']");
    private final By BOOK_LAST_BTN = By.id("book3");
    private int seatPosition = 10;
    private BaseFunc baseFunc;

    public SeatSelectPage(BaseFunc baseFunc) {

        this.baseFunc = baseFunc;
    }
    public String getSeatNumber() {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        return baseFunc.findElements(SEAT).get(seatPosition).getText();
    }

    public void clickSelectedSeat() {
        baseFunc.waitForElementsCountToBe(SEAT, 32);
        baseFunc.findElements(SEAT).get(seatPosition).click();
    }

    public String getSelectedSeat() {
        return baseFunc.findElement(SEAT_BOOKED).getText().substring(14);
    }
    public void clickLastBook() {
        baseFunc.click(BOOK_LAST_BTN);              //proceed to final page
    }

}
