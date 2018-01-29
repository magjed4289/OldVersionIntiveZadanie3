package Steps;

import Base.BaseUtil;
import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class MyStepdefs extends BaseUtil {
    private static BaseUtil base;

    public MyStepdefs(BaseUtil base) {
        MyStepdefs.base = base;
    }

    @Given("^I am registered with email \"([^\"]*)\"$")
    public void iAmRegisteredWithEmail(String email) {
        base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(base.Driver);
        loginPage.emailRegister(email);
        assertTrue(loginPage.emailTakenMsg.isEnabled());
    }

    @And("^I am authenticated with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iAmAuthenticatedWithUsernameAsAndPasswordAs(String username, String password)

    {
        loginPage = new LoginPage(base.Driver);
        loginPage.authentication(username, password);
    }


    @When("^I go to the 'My Personal Information'$")
    public void iGoToTheMyPersonalInformation() {
        myAccountPage = new MyAccountPage(base.Driver);
        WebDriverWait wait = new WebDriverWait(base.Driver, 10);
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.accDetailsBtn));
        myAccountPage.accDetailsBtn.click();
    }


    @Then("^I should be able to see: first name, last name and email address fields$")
    public void iShouldBeAbleToSeeFirstNameLastNameAndEmailAddressFields() {
        myPersonalDetails = new MyPersonalDetails(base.Driver);
        WebDriverWait wait3 = new WebDriverWait(base.Driver, 10);
        wait3.until(ExpectedConditions.visibilityOf(myPersonalDetails.firstName));
        wait3.until(ExpectedConditions.visibilityOf(myPersonalDetails.lastName));
        wait3.until(ExpectedConditions.visibilityOf(myPersonalDetails.emailAddress));
        assertTrue(myPersonalDetails.firstName.isEnabled());
        assertTrue(myPersonalDetails.lastName.isEnabled());
        assertTrue(myPersonalDetails.emailAddress.isEnabled());


    }

    @And("^I have chosen an item to purchase$")
    public void iHaveChosenAnItemToPurchase() {
        myAccountPage = new MyAccountPage(base.Driver);
        WebDriverWait wait4 = new WebDriverWait(base.Driver, 10);
        wait4.until(ExpectedConditions.elementToBeClickable(myAccountPage.productsPageBtn));
        myAccountPage.productsPageBtn.click();
        productsPage = new ProductsPage(base.Driver);
        wait4.until(ExpectedConditions.elementToBeClickable(productsPage.item));
        productsPage.selectItem();
        wait4.until(ExpectedConditions.elementToBeClickable(productsPage.cart));
        productsPage.addToCart();
        wait4.until(ExpectedConditions.elementToBeClickable(productsPage.chkout));
        productsPage.cartProceedCheckout();
    }


    @When("^I pass all steps and confirmed my order$")
    public void iPassAllStepsAndConfirmedMyOrder() {
        summaryPage = new SummaryPage(base.Driver);
        WebDriverWait wait5 = new WebDriverWait(base.Driver, 25);
        wait5.until(ExpectedConditions.elementToBeClickable(summaryPage.summaryProceedBtn));
        summaryPage.summaryProceedBtn.click();
        addrStepPage = new AddrStepPage(base.Driver);
        wait5.until(ExpectedConditions.elementToBeClickable(addrStepPage.addressProceedBtn));
        addrStepPage.addressProceedBtn.click();
        shippingStepPage = new ShippingStepPage(base.Driver);
        shippingStepPage.checkbox.click();
        shippingStepPage.shippingProceedBtn.click();
        paymentPage = new PaymentPage(base.Driver);
        wait5.until(ExpectedConditions.elementToBeClickable(paymentPage.paymentMethodBtn));
        paymentPage.paymentMethodBtn.click();
        bankWirePaymentPage = new BankWirePaymentPage(base.Driver);
        bankWirePaymentPage.confirmOrder.click();
    }


    @Then("^I should be able to see the order in 'Order history and details' view$")
    public void iShouldBeAbleToSeeTheOrderInOrderHistoryAndDetailsView() {
        orderConfirmPage = new OrderConfirmPage(base.Driver);
        String ordInf = String.valueOf(orderConfirmPage.orderInfo);
        orderConfirmPage.backToAccBtn.click();
        myAccountPage = new MyAccountPage(base.Driver);
        myAccountPage.historyBtn.click();
        historyPage = new HistoryPage(base.Driver);
        String ordRef = String.valueOf(historyPage.orderRef);

        if (ordInf.contains(ordRef)) {
            Assert.assertTrue(true);
        }
    }

    @When("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterEmailAndPassword(String email, String password) {
        loginPage = new LoginPage(base.Driver);
        loginPage.authentication(email, password);
        }

    @Then("^I cannot see 'My Account Page'$")
    public void iCannotSeeMyAccountPage() {
        loginPage = new LoginPage(base.Driver);
        assertTrue(loginPage.btnLogin.isEnabled());
    }

    @And("^I see an alert message with ([^\"]*)$")
    public void iSeeAnAlertMessageWithWord(String word) {
        loginPage = new LoginPage(base.Driver);
        String AlertMessage = loginPage.txtAlertMessage.getText();
        if (AlertMessage.contains(word)) {
            Assert.assertTrue(true);
        }
    }
}