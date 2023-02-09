package MyFitnessBook.pages;

import MyFitnessBook.BaseFunc;
import org.openqa.selenium.By;

public class ConfirmationPage {

    private BaseFunc baseFunc;

    private final By RESERVATION_BTN = By.xpath(".//a[@data-class_action = 'register']");
    private final By CLOSE_BTN = By.xpath("//div[contains(@class,'comment-modal')]" +
            "/div[@class= 'm-content']/p");
    private final By CONFIRM_TEXT = By.xpath(".//div[contains (@class , 'comment-modal')]" +
        "/div[@class = 'm-content']/span");


    private String confirmationText = "Nodarbības laikā treniņa dvielīša izmantošana ir obligāta!";

    public ConfirmationPage(BaseFunc baseFunc)   {
        this.baseFunc = baseFunc;
    }
    public void confirmSelectedTraining ()  {
        baseFunc.click(RESERVATION_BTN);
    }

    public boolean isReservationAccepted() {
        baseFunc.waitForElementsCountToBe(CONFIRM_TEXT, 1);
        String successText = baseFunc.findElement(CONFIRM_TEXT).getText();
        System.out.println(successText);
        return successText.equals(confirmationText);
    }
    public void closeConfirmation ()    {
        baseFunc.click(CLOSE_BTN);
    }
}
