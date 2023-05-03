package pages;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxDataPage {

    protected static WebDriver driver;
    private static UIActions uiActions;
    private static final By ajaxButtonLocator= By.id("ajaxButton");
    private static final By dataLoadedWithAjaxLocator= By.className("bg-success");

    public AjaxDataPage(WebDriver driver)
    {
        this.driver= driver;
        uiActions= new UIActions(driver);
    }

    public void triggerAjaxRequest()
    {
        uiActions.clickOnElement(ajaxButtonLocator);
        uiActions.waitForElement(dataLoadedWithAjaxLocator, "presence");
        uiActions.clickOnElement(dataLoadedWithAjaxLocator);
    }
}
