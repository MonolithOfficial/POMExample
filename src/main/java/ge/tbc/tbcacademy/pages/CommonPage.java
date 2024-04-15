package ge.tbc.tbcacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class CommonPage {
    public SelenideElement pricingLink = $(byXpath("//a[text()='Pricing' and not(contains(@class,'Footer'))]"));
}
