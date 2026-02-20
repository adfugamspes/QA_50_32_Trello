package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class AtlassianProfilePage extends BasePage{
    public AtlassianProfilePage (WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement btnProfilePhoto;

    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement btnChangeAvatar;

    @FindBy(xpath = "//input[@data-testid='image-navigator-input-file']")
    WebElement inputAvatar;

    @FindBy(xpath = "//button[@class='css-u9eekp']")
    WebElement btnUploadAvatar;

    public void changeMyProfilePhoto(String photoPath){
        Actions actions = new Actions(driver);
        actions.moveToElement(btnProfilePhoto).pause(2000).click().perform();
        clickWait(btnChangeAvatar, 5);
        File photo = new File(photoPath);
        inputAvatar.sendKeys(photo.getAbsolutePath());
        clickWait(btnUploadAvatar, 5);
    }

}
