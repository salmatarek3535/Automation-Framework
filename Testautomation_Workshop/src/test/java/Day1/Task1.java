package Day1;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task1 {


    private WebDriver driver;
    private String menu="Learning Center";
    private By link= By.xpath("//a[text()=\""+menu+"\"]");

    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.levelset.com/");
    }
    @Test
    public void task1()
    {
        driver.findElement(link).click();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
