package pages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentCreationPage {

    private WebDriver driver;

    /*private By selector= By.xpath("//div[text()='20-Day Preliminary Notice']");
    private By selector_price1= By.xpath("//div[text()="+'20-Day Preliminary Notice'+"]/..//span[text()='Free']");
    private By selector_price2= By.xpath("//div[text()='Lien / Bond Claim']/..//span[not(text()='Free')]");*/


    public DocumentCreationPage(WebDriver driver)
    {
        this.driver= driver;
    }

    public void clickSelector(String name)
    {
        UIActions action= new UIActions(driver);

        boolean result= action.waitForElement(By.xpath("//div[contains(text(),'"+ name +"')]"),
                "clickable");
        if(result)
        {
            action.clickOnElement(By.xpath("//div[contains(text(),'"+ name +"')]"));
        }
        //action.clickElement(By.xpath("//div[contains(text(),'"+ name +"')]"),"clickable",);

        //driver.findElement(By.xpath("//div[contains(text(),'"+ name +"')]")).click();
    }

    public String getPrice1(String name)
    {
        UIActions action= new UIActions(driver);
        String text="";

        boolean result= action.waitForElement(By.xpath("//div[contains(text(),'"+name+"')]/..//span[contains(text()," +
                "'Free')]"),"clickable");
        if(result)
        {
            text= action.getElementText(By.xpath("//div[contains(text(),'"+name+"')]/..//span[contains(text(),'Free')]"));
        }
       return text;
        //return driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]/..//span[contains(text(),'Free')]")).getText();
    }

    public String getPrice2(String name)
    {
        //return driver.findElement(By.xpath("//div[contains(text(),'"+name+"')]/..//span[not(contains(text(),'Free'))]")).getText();
        UIActions action= new UIActions(driver);
        String text="";

        boolean result= action.waitForElement(By.xpath("//div[contains(text(),'"+name+"')]/..//span[contains(text(),'$')]")
                ,"clickable");
        if(result)
        {
            text= action.getElementText(By.xpath("//div[contains(text(),'"+name+"')]/..//span[contains(text(),'$')]"));
        }
        return text;
    }

    public String getText()
    {
        String text="";
        UIActions action= new UIActions(driver);
        if(action.waitForElement(By.xpath("//div[@class='title']"),"visible"))
        {
            //text= driver.findElement(By.xpath("//div[@class='title']")).getText();
            text= action.getElementText(By.xpath("//div[@class='title']"));

        }
        return text;
    }
}
