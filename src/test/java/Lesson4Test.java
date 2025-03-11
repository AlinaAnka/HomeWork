import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4Test {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";

    }

    @Test
    void formTest() {
        open("/selenide/selenide");
        $("span[data-content='Wiki']").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $$("a.Truncate-text").shouldHave(itemWithText("SoftAssertions"));
        $$("a.Truncate-text").findBy(text("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }

    @Test
    void testDiff() {
        open(getClass().getClassLoader().getResource("test.html"));
        SelenideElement firstH1 = $("div h1");
        assert firstH1.exists();

        SelenideElement directH1 = $("div").$("h1");
        assert !directH1.exists();
    }
}
