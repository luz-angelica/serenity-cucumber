package searchPage.pageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends PageObject {


    @FindBy(className = "error")
    List<WebElement> errors;

    @FindBy(tagName = "button")
    WebElementFacade createButton;



    public List<String> getResult(){
        return errors
                .stream()
                .map(element -> element.getText())
            .collect(Collectors.toList());

    }

    public boolean getAlertMessage(){

        try {  getDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }

    }

}
