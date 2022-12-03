package HW_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Amazon {
    private final By ACCEPT_COOKIES_BTN = By.id("sp-cc-accept");
    private final By NO_ADDRESS_CHANGE = By.xpath(".//input[@data-action-type = 'DISMISS']");
    private final By MAIN_MENU_LIST_ITEM = By.xpath(".//a[@data-csa-c-content-id  = 'nav_cs_bestsellers']");
    private final By PROCEED_TO_ITEMS = By.xpath("//div[@role='treeitem']/a[contains(@href, 'bestsellers/books')]");
    private final By ITEM_LINK = By.xpath(".//div[@class= 'p13n-sc-uncoverable-faceout']/a[@class = 'a-link-normal']");
    private final By MENU_RATINGS_COUNT = By.xpath(".//span[@class = 'a-size-small']");//getText + need to add " ratings"
    private final By MENU_STARS_COUNT = By.xpath(".//div[@class = 'a-icon-row']/a");
    private final By BOOKPAGE_RATINGS_COUNT = By.xpath(".//span[@id = 'acrCustomerReviewText']");
    private final By BOOKPAGE_STARS_COUNT = By.xpath("//span[@id= 'acrPopover']");
    private final By PROCEED_TO_REVIEWS = By.xpath(".//a[@data-hook = 'see-all-reviews-link-foot']");
    private final By REVIEWS_COUNT_DISPLAYED = By.xpath(".//div[@id= 'filter-info-section']/div");
    private final By EVERY_REVIEW_BLOCK = By.xpath(".//div[contains(@id,  '-review-card')]");
    private final By NEXT_PAGE_LINK = By.xpath(".//li[@class = 'a-last']/a");
//    private final By NEXT_PAGE_AVAILABLE = By.xpath(".//li[@class = 'a-last']");
//    private final By NO_NEXT_PAGE_LINK = By.xpath(".//li[@class = 'a-disabled a-last']");

    String ratingsInMenu;
    String ratingsOnBookpage;
    String starsOnBookpage;
    String starsInMenu;
    String reviewsOnReviewPage;
    String ratingsInMenuFull;
    String reviewsDisplayedToPrint;
    String reviewsCountedToPrint;
    int reviewsCounted;

    @Test
    public void amazonBooks() {
        System.setProperty("webdriver.chrome.driver", "C://QA2/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http:///www.amazon.de/");

        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        wait.until(ExpectedConditions.elementToBeClickable(NO_ADDRESS_CHANGE));
        browser.findElement(NO_ADDRESS_CHANGE).click();

        wait.until(ExpectedConditions.elementToBeClickable(MAIN_MENU_LIST_ITEM));
        browser.findElement(MAIN_MENU_LIST_ITEM).click();

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_ITEMS));
        browser.findElement(PROCEED_TO_ITEMS).click();

        //------------------ Working with book Nr. 4 (in menu) --------------

        List<WebElement> menuRatings = browser.findElements(MENU_RATINGS_COUNT);
        List<WebElement> menuStars = browser.findElements(MENU_STARS_COUNT);

        ratingsInMenu = (menuRatings.get(3).getText());
        ratingsInMenuFull = (ratingsInMenu + " ratings");
        starsInMenu = (menuStars.get(3).getAttribute("title"));

        List<WebElement> itemlinks = browser.findElements(ITEM_LINK);
        itemlinks.get(7).click();       // 4 = 7 - because of 2 links per item


        //----------- Working with book Nr. 4 (on Book's page) -------------


        ratingsOnBookpage = browser.findElement(BOOKPAGE_RATINGS_COUNT).getText();
        starsOnBookpage = (browser.findElement(BOOKPAGE_STARS_COUNT).getAttribute("title"));


        //------------------ Ratings and stars print and  compare ---------

        System.out.println("Ratings in menu: " + ratingsInMenuFull);
        System.out.println("Ratings on book's page: " + ratingsOnBookpage);
        Assertions.assertEquals(ratingsInMenuFull, ratingsOnBookpage, "Ratings are different!");

        System.out.println(" ");

        System.out.println("Stars in menu: " + starsInMenu);
        System.out.println("Stars on book's page: " + starsOnBookpage);
        Assertions.assertEquals(starsInMenu, starsOnBookpage, "Star counts are different!");

        //--------------- Reviews count and  compare ------------

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_REVIEWS));
        browser.findElement(PROCEED_TO_REVIEWS).click();

        reviewsOnReviewPage = browser.findElement(REVIEWS_COUNT_DISPLAYED).getText();//get reviews count displayed on page

        for (int i = 0; i < 100000; i++) {              //page change routine (max - 100000 pages)
            List<WebElement> reviewInList = browser.findElements(EVERY_REVIEW_BLOCK);
            for (WebElement we : reviewInList) {        //reviews counting on page routine
                reviewsCounted = reviewsCounted + 1;
                System.out.println(reviewsCounted);
            }
            if (!browser.findElements(NEXT_PAGE_LINK).isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(NEXT_PAGE_LINK));
                browser.findElement(NEXT_PAGE_LINK).click();
            } else {
                break;
            }
        }

        //-------------- Reviews result output -----------------------

        reviewsDisplayedToPrint = (reviewsOnReviewPage);
        reviewsCountedToPrint = (ratingsInMenu + " total ratings, " + reviewsCounted + " with reviews");

        System.out.println(" ");
        System.out.println("Reviews displayed: " + reviewsDisplayedToPrint);
        System.out.println("Reviews counted: " + reviewsCountedToPrint);
        Assertions.assertEquals(reviewsDisplayedToPrint, reviewsCountedToPrint, "Reviews counts are different!");

    }
}

