package sscom;

import sscom.pages.CarSelectPage;
import sscom.pages.HomePage;
import org.junit.jupiter.api.Test;

public class ssComSearch {
    private final String URL = "http://www.ss.lv/";

    private BaseFunc baseFunc = new BaseFunc();

    @Test

    public void ssComItemSearch() {
        baseFunc.openUrl(URL);
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();
        homePage.changeLang();
        homePage.selectMenuItem();

        CarSelectPage carSelectPage = new CarSelectPage(baseFunc);
        carSelectPage.selectManufacturer();
        carSelectPage.selectModel();


    }


}