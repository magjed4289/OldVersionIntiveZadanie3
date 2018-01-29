package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class BankWirePaymentPage {
    @FindBy(how = How.CSS, using = "#cart_navigation > button > span")
    public WebElement confirmOrder;

    public BankWirePaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
