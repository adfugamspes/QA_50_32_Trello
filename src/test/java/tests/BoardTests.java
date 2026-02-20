package tests;

import data_provider.BoardDP;
import dto.Board;
import dto.User;
import io.opentelemetry.sdk.metrics.data.Data;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class BoardTests extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = User.builder().email("oks.shor729@gmail.com").password("Qwerty!123QA").build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogIn();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().boardTitle("23567").build();
        new BoardsPage(getDriver()).createNewBoard(board);
        new MyBoardPage(getDriver()).validateBoardName(board.getBoardTitle(), 5);
    }

    @Test
    public void check(){
        new BoardsPage(getDriver()).openMyAccount();
    }

    @Test(dataProvider = "dataProviderBoards", dataProviderClass = BoardDP.class)
    public void createNewBoardPositiveTest_FromDP(Board board){
        new BoardsPage(getDriver()).createNewBoard(board);
    }




}
