package com.NextBaseCRM.step_definitions;

import com.NextBaseCRM.pages.ActivityStreamPage;
import com.NextBaseCRM.pages.LoginPage;
import com.NextBaseCRM.utilities.BrowserUtils;
import com.NextBaseCRM.utilities.Driver;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserAttendanceStepDef {



    @Given("User should be able to access url and be able see home page")
    public void user_should_be_able_to_access_url_and_be_able_see_home_page() {

        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

        BrowserUtils.waitFor(2);
        String username = ConfigurationReader.get("helpdesk_username");
        String password = ConfigurationReader.get("helpdesk_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @When("User should be able to make a comment on other employees' posts.")
    public void user_should_be_able_to_make_a_comment_on_other_employees_posts() {

        ActivityStreamPage streamPage = new ActivityStreamPage();
        streamPage.commentButton.click();
        BrowserUtils.waitFor(3);
    /*    streamPage.writeComment.sendKeys("hello there");
        BrowserUtils.waitFor(3);
        streamPage.sendcommentButton.click();
        BrowserUtils.waitFor(5);
*/

    }

    @When("User should be able like on other employees' posts.")
    public void user_should_be_able_like_on_other_employees_posts() {
        ActivityStreamPage streamPage = new ActivityStreamPage();
        streamPage.likeButton.click();
        BrowserUtils.waitFor(5);
    }

    @When("User should be able unfollow on other employees' posts.")
    public void user_should_be_able_unfollow_on_other_employees_posts() {
        ActivityStreamPage streamPage = new ActivityStreamPage();
        streamPage.unfollowButton.click();
        BrowserUtils.waitFor(5);
    }

    @Then("Users should see their comment , like and other employess posts\"")
    public void users_should_see_their_comment_like_and_other_employess_posts() {
        //ActivityStreamPage streamPage = new ActivityStreamPage();
        //Assert.assertTrue(streamPage.likeButton.isSelected());

        System.out.println("hello");
    }



}
