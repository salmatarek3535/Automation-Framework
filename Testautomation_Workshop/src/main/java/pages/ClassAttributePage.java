package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClassAttributePage {

    protected static WebDriver driver;
    private static final By primaryButtonLocator= By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]\n");

    public ClassAttributePage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void pressOnPrimaryButton()
    {
        try
        {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(primaryButtonLocator));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.findElement(primaryButtonLocator).click();
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
