package searchPage.pageObject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.joda.time.Seconds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Time;
import java.util.List;

public class PrincipalPage extends PageObject {

        @FindBy(id = "id_nombre")
        WebElementFacade lblName;
        @FindBy(id = "id_apellido")
        WebElementFacade lblLastName;
        @FindBy(id ="id_email")
        WebElementFacade lblEmail;
        @FindBy(id = "id_password")
        WebElementFacade lblPws;
        @FindBy(name = "birthdate")
        WebElementFacade lblDate;
        @FindBy(id = "id_genero_mujer")
         WebElementFacade female;
        @FindBy(id = "id_genero_hombre")
        WebElementFacade male;
        @FindBy(tagName = "button")
       WebElementFacade createButton;

        public void validation() {
            lblName.click();
            lblLastName.click();
            lblEmail.click();
            lblPws.click();
            lblDate.click();
           createButton.click();

        }

    public void fillout(String name, String lastname, String email, String psw,String date) {
        lblName.type(name);
        lblLastName.type(lastname);
        lblEmail.type(email);
        lblPws.type(psw);
        lblDate.type(date);
        male.click();

        createButton.click();

    }
}
