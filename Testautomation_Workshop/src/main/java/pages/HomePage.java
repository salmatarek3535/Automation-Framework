package pages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    protected static WebDriver driver;
    protected static UIActions uiActions;
    private static final By classAttributeLocator= By.xpath("//a[text()=\"Class Attribute\"]");
    private static final By classAttributeTextLocator= By.xpath("//a[text()=\"Class Attribute\"]/../following-sibling::p");
    private static final By dynamicTableLocator= By.xpath("//a[text()=\"Dynamic Table\"]");
    private static final By dynamicTableTextLocator= By.xpath("//a[text()=\"Dynamic Table\"]/../following-sibling::p");


    public HomePage(WebDriver driver)
    {
        this.driver= driver;
    }

    public ClassAttributePage openClassAttributePage()
    {
        uiActions= new UIActions(driver);
        uiActions.waitForElement(classAttributeLocator, "clickable");
        uiActions.waitForElement(classAttributeTextLocator, "presence");
//        try
//        {
//            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(classAttributeLocator));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        try
//        {
//            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(classAttributeTextLocator));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        if(uiActions.getElementText(classAttributeTextLocator).contains("Check that class attribute based XPath is well formed"))
        {
            //driver.findElement(classAttributeLocator).click();
            uiActions.clickOnElement(classAttributeLocator);
        }
        return new ClassAttributePage(driver);
    }

    public DynamicTablePage openDynamicTablePage()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(dynamicTableLocator));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(dynamicTableTextLocator));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(driver.findElement(dynamicTableTextLocator).getText().contains("Verify cell value in a dynamic table"))
        {
            driver.findElement(dynamicTableLocator).click();
        }
        return new DynamicTablePage(driver);
    }
}
