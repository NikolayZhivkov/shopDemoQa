package BDD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoqaRegistrationStepDef {
    private static final By LOC_MY_ACCOUNT = By.xpath("//ul[@class=\"pull-right noo-topbar-right\"]//li[2]");
    private static final By LOC_USERNAME = By.id("reg_username");
    private static final By LOC_EMAIL_ADDRESS = By.id("reg_email");
    private static final By LOC_PASSWORD = By.id("reg_password");
    private static final By LOC_REGISTER_BUTTON = By.xpath("//p[@class=\"woocommerce-FormRow form-row\"]//button[@class=\"woocommerce-Button woocommerce-button button woocommerce-form-register__submit\"]");
    private static final By LOC_USERNAME_LOGIN = By.id("user_login");
    private static final By LOC_PASSWORD_LOGIN = By.id("user_pass");
    private static final By LOC_LOG_IN_BUTTON = By.id("wp-submit");


    @Given("the user is on the user homepage")
    public void the_user_is_on_the_user_homepage() {
        Browser.driver.get("http://shop.demoqa.com/");
    }

    @Given("the user navigate to My Account and Register platform")
    public void the_user_navigate_to_My_Account_and_Register_platform() throws InterruptedException {
        Browser.driver.findElement(By.xpath("//p[@class=\"woocommerce-store-notice demo_store\"]//a[@href=\"#\"]")).click();
        Thread.sleep(5000);

        Browser.driver.findElement(LOC_MY_ACCOUNT).click();
        String myAccountTitle = Browser.driver.getTitle();
        Assert.assertEquals(myAccountTitle, "My Account – ToolsQA Demo Site", "Opps wrong page!!");

    }

    @When("the user enter username {string} , {string} and {string}")
    public void the_user_enter_username_and(String username, String emailAddress, String password) throws InterruptedException {
        Thread.sleep(5000);
        Browser.driver.findElement(LOC_USERNAME).sendKeys(username);
        Browser.driver.findElement(LOC_EMAIL_ADDRESS).sendKeys(emailAddress);
        Browser.driver.findElement(LOC_PASSWORD).sendKeys(password);
        Browser.driver.findElement(LOC_REGISTER_BUTTON).click();
        String logInTitle = Browser.driver.getTitle();
       // Assert.assertEquals(logInTitle, "My Account – ToolsQA Demo Site", "Something is wrong!!!");
    }

    @When("the user enter valid information from registration {string} and {string}")
    public void the_user_enter_valid_information_from_registration_and(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        Browser.driver.findElement(LOC_USERNAME_LOGIN).sendKeys(username);
        Browser.driver.findElement(LOC_PASSWORD_LOGIN).sendKeys(password);
//        WebElement checkbox = Browser.driver.findElement(By.id("rememberme"));
//        if (!checkbox.isSelected()) {
//            checkbox.click();
//        }
        Browser.driver.findElement(LOC_LOG_IN_BUTTON).click();
    }

    @Then("the user should successfully made an account")
    public void the_user_should_successfully_made_an_account() {
        String logIntitle = Browser.driver.getTitle();
        Assert.assertEquals(logIntitle, "My Account – ToolsQA Demo Site", "You are not log in!");

    }

}
