package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Dropdown extends BaseWrapper{

    public Dropdown(String label) {
        super(label);
    }

    public void select(String option) {
        log.info("Set info for {}: {}", label, option);
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class," +
                " 'slds-grid')]//button", label)).scrollIntoView(true)
                .click();
        $x(String.format("//span[@title='%s']", option)).scrollIntoView(true)
                .click();
    }

}
