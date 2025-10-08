package stepsdefinitions.notesStepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.notesPage.NotesPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class NotesStepDefs {
    NotesPage notesPage = new NotesPage();
    List<Map<String, String>> notes;

    @Given("user goes to {string}")
    public void user_goes_to(String url) {
        notesPage.goToUrl(url);
    }

    @When("user adds the following notes:")
    public void user_adds_the_following_notes(DataTable dataTable) {
        notes = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> note : notes) {
            notesPage.addNote(note.get("title"), note.get("note"));
        }
    }

    @When("user clicks Manage List")
    public void user_clicks_manage_list() {
        notesPage.clickManageList();
    }

    @Then("all notes should be displayed correctly")
    public void all_notes_should_be_displayed_correctly() {
        for (Map<String, String> note : notes) {
            String title = note.get("title");
            String expectedContent = note.get("note");
            String actualContent = notesPage.getNoteContentByTitle(title);

            Assert.assertTrue("Title not displayed: " + title, notesPage.isNoteTitleDisplayed(title));

            Assert.assertEquals("Content mismatch for title: " + title, expectedContent.trim(), actualContent.trim());
        }
    }
}