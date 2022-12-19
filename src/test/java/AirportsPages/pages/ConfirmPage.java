package AirportsPages.pages;

import AirportsPages.BaseFunc;
import org.openqa.selenium.By;

public class ConfirmPage {

    private final By RESERVATION_COMPLETED = By.xpath(".//div[@class = 'finalTxt']");

    private BaseFunc baseFunc;

    public ConfirmPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void confirmationAccept() {
        baseFunc.findElement(RESERVATION_COMPLETED);
    }
}
