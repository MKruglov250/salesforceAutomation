package UI.wrappers;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class InputWithSuggestion extends BaseWrapper{

    public InputWithSuggestion(String label) {
        super(label);
    }

    public void inputSuggestion(String text) {
        log.info("Set info for {}: {}", label, text);
        SelenideElement inputSug = $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label));
        inputSug.scrollIntoView(true).sendKeys(text);
        inputSug.click();
        inputSug.sendKeys(Keys.DOWN);
        inputSug.sendKeys(Keys.DOWN);
        inputSug.sendKeys(Keys.RETURN);
    }
}