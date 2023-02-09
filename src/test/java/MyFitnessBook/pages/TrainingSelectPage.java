package MyFitnessBook.pages;

import MyFitnessBook.BaseFunc;
import com.sun.media.jfxmedia.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.xml.soap.Text;
import java.util.List;

public class TrainingSelectPage {

    private BaseFunc baseFunc;

    private final By NEXT_WEEK = By.xpath(".//div[contains (@class, 'next-week')]");
    private final By TRAINING_TYPE = By.xpath(".//div[(@data-room-id = '11') " +
            "and (@data-trainer-id='106')]");
    private final By GO_TO_BOOKING = By.xpath(".//div[(@data-trainer-id='106')]" +
            "/div[(@class = 'bron-tooltip')]/a[contains (@class, 'link-bron-training')]");
    private final By CURRENT_WEEK = By.xpath(".//span[@class = 'week_nr_helper']");

    public TrainingSelectPage(BaseFunc baseFunc)   {
        this.baseFunc = baseFunc;
    }
    public void selectTraining()    {

        baseFunc.click(NEXT_WEEK);
        baseFunc.waitForElementsCountToBe(CURRENT_WEEK, 2);
//        baseFunc.hoverElement(TRAINING_TYPE);
        baseFunc.hoverElementFromList(TRAINING_TYPE, 0);
//        baseFunc.click(GO_TO_BOOKING);
        baseFunc.clickElementFromList(GO_TO_BOOKING, 0);
    }

}
