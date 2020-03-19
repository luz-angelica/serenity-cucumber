package searchPage.pageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends PageObject {


    @FindBy(tagName = "error")
    List<WebElement> errors;

    public List<String> getResult(){
        return errors
                .stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());

    }

}
