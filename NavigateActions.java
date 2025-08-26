package starter.duckduckgo;

import net.serenitybdd.core.pages.PageObject;

public class NavigateActions extends PageObject {

    public void toTheHomePage() {
        getDriver().get("https://sebass.infinityfreeapp.com");
    }
}
