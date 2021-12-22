package homework;

import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson3HomeWork {

    /* 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    Если может - приведите пример, когда.

    2. Разработайте следующий автотест:
    - Откройте страницу Selenide в Github
    - Перейдите в раздел Wiki проекта
    - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    3. (опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
    - Откройте https://the-internet.herokuapp.com/drag_and_drop
    - Перенесите прямоугольник А на место В
    - Проверьте, что прямоугольники действительно поменялись
    */


//        1.
        /* Разница между $("h1 div"); и $("h1").$("div"); есть. В первом случае мы ищем div у которого родитель h1
        и получим первый на странице h1 внутри которого есть div,
        а во втором случае мы сначала ищем h1 и получаем первый h1 на странице, а затем внутри него пытаемся найти div, но его там может и не быть.
         */
    @Test
    void h1DivVsH1Div() {
        open("https://the-internet.herokuapp.com/dynamic_content");
        $(".row a"); // находим "a", у которого родитель class="row"
        $(".row").$("a"); // находим первый класс "row" и внутри него ищем "a", но его там нет :)
    }


//        2.
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
    }


//        3.
    @Test
    void fragAndDropTest() {

        open("https://the-internet.herokuapp.com/drag_and_drop");


    }


}
