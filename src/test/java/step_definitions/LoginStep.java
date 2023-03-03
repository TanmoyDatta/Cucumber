package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertEquals;
import pages.DarazLoginPage;
import static utilities.DriverSetUp.getDriver;

public class LoginStep {
    DarazLoginPage darazLoginPage = new DarazLoginPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        getDriver().get(darazLoginPage.LOGIN_PAGE_URL);
    }
    @Given("User enter valid username {string}")
    public void user_enter_valid_username(String string) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT, string);
    }
    @When("User enter invalid password {string}")
    public void user_enter_invalid_password(String string) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT, string);
    }
    @And("User click on the login button")
    public void user_click_on_the_login_button() {
        darazLoginPage.clickOnElement(darazLoginPage.LOGIN);
    }
    @Then("User should see the error massage {string}")
    public void user_should_see_the_error_massage(String string) {
        assertEquals(darazLoginPage.getElementText(darazLoginPage.ERORR_MASSAGE),string);
    }
    @And("User should be in the login page")
    public void user_should_be_in_the_login_page() {
        assertEquals(getDriver().getTitle(), darazLoginPage.LOGIN_PAGE_TITLE);
    }
    @Given("User enter Invalid username {string}")
    public void user_enter_Invalid_username(String string) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT, string);
    }
    @When("User enter valid password {string}")
    public void user_enter_valid_password(String string) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT, string);
    }
    @When("User enter username {string}")
    public void userEnterUsernameUsername(String username) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT, username);
    }

    @And("User enter password {string}")
    public void userEnterPasswordPassword(String password) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT, password);
    }

    @When("User enter username {string} and password {string}")
    public void userEnterUsernameUsernameAndPasswordPassword(String username, String password) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT, username);
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT, password);
    }

}
