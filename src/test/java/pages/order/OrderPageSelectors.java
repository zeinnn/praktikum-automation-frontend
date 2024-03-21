package pages.order;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class OrderPageSelectors {

    private ElementsCollection subwayCollection= $$(byClassName("Order_Circle__3uWFr")),

    datePickerWeek = $$(byClassName("react-datepicker__day-name"));

    private SelenideElement nameField = $(byAttribute("placeholder","* Имя")),

    surnameField = $(byAttribute("placeholder","* Фамилия")),

    addressField = $(byAttribute("placeholder","* Адрес: куда привезти заказ")),

    subwayField = $(byAttribute("placeholder","* Станция метро")),

    nextButton = $(byClassName("Button_Middle__1CSJM")),

    phoneField = $(byAttribute("placeholder","* Телефон: на него позвонит курьер")),

    calendarButton = $(byAttribute("placeholder","* Когда привезти самокат")),

    commentForCourierField = $(byAttribute("placeholder","Комментарий для курьера")),

    backButton = $(byClassName("Button_Inverted__3IF-i")),

    orderButton = $(byXpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']")),

    orderHeader = $(byClassName("Order_Header__BZXOb")),

    rentDate = $(byClassName("Dropdown-control")),

    ScooterColorText = $(byClassName("Order_Title__3EKne")),

    blackScooterColorCheckbox = $(byId("black")),

    greyScooterColorCheckBox = $(byId("grey")),

    yesOrderConfirmButton = $(byXpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']")),

    noOrderConfirmButton = $(byXpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Нет']"));







}
