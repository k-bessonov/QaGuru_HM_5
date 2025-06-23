import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void SolutionsClickTest() {

        open("/");
        $("#hero-section-brand-heading").shouldHave(text("Build and ship software on a single, collaborative platform"));

        $(byTagAndText("button", "Solutions")).hover(); //Можно еще использовать withTagAndText
        $(byTagAndText("a", "Enterprise")).click();

        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

}
