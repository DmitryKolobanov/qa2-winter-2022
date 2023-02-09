package MyFitnessBook;

import MyFitnessBook.model.User;
import MyFitnessBook.pages.ConfirmationPage;
import MyFitnessBook.pages.HomePage;
import MyFitnessBook.pages.TrainingSelectPage;
import org.junit.jupiter.api.Test;

public class MyFitnessBooking {

    private final String URL = "http://www.myfitness.lv/";
//    private final String CLUB_TIMETABLE = "https://www.myfitness.lv/club/sky-more/nodarbibu-saraksts/";

    private MyFitnessBook.BaseFunc baseFunc = new BaseFunc();

@Test

    public void myFitnessGroupTrainingReservation ()  {

    User user = new User("kolobokd@gmail.com", "");

    baseFunc.openUrl(URL);
    HomePage homePage = new HomePage(baseFunc);
    homePage.acceptCookies();
//    baseFunc.openUrl(URL);
    baseFunc.pageRefresh();
    homePage.goToLogin();

    homePage.fillInUserLogin(user);
    homePage.submitLogin();
    homePage.selectGym();
    homePage.clubTimetable();

    TrainingSelectPage trainingSelectPage = new TrainingSelectPage(baseFunc);
    trainingSelectPage.selectTraining();

    ConfirmationPage confirmationPage = new ConfirmationPage(baseFunc);
    confirmationPage.confirmSelectedTraining();
//    Assertions.assertTrue(confirmationPage.isReservationAccepted(), "Incorrect text!");
    confirmationPage.closeConfirmation();
}

//    @AfterEach
//    public void closeBrowser() {
//        baseFunc.closeBrowser();
//    }

}
