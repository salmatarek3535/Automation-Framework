package testCases;

import base.BaseTest;
import browserActions.BrowserUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ClassAttributePage;
import pages.DynamicTablePage;
import pages.HomePage;

public class WebTestCases extends BaseTest {

    private static WebDriver driver;
    private HomePage homePage;
    private BrowserUtilities browserUtilities= new BrowserUtilities();
    private static String baseURL="http://www.uitestingplayground.com/";

    @BeforeMethod
    public void setUp()
    {
        driver = browserUtilities.openBrowser(baseURL);
        homePage= new HomePage(driver);
    }

    @Test
    public void validateClassAttribute()
    {
        ClassAttributePage classAttributePage= homePage.openClassAttributePage();
        classAttributePage.pressOnPrimaryButton();
        Assert.assertEquals(classAttributePage.getALertText(),"Primary button pressed");
        classAttributePage.closeALert();
    }

    @Test
    public void verifyCellValue_DynamicTable()
    {
        String browser= "Chrome";
        DynamicTablePage dynamicTablePage= homePage.openDynamicTablePage();
        String cpuValueInTaskTable = dynamicTablePage.getCPUValueInTaskTable(browser);
        String cpuValue= dynamicTablePage.getCPUValue();
        Assert.assertTrue(cpuValue.contains(cpuValueInTaskTable));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
