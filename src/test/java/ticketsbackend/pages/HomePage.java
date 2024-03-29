package ticketsbackend.pages;

import ticketsbackend.BaseFunc;
import org.openqa.selenium.By;

public class HomePage {
    private final By FROM = By.id("afrom");
    private final By TO = By.id("bfrom");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc)   {
        this.baseFunc = baseFunc;
    }

    public void selectAirports(String from, String to)    {
        baseFunc.select(FROM, from);
        baseFunc.select(TO, to);
        baseFunc.click(GO_BTN);
    }
}
