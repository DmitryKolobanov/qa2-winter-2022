package HW_4;

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
    private final By NO_ADDRESS_CHANGE = By.xpath("//span[contains(text(), 'CONTINUE')]/parent::span");
    private final By PROCEED_TO_BEST_SELLERS = By.linkText("Best Sellers");
    private final By PROCEED_TO_BOOKS = By.xpath("//div[@id= 'nav-xshop']/a[text()= 'Books']");
    private final By BOOK_LINK = By.xpath("//a[@class= 'a-link-normal octopus-pc-item-link']");
    private final By MENU_RATINGS_COUNT = By.xpath("//span[@class ='a-size-mini a-color-tertiary']");
    private final By BOOKPAGE_RATINGS_COUNT = By.id("acrCustomerReviewText");
    private final By PROCEED_TO_RATINGS = By.xpath("//div[@id= 'reviews-medley-footer']/div[(@class= 'a-row a-spacing-medium')]/a");
    private final By MENU_STARS_COUNT = By.xpath("//i[contains(@class, 'a-star-mini')]");
    private final By BOOKPAGE_STARS_COUNT = By.xpath("//span[(@class= 'a-icon-alt')]/parent::i");
    private final By REVIEWS_COUNT_DISPLAYED = By.xpath("//div[@id= 'filter-info-section']/div");
    private final By EVERY_REVIEW_BLOCK = By.xpath("//div[contains(@id,  '-review-card')]");
    private final By NEXT_PAGE_LINK = By.xpath("//li[@class = 'a-last']/a");
    private final By NEXT_PAGE_AVAILABLE = By.xpath("//li[@class = 'a-last']");
    private final By NO_NEXT_PAGE_LINK = By.xpath("//li[@class = 'a-disabled a-last']");

    String ratingsInMenu;
    String ratingsOnBookpage;
    String starsOnBookpage;
    String starsInMenu;
    String starsInMenuShort;
    String starsOnBookpageShort;
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

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_BEST_SELLERS));
        browser.findElement(PROCEED_TO_BEST_SELLERS).click();

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_BOOKS));
        browser.findElement(PROCEED_TO_BOOKS).click();

        //------------------ Working with book Nr. 4 (in menu) --------------

        List<WebElement> links = browser.findElements(BOOK_LINK);
        List<WebElement> menuRatings = browser.findElements(MENU_RATINGS_COUNT);
        List<WebElement> menuStars = browser.findElements(MENU_STARS_COUNT);


        ratingsInMenu = (menuRatings.get(3).getText());
        ratingsInMenuFull = (ratingsInMenu + " ratings");
        starsInMenu = (menuStars.get(3)).getAttribute("class");

        links.get(4).click(); //click on book position. change it to check if the program works with stars and ratings

        //----------- Working with book Nr. 4 (on Book's page) -------------


        ratingsOnBookpage = browser.findElement(BOOKPAGE_RATINGS_COUNT).getText();
        starsOnBookpage = (browser.findElement(BOOKPAGE_STARS_COUNT).getAttribute("class"));


        //------------------ Ratings and stars print and  compare ---------

        System.out.println("Ratings in menu: " + ratingsInMenuFull);
        System.out.println("Ratings on book's page: " + ratingsOnBookpage);

        if (ratingsInMenu.equals(ratingsOnBookpage)) {
            System.out.println("Ratings are equal");
        } else {
            System.out.println("Ratings are different");
        }

        System.out.println(" ");

        starsInMenuShort = starsInMenu.substring(36);//end of class with stars to compare
        System.out.println("Stars in menu: " + starsInMenuShort);
        starsOnBookpageShort = starsOnBookpage.substring(26);//end of class with stars to compare
        System.out.println("Stars on book's page: " + starsOnBookpageShort);

        if (starsInMenuShort.equals(starsOnBookpageShort)) {
            System.out.println("Star counts are equal");
        } else {
            System.out.println("Star counts are different");
        }

        //--------------- Reviews count and  compare ------------

        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_RATINGS));
        browser.findElement(PROCEED_TO_RATINGS).click();

        reviewsOnReviewPage = browser.findElement(REVIEWS_COUNT_DISPLAYED).getText();//get reviews count displayed on page

        for (int i = 0; i < 100000; i++) {              //page change routine (max - 100000 pages)
            List<WebElement> reviewInList = browser.findElements(EVERY_REVIEW_BLOCK);
            for (WebElement we : reviewInList) {        //reviews counting on page routine

                reviewsCounted = reviewsCounted + 1;
//                System.out.println(reviewsCounted);
//                System.out.println("");
            }
            if (browser.findElements(NO_NEXT_PAGE_LINK).size() == 0) {          //check if last page
                if (browser.findElements(NEXT_PAGE_AVAILABLE).size() != 0) {     //additional check for 10 reviews only
                    wait.until(ExpectedConditions.elementToBeClickable(NEXT_PAGE_LINK));
                    browser.findElement(NEXT_PAGE_LINK).click();
                } else {
                    break;
                }
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
        if (reviewsDisplayedToPrint.equals(reviewsCountedToPrint)) {
            System.out.println("Reviews counts are equal");
        } else {
            System.out.println("Reviews counts are different");
        }
    }
}

