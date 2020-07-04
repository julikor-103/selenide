import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import java.util.Random;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SignUpTest {

    @BeforeClass
    public static void setUp() {
        open("http://google.com");
        $(By.name("q")).setValue("AutomationPractice").pressEnter();
        $(By.partialLinkText("Automation Practice")).pressEnter();
    }

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();

    @Test
    public void checkTittle() {
        $("title").shouldHave(attribute("text", "Search - My Store"));
    }

    @Test
    public void checkSearchByKeysWordsReturnCorrectNumberOfResultsTest() {
        $(By.id("search_query_top")).sendKeys("dress");
        $(By.name("submit_search")).click();
        $$("li.ajax_block_product").shouldHave(size(7));
    }

    @Test
    public void createAnAccauntTest() {
        goToRegistrationPage();
        registerEmail();

        $(By.name("id_gender")).click();
        $(By.id("customer_firstname")).sendKeys("value", "Julikor");
        $(By.id("customer_lastname")).sendKeys("value", "Korytina");

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        String pass = "qwerty" + n + "Q";
        System.out.println(pass);

        $(By.id("passwd")).sendKeys("value", pass);
        $(By.id("days")).sendKeys("value", "5");
    }

    private void goToRegistrationPage() {
        $(By.className("nav"));
        $(By.className("login")).click();
        $(By.id("email_create"));
    }

    private void registerEmail() {
        {
            Random random = new Random();
            int n = random.nextInt(100) + 1;
            String email = "julikor" + n + "@gmail.com";
            System.out.println(email);
            $(By.id("email_create")).sendKeys("value", email);
            $(By.id("SubmitCreate")).click();
            $(By.name("id_gender"));

        }
    }
}


