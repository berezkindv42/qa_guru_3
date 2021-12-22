package homework;

import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson3HomeWork {

    @Test
    void githubPageShouldHaveJunit5CodeExample() {

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $$(".repo-list").first().$(".v-align-middle").click();
        $("#repository-container-header").$(byText("Wiki")).click();

//        open("https://github.com/selenide/selenide/wiki");

        $("#wiki-pages-box").$(byText("Show 2 more pages…")).scrollTo().click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").$(byText("Using JUnit5 extend test class:")).shouldBe(visible);
        $("#wiki-body").$(byText("@ExtendWith")).shouldBe(visible);


//        sleep(4000);

    }
}
