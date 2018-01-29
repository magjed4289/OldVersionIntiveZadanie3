package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ShippingStepPage {
    @FindBy(how = How.CSS, using = "#cgv")
    public WebElement checkbox;
    @FindBy(how = How.CSS, using = "#form > p > button > span")
    public WebElement shippingProceedBtn;

    public ShippingStepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}