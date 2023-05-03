package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
//import org.testng.Assert;

public class UIActions {

    private WebDriver driver;

    public UIActions(WebDriver driver)
    {
        this.driver= driver;
    }

    public boolean waitForElement(By locator, String waiting_condition)
    {
        WebElement element;
        try
        {
            switch (waiting_condition)
            {
                case "presence":

                    element=(new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.
                            presenceOfElementLocated(locator)));
                    break;

                case "visibility":

                    element=(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.
                            visibilityOfElementLocated(locator)));
                    break;

                case "clickable":
                    element=(new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.
                            elementToBeClickable(locator)));
                    break;
            }

            return true;
        }

        catch (Exception e)
        {
            //Assert.fail();
            System.out.println(e.getMessage());
            return false;
        }

    }

    public List<WebElement> getElementsForSpecificLocator(By locator)
    {
        return driver.findElements(locator);
    }

    public void clickElement(By locator, String waiting_condition, By Expected, String Expected_waiting_condition)
    {
         boolean result= waitForElement(locator,waiting_condition);
         if(result== true)
         {
             //clickOnElement(locator);
             driver.findElement(locator).click();
             result= waitForElement(Expected,Expected_waiting_condition); // put it in the other action
         }
    }

    public void clickOnElement(By locator)
    {
        driver.findElement(locator).click();
    }

    public String getElementText(By locator)
    {
        return driver.findElement(locator).getText();
    }

    public String getALertText()
    {
        return driver.switchTo().alert().getText();
    }
    public void closeALert()
    {
        driver.switchTo().alert().dismiss();
    }


}
