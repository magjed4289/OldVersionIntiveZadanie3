package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li[1]/div")
    public WebElement item;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
    public WebElement cart;
    @FindBy(how = How.CSS, using = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
    public WebElement chkout;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectItem() {
        item.click();
    }

    public void addToCart() {
        cart.isEnabled();
        cart.click();
    }

    public void cartProceedCheckout() {
        chkout.click();
    }
}