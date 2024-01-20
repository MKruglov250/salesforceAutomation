package UI.wrappers;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class AccountInfoParser extends BaseWrapper{

    public AccountInfoParser(String label) {
        super(label);
    }

    public String getDisplayedText() {
        return $x(String.format("//p[text()='%s']/following-sibling::p/descendant::lightning-formatted-text", label))
                .shouldBe(visible)
                .getText();
    }

    public String getLinkText() {
        if(label.equals("Account Name")) {
            return $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a/descendant::span", label))
                    .shouldBe(visible)
                    .getText();
        }

        if (label.equals("Phone (2)")) {
            return $x("//a[contains(@href,'tel')]")
                    .shouldBe(visible)
                    .getText();
        }

        return $x(String.format("//p[text()='%s']/following-sibling::p/descendant::a", label))
                .getText();
    }

    public String getContactTitle() {
        return $x("//slot[@name='primaryField']/descendant::lightning-formatted-text").getText();
    }
}