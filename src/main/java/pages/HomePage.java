package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id='women-floor']")
    private WebElement womenButton;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='myAccountDropdown']")
    private WebElement accountField;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement singInButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinButton;


    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public boolean isAccountFieldVisible() {
        return accountField.isDisplayed();
    }

    public void clickJoinButton(){
        Actions action = new Actions(driver);
        action.moveToElement(accountField).pause(1000).moveToElement(joinButton).click().build().perform();

    }

    public void clickSignInButton(){
        Actions action = new Actions(driver);
        action.moveToElement(accountField).pause(1000).moveToElement(singInButton).click().build().perform();
    }

    public void clickWomenButton(){
        womenButton.click();
    }

    public void searchByKeyword(final String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton(){
        searchButton.click();
    }


}
