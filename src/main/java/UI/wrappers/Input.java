package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input extends BaseWrapper {

    public Input(String label) {
        super(label);
    }

    public void write(String text) {
        log.info("Set info for {}: {} ", label, text);
        if (label.equals("Last Name")) {
            $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]" +
                    "//input[@name='lastName']", label))
                    .scrollIntoView(true)
                    .sendKeys(text);
            return;
        }

        if (label.equals("Description")){
            $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]" +
                    "//textarea", label))
                    .scrollIntoView(true)
                    .sendKeys(text);
            return;
        }

        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label))
                .scrollIntoView(true)
                .sendKeys(text);
    }

    public void edit (String text){
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label))
                .scrollIntoView(true)
                .setValue(text);
    }
}