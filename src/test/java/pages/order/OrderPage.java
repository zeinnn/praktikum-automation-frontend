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
import io.qameta.allure.Attachment;
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

public class OrderPage extends OrderPageSelectors {

    public void assertScreen(TestInfo info) {
        String expectedFileName = info.getTestMethod().get().getName() + ".png";
        String expectedScreenDir = "src/test/resources/screens/";

        File actualScreenshot = Selenide.screenshot(OutputType.FILE);
        File expectedScreenshot = new File(expectedScreenDir + expectedFileName);

        if (!expectedScreenshot.exists()) {
            addImgToAllure("actual", actualScreenshot);
            throw new IllegalArgumentException("Cant assert image, because there is no reference." +
                    " Actual screen can be downloaded from allure");
        }

        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(expectedScreenDir + expectedFileName);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(actualScreenshot.toPath().toString());

        File resultDestination = new File("build/reports/tests" + expectedFileName);

        ImageComparison imageComparison = new ImageComparison(expectedImage, actualImage, resultDestination);
        ImageComparisonResult result = imageComparison.compareImages();

        if (result.getImageComparisonState().equals(ImageComparisonState.MATCH)) {
            addImgToAllure("actual", actualScreenshot);
            addImgToAllure("expected", expectedScreenshot);
            addImgToAllure("diff", resultDestination);
        }

        Assertions.assertEquals(ImageComparisonState.MATCH, result.getImageComparisonState());
    }

    private void addImgToAllure(String name, File file) {
        try {
            byte[] image = Files.readAllBytes(file.toPath());
            saveScreenshot(name, image);
        } catch (IOException e) {
            throw new RuntimeException("Cant read bytes");
        }
    }

    @Attachment(value = "{name}")
    private static byte[] saveScreenshot(String name, byte[] image) {
        return image;
    }

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
        $(byXpath(".//div[(@class = 'Dropdown-option' and text() = '"+rentDate+"')]")).shouldHave(Condition.text(rentDate)).scrollTo().click();
        return this;
    }
}
