package SsCom;

import SsCom.pages.CarSelectPage;
import SsCom.pages.HomePage;
import org.junit.jupiter.api.Test;

public class SsComSearch {
    private final String URL = "http://www.ss.lv/";
//    private final String CLUB_TIMETABLE = "https://www.myfitness.lv/club/sky-more/nodarbibu-saraksts/";

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