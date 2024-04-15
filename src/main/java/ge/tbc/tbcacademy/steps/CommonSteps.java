package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

public class CommonSteps {

    @Step("Click on {0} element")
    public CommonSteps click(SelenideElement element){
        element.click();

        return this;
    }
}
