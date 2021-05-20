package base;

import actions.BrowserActions;
import com.google.common.io.Files;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.HomePage;
import wrappers.PropertiesFileReader;

import java.io.File;
import java.io.IOException;

public class BaseTests extends AbstractTestNGCucumberTests
{


    protected static WebDriver driver;
    private BrowserActions browserActions =new BrowserActions();
    protected static HomePage homePage;

    /****************************** using properties file *******************************/
    private String URL= PropertiesFileReader.getValue("url");
    private String browser= "chrome";


    /*********** using surefire to run using command window ***********/
    /*@Parameters("browser")
    public void setUp(String browser)*/

    @BeforeClass
    public void setUp()
    {
        driver= browserActions.driverInit(browser,false);
        browserActions.maximizeWindow();
        browserActions.navigateToURL(URL);
        homePage= new HomePage(driver);
    }

    @AfterClass
    public void tearDown()
    {

        driver.quit();
    }

    /****************** Take screenshot of the failure *************************/
    /*@AfterMethod
    public void failureRecorder(ITestResult result)
    {
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera= (TakesScreenshot)driver;
            File image=camera.getScreenshotAs(OutputType.FILE);
            try {
                //result.getName() returns the name of the failed method
                Files.move(image,new File("resources/screenshots/"+ result.getName()+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }*/
}
