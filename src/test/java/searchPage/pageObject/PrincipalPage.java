package searchPage.pageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class PrincipalPage extends PageObject {

        @FindBy(id = "q")
        WebElementFacade lblSearch;
        @FindBy(xpath= "//*[@id='search']/button")
        WebElementFacade btnSearch;

        public void writeword(String word) {
            lblSearch.type(word);
        }

        public void dosearch() {
            btnSearch.click();
        }
    }
