package actions;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class BrowserActions {

   private WebDriver driver;
   //private WebElement element;
   private By locator= By.id("title");

   public WebDriver driverInit(String browser, boolean headless)
   {

       switch(browser)
       {
            case "chrome":
                /** no need to use WebDriverManager in selenium4, it is already included in Selenium4 **/
                //WebDriverManager.chromedriver().setup();
                if(headless)
       		    driver= new ChromeDriver((ChromeOptions) runHeadless(browser));
                else
                driver= new ChromeDriver();
               /*System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
               driver = new ChromeDriver();*/
               break;
               
           case "firefox":
               /** no need to use WebDriverManager in selenium4, it is already included in Selenium4 **/

               //WebDriverManager.firefoxdriver().setup();
	       /*System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");*/
               if(headless)
	            driver = new FirefoxDriver((FirefoxOptions) runHeadless(browser));
               else
                driver = new FirefoxDriver();
	       break;
       }
       return driver;

		  
}

   public void maximizeWindow()
   {
       driver.manage().window().maximize();
   }

   public void navigateToURL(String URL)
   {
       UIActions action= new UIActions(driver);
       boolean result= false;
       int i=0;
       do
       {
           driver.get(URL); //navigate
           //element=(new WebDriverWait(driver,15).until(ExpectedConditions.presenceOfElementLocated(locator)));
            result= action.waitForElement(locator,"presence");
           i++;

       }while(result!= true && i<3);

   }

   public void quitBrowser(WebDriver driver1)
   {
       driver1.quit();
   }

    /**
     * This function is used to run headless
     * @return
     */
    private Object runHeadless(String browser)
    {
        switch(browser)
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);
                return options;

            case "firefox":
                FirefoxOptions options1= new FirefoxOptions();
                options1.setHeadless(true);
                return options1;

            default:
                return null;
        }

    }
}
