package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section[@class='grid-text__container']")
    private WebElement header;


    public String getTextHeader(){
       return header.getText();
    }
}

//idfjghgfg