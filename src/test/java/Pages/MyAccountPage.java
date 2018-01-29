package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {
    @FindBy(how = How.CSS, using = "#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a > span")
    public WebElement accDetailsBtn;
    @FindBy(how = How.CSS, using = "#block_top_menu > ul > li:nth-child(2) > a")
    public WebElement productsPageBtn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a")
    public WebElement historyBtn;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}


