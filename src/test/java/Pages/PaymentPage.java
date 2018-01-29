package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage {
    @FindBy(how = How.CSS, using = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    public WebElement paymentMethodBtn;


    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
