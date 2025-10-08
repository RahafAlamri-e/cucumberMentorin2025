package pages.notesPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class NotesPage {

    @FindBy(id = "note-title-input")
    private WebElement titleInput;

    @FindBy(id = "note-details-input")
    private WebElement noteInput;

    @FindBy(id = "add-note")
    private WebElement addButton;

    @FindBy(id = "manage-storage-link")
    private WebElement manageListLink;

    private String noteTitleXPath = "//p[@class='title-note-in-list' and text()='%s']";

    private final String summaryByKeyXPath = "//details[@data-key='%s']/summary";

    private final String contentByKeyXPath = "//details[@data-key='%s']/p";


    public NotesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToUrl(String url) {
        Driver.getDriver().get(url);
    }

    public void addNote(String title, String note){
        titleInput.clear();
        titleInput.sendKeys(title);
        noteInput.clear();
        noteInput.sendKeys(note);
        addButton.click();
    }

    public void clickManageList(){
        manageListLink.click();
    }

    public boolean isNoteTitleDisplayed(String title){
        return Driver.getDriver().findElement(By.xpath(String.format(noteTitleXPath, title))).isDisplayed();
    }

    public String getNoteContentByTitle(String title) {
        WebElement titleElement = Driver.getDriver().findElement(By.xpath(String.format(noteTitleXPath, title)));
        String dataKey = titleElement.getAttribute("data-key");

        WebElement summaryElement = Driver.getDriver().findElement(By.xpath(String.format(summaryByKeyXPath, dataKey)));
        summaryElement.click();

        WebElement pElement = Driver.getDriver().findElement(By.xpath(String.format(contentByKeyXPath, dataKey)));
        return pElement.getText();
    }
}