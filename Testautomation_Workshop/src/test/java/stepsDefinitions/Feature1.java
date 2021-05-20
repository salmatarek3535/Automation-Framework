package stepsDefinitions;

import base.BaseTests;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DocumentCreationPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class Feature1 extends BaseTests
{
    //HomePage homePage;
    public DocumentCreationPage create_document;
    private static String document_option4 ="Lien Waiver";

    @Given("you are in the create Document")
    public void you_are_in_the_create_Document()
    {
        ///homePage= new HomePage(driver);
        create_document= homePage.pressCreateDocument();
    }


    @When("you click on required product")
    public void you_click_on_required_product()
    {
        create_document.clickSelector(document_option4);

    }

    @Then("you can assert the price to be free and assert the text")
    public void you_can_assert_the_price_to_be_free_and_assert_the_text()
    //public void assert_price_text_of_product()
    {
        assertEquals(create_document.getPrice1(document_option4),"Free");
        assertEquals(create_document.getText(), document_option4);

    }


}
