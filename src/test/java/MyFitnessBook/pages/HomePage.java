package MyFitnessBook.pages;

import MyFitnessBook.BaseFunc;
import MyFitnessBook.model.User;
import org.openqa.selenium.By;

public class HomePage {

    private final By ACCEPT_COOKIES =
            By.xpath(".//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    private final By LOGIN_BTN = By.xpath(".//a[contains(@class, 'link-login' )]");
    private final By LOGIN_USER = By.xpath(".//input[@id = 'login-field-username']");
    private final By LOGIN_PASSWORD = By.xpath(".//input[@id = 'login-field-password']");
    private final By LOGIN_SUBMIT = By.xpath(".//div[@class = 'inner_box']/button[(@type = 'submit')]");
    private final By GYMS = By.id("menu-item-583");
    private final By GYM_NAME = By.id("menu-item-580");
//    private final By CLUB_TIMETABLE = By.xpath(".//a[contains(@class, 'link-timetable')]");
    private final String CLUB_TIMETABLE = "https://www.myfitness.lv/club/sky-more/nodarbibu-saraksts/";

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc)   {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES);
    }

    public void goToLogin() {
        baseFunc.click(LOGIN_BTN);
    }

    public void fillInUserLogin(User user)  {
        baseFunc.type(LOGIN_USER, user.getUserName());
        baseFunc.type(LOGIN_PASSWORD, user.getPassword());
    }
    public void submitLogin()   {
        baseFunc.click(LOGIN_SUBMIT);
    }

    public void selectGym()   {
        baseFunc.hoverElement(GYMS);
        baseFunc.click(GYM_NAME);
    }
    public void clubTimetable() {
        baseFunc.openUrl(CLUB_TIMETABLE);
    }


}
