import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy  = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000

    }



    @Test
    void successfulLoginWithPressEnter() {
        String name = "Alina";
        String email = "alina@mail.ru";
        String currentAddress = "moscow55";
        String permanentAddress = "piter77";

        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue(email).pressEnter();
        $("#currentAddress").setValue(currentAddress).pressEnter();
        $("#permanentAddress").setValue(permanentAddress).pressEnter();
        $("#submit").click();


        $("#name").shouldHave(text(name));
        $("#email").shouldHave(text(email));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));
    }
}