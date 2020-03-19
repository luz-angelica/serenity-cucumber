package searchPage.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import org.junit.Assert;
import searchPage.pageObject.PrincipalPage;
import searchPage.pageObject.ResultPage;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class StepDefinitions {

    @Steps
    PrincipalPage principalPage;
    @Steps
    ResultPage resultPage;

    @Given("^The User open the Page$")
    public void the_User_open_the_Page() {
        principalPage.setDefaultBaseUrl("http://3.87.50.247:3000");
        principalPage.open();
    }


    @When("^The User clicks an input and does not enter any value$")
    public void the_User_clicks_an_input_and_does_not_enter_any_value() {
        principalPage.validation();

    }

    @Then("^The user should see a required message$")
    public void the_user_should_see_a_required_message() {
        List<String> results = resultPage.getResult();
        results.replaceAll(String::toLowerCase);
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).equals("")) {
                results.remove(i);
            }
        }
        assertThat(results, Matchers.everyItem(containsString("obligatori")));
    }


    @Then("^The user can not create an account$")
    public void the_user_can_not_create_an_account() {
        try{
        String firstMsg = principalPage.getAlert().getText();
        Assert.assertFalse(firstMsg.contains("Bienvenido"));
        } catch (Exception e) {
            System.out.print("No hace validación");
        }

}
}
