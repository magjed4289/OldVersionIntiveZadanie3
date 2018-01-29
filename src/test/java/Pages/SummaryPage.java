package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SummaryPage {
    @FindBy(how = How.CSS, using = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    public WebElement summaryProceedBtn;


    public SummaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}