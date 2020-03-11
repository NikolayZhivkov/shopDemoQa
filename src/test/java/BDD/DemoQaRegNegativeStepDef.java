package BDD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoQaRegNegativeStepDef {

    private static final By LOC_MY_ACCOUNT = By.xpath("//ul[@class=\"pull-right noo-topbar-right\"]//li[2]");
    private static final By LOC_USERNAME = By.id("reg_username");
    private static final By LOC_EMAIL_ADDRESS = By.id("reg_email");
    private static final By LOC_PASSWORD = By.id("reg_password");
    private static final By LOC_REGISTER_BUTTON = By.xpath("//p[@class=\"woocommerce-FormRow form-row\"]//button[@class=\"woocommerce-Button woocommerce-button button woocommerce-form-register__submit\"]");
    private static final By LOC_ERROR_USERNAME = By.xpath("//ul[@class=\"woocommerce-error\"]//li[1]//strong");

    @Given("the user is on the user homepage and navigate to My Account button")
    public void the_user_is_on_the_user_homepage_and_navigate_to_My_Account_button() throws InterruptedException {
        Browser.driver.get("http://shop.demoqa.com/");
        Browser.driver.findElement(By.xpath("//p[@class=\"woocommerce-store-notice demo_store\"]//a[@href=\"#\"]")).click();
        Thread.sleep(5000);

        Browser.driver.findElement(LOC_MY_ACCOUNT).click();
        String myAccountTitle = Browser.driver.getTitle();
        Assert.assertEquals(myAccountTitle, "My Account – ToolsQA Demo Site", "Opps wrong page!!");
    }


    @When("user enter {string},{string} and {string}")
    public void user_enter_and(String username, String emailAddress, String password) throws InterruptedException {
        Thread.sleep(5000);
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_EMAIL_ADDRESS).sendKeys(emailAddress);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_REGISTER_BUTTON).click();
    }

    @Then("error message should be located with text {string}")
    public void error_message_should_be_located_with_text(String error) {
        WebElement usernameErrorMessage = Browser.driver.findElement(LOC_ERROR_USERNAME);
        usernameErrorMessage.getText();
        Assert.assertTrue(usernameErrorMessage.isDisplayed());
    }

}
