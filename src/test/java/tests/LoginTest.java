package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestNGListener;

@Listeners(TestNGListener.class)
public class LoginTest extends AppManager {

    @Test(groups = {"smoke"})
    public void loginPositiveTest(){
        User user = User.builder().email("oks.shor729@gmail.com").password("Qwerty!123QA").build();
        logger.info("login test with user " + user.getEmail() + "   " + user.getPassword());
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogIn();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver()).validateUrl("boards"));
    }
}
