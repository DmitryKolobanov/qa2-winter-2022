package SsCom.pages;

import SsCom.BaseFunc;
import org.openqa.selenium.By;

public class CarSelectPage {

    private final By SELECT_CAR = By.id("ahc_120");
    private final By SELECT_MODEL = By.xpath(".//option[text() = 'Fusion']");
    private final By FILTER_2ND_ROW = By.xpath(".//span[@class = 'filter_opt_dv']");
    private BaseFunc baseFunc;
    private final By MODEL_LIST = By.xpath(".//select[@class = 'filter_sel']/option");

    public CarSelectPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void selectManufacturer()    {
        baseFunc.click(SELECT_CAR);
    }

    public void selectModel()   {
        baseFunc.clickElementFromList(FILTER_2ND_ROW, 3);
//        baseFunc.hoverElementFromList(MODEL_LIST, 12);
        baseFunc.clickElementFromList(MODEL_LIST, 13);
    }



}
