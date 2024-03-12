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

public Header fillOrderNumberField(String string){
    getOrderNumberField().sendKeys(string);
    return this;
}

public Header clickOrderStatusButton(){
    getOrderStatusButton().click();
    return this;
}

public Header clickGoButton(){
    getGoButton().click();
    return this;
}

}
