package SsCom.pages;

import SsCom.BaseFunc;

import org.openqa.selenium.By;

public class HomePage {

    private final By ACCEPT_COOKIES =
            By.xpath(".//button[@onclick='_cookie_confirm();return false;']");
    private final By LANG_BTN = By.xpath(".//span[@class = 'menu_lang']/a");
    private final By MENU_ITEM = By.id("mtd_97");

    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc)   {
        this.baseFunc = baseFunc;
    }

    public void acceptCookies() {
        baseFunc.click(ACCEPT_COOKIES);
    }

    public void changeLang() {
        baseFunc.click(LANG_BTN);
    }

    public void selectMenuItem()    {
        baseFunc.click(MENU_ITEM);
    }




}
