package pages.order;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import com.codeborne.selenide.selector.ByText;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;
import elements.DatePicker;
import io.qameta.allure.Attachment;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import static com.codeborne.selenide.Selectors.*;

import javax.imageio.IIOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;
@Getter
public class OrderPage extends OrderPageSelectors {

    DatePicker datePicker = new DatePicker();

    private String name,
            surname,
            address,
            subwayName,
            subwayColor,
            phoneNumber;

    public OrderPage fillNameField(String string) {
        getNameField().sendKeys(string);
        return this;
    }

    public OrderPage fillSurnameField(String string) {
        getSurnameField().sendKeys(string);
        return this;
    }

    public OrderPage fillPhoneField(String string) {
        getPhoneField().sendKeys(string);
        return this;
    }

    public OrderPage fillAddressField(String string) {
        getAddressField().sendKeys(string);
        return this;
    }

    public OrderPage fillSubwayField(String subwayName, String style) {
        getSubwayField().click();
        $(byXpath(".//div[text() = " + "'" + subwayName + "'" + "]/preceding-sibling::div[@style = " + "'" + style + "'" + "]/parent::button")).click();
        return this;

    }

    public OrderPage clickNextButton() {
        getNextButton().click();
        return this;

    }
    public OrderPage clickCalendarButton(){
        getCalendarButton().click();
        return this;
    }

    public OrderPage clickRentDateField(){
        getRentDate().click();
        return this;
    }

    public OrderPage chooseRentDate(String rentDate){
        clickRentDateField();
        $(byXpath(".//div[(@class = 'Dropdown-option' and text() = '"+rentDate+"')]")).shouldHave(Condition.text(rentDate)).scrollTo().click();
        return this;
    }

    public OrderPage fillCommentaryField(String comment){
        getCommentForCourierField().sendKeys(comment);
        return this;
    }
    public OrderPage chooseScooterColorBlack(){
        getBlackScooterColorCheckbox().click();
        return this;
    }

    public OrderPage chooseScooterColorGrey(){
        getGreyScooterColorCheckBox().click();
        return this;
    }

    public OrderPage chooseDayOfWeek(String dayOfTheWeek){
        clickCalendarButton();
        datePicker.chooseDayOfWeek(dayOfTheWeek);
        return this;
    }

    public OrderPage clickOrderButton(){
        getOrderButton().click();
        return this;
    }

    public OrderPage clickYesOrderButton(){
        getYesOrderConfirmButton().click();
        return this;
    }

    public OrderPage clickNoOrderButton(){
        getNoOrderConfirmButton().click();
        return this;
    }



    public OrderPage fillFirstOrderForm(String name,String surname, String address, String subwayName, String subwayColor, String phone){
        fillNameField(this.name = name);
        fillSurnameField(this.surname = surname);
        fillAddressField(this.address = address);
        fillSubwayField(this.subwayName = subwayName, this.subwayColor = subwayColor);
        fillPhoneField(this.phoneNumber = phone);
        return this;
    }

}
