package searchPage.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import searchPage.pageObject.PrincipalPage;
import searchPage.pageObject.ResultPage;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class StepDefinitions {
    String actor;

    @Steps
    PrincipalPage principalPage;
    @Steps
    ResultPage resultPage;

    @Given("^The User open the Page$")
    public void the_User_open_the_Page() {
        principalPage.setDefaultBaseUrl("https://www.dogpile.com/");
        principalPage.open();
    }


    @When("^The User does a search: (.*)$")
    public void the_User_does_a_search_rock_nacional(String word) {
        principalPage.writeword(word);
        principalPage.dosearch();
    }

    @Then("^The user would can see results with the word: (.*)$")
    public void the_user_would_can_see_results_with_the_word_rock(String wordShow) {
        List<String> results = resultPage.getResult();
        results.replaceAll(String::toLowerCase); //ponertodo en minuscula
        for(int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
        assertThat(results, Matchers.everyItem(containsString(wordShow)));
    }

}
