package UI.wrappers;

import lombok.extern.log4j.Log4j2;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class InputWithSuggestion extends BaseWrapper{

    public InputWithSuggestion(String label) {
        super(label);
    }

    public void inputSuggestion(String text) {
        log.info("Set info for {}: {}", label, text);
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label))
                .scrollIntoView(true)
                .sendKeys(text);
        $x(String.format("//lightning-base-combobox-formatted-text[@title='%s']", text))
                .scrollIntoView(true)
                .shouldBe(visible)
                .click();
    }
}