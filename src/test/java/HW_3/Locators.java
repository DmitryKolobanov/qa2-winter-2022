package HW_3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    @Test
    public void LocatorsSearch() {
        System.setProperty("webdriver.chrome.driver", "C://QA2/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http:///www.discovercars.com/");

        //--------- Page 1 -----------

        By.xpath("//div[@class='logo-cell']");  //Logo
        By.id("currentCurrency");       //Currency selector
        By.xpath("//a[contains(@class, 'trigger-login-modal' )]");      //Login btn
        By.xpath("//div[@class= 'home-caption']");          //No hidden costs
        By.xpath("//div[@class='sb-group dates left']/div[@class='fake-field clearfix']");     //Pick Up date)
        By.id("sb-country");        //Latvia
        By.id("location-submit");       //Search now btn
        By.xpath("//*[contains(@class, 'arrow-slider-circle' )]");      //Arrows (Two found, different directions)
        By.xpath("//div[@class= 'tp-widget-review']");      // Carousel (15 found)
        By.xpath("//div[@class= 'row is-table-row' ]");     //We compare car rental prices, you save!

        //--------- Page 2 -----------

        By.xpath("//div[@data-event-label= 'Small cars']");  //Small Cars
        By.xpath("//div[@class= 'car-top-filter-control next']");   //Btn Right
        By.xpath("//span[@class= 'showing-cars']");     //Car count
        By.xpath("//a[contains (@class, 'dc-ui ')]");  // Sort by Price
        By.xpath("//span[text()= '1 bag']");// 'All cars with 1 Bag (43)'
        By.xpath("//a[contains (@class, 'btn-book')]"); // "View" btn for all (291) cars
        By.xpath("//a[contains (@class, 'rental-conditions')]");  // "Rental conditions" for all (291) cars
        By.xpath("//span[text()= 'Partial prepayment']"); // "Partial prepayment" (197 cars)
        By.xpath("//div[contains(@class, 'vcenter')]/div[@class= 'supplier-rating']"); //"Supplier rating" for all (291) cars
        By.xpath("//div[@class= 'price-item-price-main']");        //Price for each (291) car
        By.xpath("//span[@class= 'category-label trend']/parent::div/parent::div");   // Special offers
        By.xpath("//label[@for= 'air-conditioning-air-conditioning-y']/span[@class = 'min-price']");  //Air conditioning Min price
        By.xpath("//label[(@for ='fuel-type-ft-V') and (text()= 'Gasoline')]"); //"Gasoline" (no idea how to separate price)
        By.xpath("//label[@for= 'number-of-seats-seats-4']");       //4 seats

        //--------- Page 3 -----------

        By.xpath("//div[@class = 'lds-ellipsis v2']");  // three rotating circles
        By.xpath("//div[contains(@class, 'mb-8 text-24')]");  //We are currently searching . . .
        By.xpath("//div[@class = 'mb-24 text-center']");  //. . . for the best available offers among 500 car rental companies!
    }
}
