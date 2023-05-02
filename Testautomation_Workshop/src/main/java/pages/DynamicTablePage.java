package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicTablePage {

    protected static WebDriver driver;
    private static final String dynamicTableLocator= "//div[@role=\"row\"]/span[@role=\"cell\" and text()=\"%s\"]/following-sibling::span";
    private static By cpuLocatorInTable= null;
    private static final By cpuLocator= By.cssSelector(".bg-warning");

    public DynamicTablePage(WebDriver driver)
    {
        this.driver= driver;
    }

    public String getCPUValueInTaskTable(String browser)
    {
        int index=1;
        String dynamicTableLocatorFormatted= String.format(dynamicTableLocator, browser);
        System.out.println(dynamicTableLocatorFormatted);
        List<WebElement> browserOptions= driver.findElements(By.xpath(dynamicTableLocatorFormatted));
        for (WebElement element:browserOptions)
        {
            if(element.getText().contains("%"))
            {
                System.out.println(element.getText());
                cpuLocatorInTable= By.xpath(String.format(dynamicTableLocatorFormatted + "[%s]",index));
                break;
            }
            index++;
        }

        String cpuValue= driver.findElement(cpuLocatorInTable).getText();
        System.out.println(cpuValue);
        return cpuValue;
    }

    public String getCPUValue()
    {
        System.out.println(driver.findElement(cpuLocator).getText());
        return driver.findElement(cpuLocator).getText();
    }

}
