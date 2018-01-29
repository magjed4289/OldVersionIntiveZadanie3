package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MyPersonalDetails {
    @FindBy(how = How.CSS, using = "#firstname")
    public WebElement firstName;
    @FindBy(how = How.CSS, using = "#lastname")
    public WebElement lastName;
    @FindBy(how = How.CSS, using = "#email")
    public WebElement emailAddress;
    public MyPersonalDetails(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
