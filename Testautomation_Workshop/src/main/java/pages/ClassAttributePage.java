package pages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ClassAttributePage {

    protected static WebDriver driver;
    private static UIActions uiActions;
    private static final By primaryButtonLocator= By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]\n");

    public ClassAttributePage(WebDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }

    public void pressOnPrimaryButton()
    {
        uiActions.waitForElement(primaryButtonLocator, "clickable");
        driver.findElement(primaryButtonLocator).click();
    }

    public String getALertText()
    {
        return uiActions.getALertText();
    }

    public void closeALert()
    {
        uiActions.closeALert();
    }
}
