package pages;

import dto.Board;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MyBoardPage extends BasePage{
    public MyBoardPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    @FindBy(xpath = "//span[@data-testid='OverflowMenuHorizontalIcon']")
    WebElement btnDots;

    @FindBy(xpath = "//ul/li[last()]/button")
    WebElement btnCloseBoard;

    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnCloseBoardConfirm;

    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;

    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-confirm-button']")
    WebElement btnDeleteBoardConfirm;

    public boolean validateBoardName(String text, int time){
        return validateTextInElementWait(boardName, text, time);
    }

    public void deleteBoard(){
        btnDots.click();
        btnCloseBoard.click();
        btnCloseBoardConfirm.click();
        pause(5);
        btnDots.click();

//        clickWait(btnDots, 5);
        btnDeleteBoard.click();
        pause(3);
        btnDeleteBoardConfirm.click();
    }

}
