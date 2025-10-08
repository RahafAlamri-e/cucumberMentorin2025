package pages.evilTester;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class CharValidatorPage {
    public CharValidatorPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='characters']")
    private WebElement chactersField;
    @FindBy(xpath = "//input[@name='validation_message']")
    private WebElement validationMessageField;
    @FindBy(xpath = "//input[@name='validate']")
    private WebElement validateButton;

    public void enterChar(String data){
        chactersField.clear();
        chactersField.sendKeys(data);
    }
    public void clickValidate(){
        validateButton.click();
    }
    public String readValidData(){
        return validationMessageField.getDomProperty("value");
    }
    List<String> validData = new ArrayList<>();
    List<String> inValidData = new ArrayList<>();
    public void validateData(String data,String valid){
        enterChar(data);
        clickValidate();
        String actualresult = readValidData();
        System.out.println("valid = " + valid);
        System.out.println("actualresult = " + actualresult);
        if (actualresult.equals(valid)){
            validData.add(data);
        } else {
            inValidData.add(data);
        }

    }
    public List<String> getValidData(){
        return validData;
    }

    public List<String> getInValidData(){
        return inValidData;
    }

    public boolean isValid(String data) {
        return validationMessageField.getDomProperty("value").equals(data);
    }
}