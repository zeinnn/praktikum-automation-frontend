package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class MainPageSelectors {

    ElementsCollection e = $$(byClassName("accordion"));

    SelenideElement bigString = $(byClassName("Home_Header__iJKdX")),

    title = $(byXpath(".//head/title"));
}
