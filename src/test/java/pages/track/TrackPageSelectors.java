package pages.track;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Getter

public class TrackPageSelectors {


   private SelenideElement src= $(byAttribute("alt","Not found"));
}
