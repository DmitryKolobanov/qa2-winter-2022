package sscom.pages;

import sscom.BaseFunc;
import org.openqa.selenium.By;

public class CarSelectPage {

    private final By SELECT_CAR = By.id("ahc_120");
    private final By SELECT_MODEL = By.xpath(".//option[text() = 'Fusion']");
    private final By FILTER_2ND_ROW = By.xpath(".//span[@class = 'filter_opt_dv']");
    private final By FILTER_1ST_ROW = By.xpath(".//td[@class = 'filter_name']");
    private BaseFunc baseFunc;
    private final By MODEL_LIST = By.xpath(".//select[@class = 'filter_sel']/option");
    private final By ENGINE = By.xpath(". //*[@id='foptfld_34']//option");
    private final By SORT_COLUMN = By.xpath(".//td[@class = 'msg_column_td']//a");
    private final By ITEM_POSITION = By.xpath(".//td[@class = 'msg2']");

    public CarSelectPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectManufacturer() {
        baseFunc.click(SELECT_CAR);
    }

    public void selectModel() {
        baseFunc.clickElementFromList(FILTER_2ND_ROW, 3);
//        baseFunc.hoverElementFromList(MODEL_LIST, 12);
        baseFunc.clickElementFromList(MODEL_LIST, 13);      //selecting model from drop down
        baseFunc.clickElementFromList(FILTER_1ST_ROW, 3);   //engine type filter
        baseFunc.clickElementFromList(ENGINE, 2);   //select engine type
        baseFunc.clickElementFromList(SORT_COLUMN, 0);      //one for Ascent sort
        baseFunc.clickElementFromList(SORT_COLUMN, 0);      //both for Descent sort
        baseFunc.clickElementFromList(ITEM_POSITION, 0);
    }


}
