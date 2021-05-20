package Day1;

import base.BaseTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DocumentCreationPage;
import actions.BrowserActions;
import pages.HomePage;
import wrappers.JsonFileReader;
import wrappers.PropertiesFileReader;
import wrappers.SendEmail;

import static org.testng.Assert.assertEquals;

public class DocumentCreateTest extends BaseTests
{

    //Variables

    //private String URL="https://www.levelset.com/";
    /****************************** using properties file *******************************/
    //private String URL= PropertiesFileReader.getValue("url");
    private static String document_option1 ="20-Day Preliminary Notice";
    private static String document_option2 ="Notice of Intent to Lien";
    private static String document_option3 ="Lien / Bond Claim";
    private static String document_option4 ="Lien Waiver";


    //to run using command window


    //@Parameters("browser")



   /* @Test
    public void createDocumentOption1()
    {
        DocumentCreationPage create_document= homePage.pressCreateDocument();
        create_document.clickSelector(document_option1);
        assertEquals(create_document.getPrice1(document_option1),"Free");
        assertEquals(create_document.getText(), document_option1);
    }

    @Test
    public void createDocumentOption2()
    {
        DocumentCreationPage create_document= homePage.pressCreateDocument();
        create_document.clickSelector(document_option2);
        assertEquals(create_document.getPrice1(document_option2),"Free");
        assertEquals(create_document.getText(), document_option2);
    }




    @Test
    public void createDocumentOption4()
    {
        DocumentCreationPage create_document= homePage.pressCreateDocument();
        create_document.clickSelector(document_option4);
        assertEquals(create_document.getPrice1(document_option4),"Free");
        assertEquals(create_document.getText(), document_option4);
    }

    @Test
    public void createDocumentOption3()
    {
        DocumentCreationPage create_document= homePage.pressCreateDocument();
        create_document.clickSelector(document_option3);
        assertEquals(create_document.getPrice2(document_option3),"Free");
        assertEquals(create_document.getText(), document_option3);
    }*/


    /************************* using DataProvider to pass parameters to the test ****************************/

    @DataProvider
    public static Object[] testData()
    {

    	return new Object[]
    			{
    					document_option1,
    					document_option2,
    					//document_option3,
    					document_option4
    			};
    }

    @Test(dataProvider="testData")
    public void createDocumentOption2(String data)
    {
        DocumentCreationPage create_document= homePage.pressCreateDocument();
        create_document.clickSelector(data);
        assertEquals(create_document.getPrice1(data),"Free");
        assertEquals(create_document.getText(), data);
    }


    /*********************** using JsonFileReader to get data ***************************/
    /*@Test
    public void test()
    {
        JsonFileReader file= new JsonFileReader(JsonFileReader.jsonPath);
        Assert.assertEquals("Lien / Bond Claim", file.getValueOfNode("DocumentLocator"));
    }*/

    /**************************** sending Emails ********************************/
    /*@Test
    public void test2()
    {
        SendEmail.sendEmail();
    }*/



}
