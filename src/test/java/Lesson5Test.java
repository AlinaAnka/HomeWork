
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Lesson5Test {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void formTest() {
        open("https://github.com");
        $(".HeaderMenu-nav").find(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

    }

    @Test
    void testDragAndDropWithActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        actions().clickAndHold(elementA).moveToElement(elementB).release().perform();
        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));
    }

    @Test
    void testDragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement elementA = $("#column-a");
        SelenideElement elementB = $("#column-b");
        elementA.dragAndDrop(DragAndDropOptions.to(elementB));
        elementA.shouldHave(text("B"));
        elementB.shouldHave(text("A"));
    }
}
