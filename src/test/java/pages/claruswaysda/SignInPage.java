package pages.claruswaysda;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class SignInPage {
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath= "//input[@type='submit']")
    private WebElement submitButton;

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void enterName(String name){
        usernameField.clear();
        usernameField.sendKeys(name);
    }
    public void enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit(){
        submitButton.click();
    }

    public String userNameEmptyErrorMessage() {
        return usernameField.getAttribute("validationMessage");
    }

    public String passwordNameEmptyErrorMessage() {
        return passwordField.getAttribute("validationMessage");
    }
    public String invalidUserAlertMessage() {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        String text = Driver.getDriver().switchTo().alert().getText();
        Driver.getDriver().switchTo().alert().accept();
        return text;
    }

    public boolean isUsernameEmpty() {
        return usernameField.getDomProperty("value").isEmpty();
    }

}