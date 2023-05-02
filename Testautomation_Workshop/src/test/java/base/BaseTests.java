package base;

import actions.BrowserActions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import wrappers.PropertiesFileReader;

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
