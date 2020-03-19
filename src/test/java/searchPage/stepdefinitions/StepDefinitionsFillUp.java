package searchPage.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import searchPage.pageObject.PrincipalPage;
import searchPage.pageObject.ResultPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class StepDefinitionsFillUp {

    @Steps
    PrincipalPage principalPage;
    @Steps
    ResultPage resultPage;


    @When("^The User fill out the form$")
    public void the_User_fill_out_the_form() throws InterruptedException {
     principalPage.fillout("Andrea","Garcia", "andrea.garcia@gmail.com", "A203040","2020-03-18");
    }


    @Then("^The user create new account$")
    public void the_user_create_new_account() {

       try{
           principalPage.createAccount();
           String firstMsg = principalPage.getAlert().getText();
           System.out.print(firstMsg);
            Assert.assertTrue(firstMsg.contains("Bienvenido"));
           principalPage.getAlert().accept();
           } catch (Exception e) {
               System.out.print("Su cuenta no se ha creado");
           }



    }
}
