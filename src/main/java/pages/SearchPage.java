package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//section[@class='grid-text__container']")
    private WebElement header;
    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> amountOfProducts;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getTextHeader() {
        return header.getText();
    }

    public List<WebElement> getSearchResultsList() {
        return amountOfProducts;
    }

    public int getAmountOfProducts() {
        return getSearchResultsList().size();
    }
}

