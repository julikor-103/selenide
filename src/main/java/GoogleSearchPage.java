
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchPage {
    public GoogleResultPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleResultPage.class);
    }
}
