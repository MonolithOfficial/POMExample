package ge.tbc.tbcacademy.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcacademy.pages.PricingPage;
import ge.tbc.tbcacademy.util.TableHandler;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingSteps extends CommonSteps {
    PricingPage pricingPage = new PricingPage();

    @Step("Validate that {0} bundle does NOT support {1} feature.")
    public PricingSteps validateNotSupported(SelenideElement bundle, String feature){
        bundle.shouldNotHave(text(feature));

        return this;
    }

    @Step("Validate that {0} bundle supports {1} feature.")
    public PricingSteps validateSupported(SelenideElement bundle, String feature){
        bundle.shouldHave(text(feature));

        return this;
    }

    @Step("Validate that {0} feature is available in {1} bundle.")
    public PricingSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }

    @Step("Validate that {0} feature is NOT available in {1} bundle.")
    public PricingSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    @Step("Validate that feature {0} in bundle {1} can support {2} instance(s) with {3} user(s).")
    public PricingSteps validateInstancesAndUsers(String forFeature, String inBundle, int instances, int users){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText(String.format("%d instance with %d users", instances, users)));
        return this;
    }

    @Step("Validate that the offer names remain visible despite scrolling down.")
    public PricingSteps checkStickyOfferNameBehavior(SelenideElement... elements){
        executeJavaScript("window.scrollTo(0, 0);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        executeJavaScript("window.scrollBy(0, 2000);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        return this;
    }
}
