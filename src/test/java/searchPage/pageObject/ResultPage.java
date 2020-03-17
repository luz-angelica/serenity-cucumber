package searchPage.pageObject;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends PageObject {

    public static final String RESULTS = ".web-bing__title";


    public List<String> getResult(){
        return findAll(RESULTS)
                .stream()
                .map(element -> element.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

}