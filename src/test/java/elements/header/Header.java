package elements.header;



public class Header extends HeaderSelectors{

public Header scooterLogoClick(){
    getScooterLogo().click();
    return this;
}

public Header orderButtonClick(){
    getOrderButton().click();
    return this;
}

}
