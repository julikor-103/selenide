import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleResultPage {

    public ElementsCollection results() {
        return $$("ires li.g");

    }
}
