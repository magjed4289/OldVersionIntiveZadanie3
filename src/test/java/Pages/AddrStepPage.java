package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AddrStepPage {
    @FindBy(how = How.CSS, using = "#center_column > form > p > button > span")
    public WebElement addressProceedBtn;


    public AddrStepPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}