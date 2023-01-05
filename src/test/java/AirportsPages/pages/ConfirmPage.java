package AirportsPages.pages;

import AirportsPages.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ConfirmPage {

    private final By RESERVATION_COMPLETED = By.xpath(".//div[@class = 'finalTxt']");
    private String confirmPageText = "Thank You for flying with us!";

    private BaseFunc baseFunc;

    public ConfirmPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public boolean isConfirmationPageLoaded() {
        boolean isPageLoaded;
        try {
            baseFunc.findElement(RESERVATION_COMPLETED);
            return isPageLoaded = true;
        } catch (TimeoutException e) {
            return isPageLoaded = false;
        }
    }

    public boolean isConfirmationAccepted() {
        String confirmationText = baseFunc.findElement(RESERVATION_COMPLETED).getText();
        return confirmationText.equals(confirmPageText);
    }

}