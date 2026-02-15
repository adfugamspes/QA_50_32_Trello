package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class DeleteBoardTests extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void loginCreateBoard(){
        HomePage homePage = new HomePage(getDriver());
        User user = User.builder().email("oks.shor729@gmail.com").password("Qwerty!123QA").build();
        homePage.clickBtnLogIn();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(user);
        BoardsPage boardsPage = new BoardsPage(getDriver());
        Board board = Board.builder().boardTitle("23567").build();
        boardsPage.createNewBoard(board);

    }

    @Test
    public void deleteBoard(){
        MyBoardPage myBoardPage = new MyBoardPage(getDriver());
        myBoardPage.validateBoardName("23567", 5);
        myBoardPage.deleteBoard();
    }
}
