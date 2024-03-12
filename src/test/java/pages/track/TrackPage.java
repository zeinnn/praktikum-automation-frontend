package pages.track;

import com.codeborne.selenide.Condition;

public class TrackPage extends  TrackPageSelectors{

    public void checkNotFound(){
        getSrc().shouldBe(Condition.visible);
        //getSrc().shouldHave(Condition.cssValue("src","/assets/not-found.png"));
        getSrc().shouldBe(Condition.image);
        getSrc().shouldBe(Condition.exist);
    }
}
