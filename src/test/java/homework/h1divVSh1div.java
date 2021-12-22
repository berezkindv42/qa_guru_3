package homework;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Thread.sleep;

public class h1divVSh1div {

    @Test
    void h1VSh1() throws InterruptedException {

        open("https://github.com/selenide/selenide/wiki");
//        System.out.println($("details[class='details-overlay details-reset position-relative'] div"));
        System.out.println($("details[class='details-overlay details-reset position-relative']").$("div"));

//        sleep(10000);
    }
}
