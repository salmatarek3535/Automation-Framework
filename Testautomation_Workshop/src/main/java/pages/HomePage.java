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
        uiActions= new UIActions(driver);
    }

    public ClassAttributePage openClassAttributePage()
    {
        uiActions.waitForElement(classAttributeLocator, "clickable");
        uiActions.waitForElement(classAttributeTextLocator, "presence");

        if(uiActions.getElementText(classAttributeTextLocator).contains("Check that class attribute based XPath is well formed"))
        {
            uiActions.clickOnElement(classAttributeLocator);
        }
        return new ClassAttributePage(driver);
    }

    public DynamicTablePage openDynamicTablePage()
    {
        uiActions.waitForElement(dynamicTableLocator, "clickable");
        uiActions.waitForElement(dynamicTableTextLocator, "presence");

        if(uiActions.getElementText(dynamicTableTextLocator).contains("Verify cell value in a dynamic table"))
        {
            uiActions.clickOnElement(dynamicTableLocator);
        }
        return new DynamicTablePage(driver);
    }
}
