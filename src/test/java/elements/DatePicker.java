package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class DatePicker {
        private SelenideElement nextMonthButton = $(byAttribute("aria-label","Next Month")),
        previousMonthButton = $(byAttribute("aria-label","Previous Month")),

       datepickerHeaderText = $(byClassName("react-datepicker__current-month"));





        public DatePicker clickNextMonthButton(){
                nextMonthButton.click();
                return this;
        }
        public DatePicker clickPreviousMonthButton(){
                previousMonthButton.click();
                return this;
        }

        public DatePicker chooseDayOfWeek(String dayOfTheWeek){  //формат ввода "понедельник, 25-е марта 2024 г."
            $(byAttribute("aria-label","Choose " + dayOfTheWeek)).click();
            return this;
        }



        }
