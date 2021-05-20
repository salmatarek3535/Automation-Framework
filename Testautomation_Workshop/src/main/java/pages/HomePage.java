package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import actions.UIActions;
import wrappers.PropertiesFileReader;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class HomePage {

    private WebDriver driver;
    //private WebElement element;
    //private By locator= By.xpath("//a[text()='Create a Document ']");
    /****************************** using properties file *******************************/
    private By locator= By.xpath(PropertiesFileReader.getValue("homePageLocator"));
    private By selector= By.xpath("//div[text()='20-Day Preliminary Notice']");

    public HomePage( WebDriver driver)
    {
        this.driver= driver;
    }

    public DocumentCreationPage pressCreateDocument()
    {
        UIActions click_action= new UIActions(driver);
        click_action.clickElement(locator,"clickable",selector,"presence");

        /*int i=0;

        do
        {
            element=(new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(locator)));
            i++;

        }while(element==null && i<3);

        if(element!=null)
        {
            element.click();
        }
        else
        {
            Assert.fail("Error");
        }*/
        return new DocumentCreationPage(driver);
    }

}
