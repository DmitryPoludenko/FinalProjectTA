package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    private static final String SEARCH_WORD = "scirt";
    private static final String WRONG_SEARCH_WORD = "idfjghgfg";
    WebDriver driver;
    HomePage homePage;
    AccountPage accountPage;
    AddToCartPage addToCartPage;
    BestOfSalePage bestOfSalePage;
    HomePageWithNavigation homePageWithNavigation;
    ProductPage productPage;
    SearchPage searchPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void makeSearchByKeywordSearchWord(final String searchWord) {
        homePage.searchByKeyword(searchWord);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Then("User checks that current url contains {string}")
    public void checkThatCurrentUrlContainsFilterWord(final String currUrl) {
        assertTrue(driver.getCurrentUrl().contains(currUrl));

    }

    @And("User checks that current url contains keyword")
    public void checkThatCurrentUrlContainsKeyword() {
        assertTrue(driver.getCurrentUrl().contains(WRONG_SEARCH_WORD));
    }

    @Then("User checks lack of products with {string}")
    public void checkLackOfProductsWithSearchHeader(final String searchHeader) {

        searchPage = pageFactoryManager.getSearchPage();
        assertTrue(searchPage.getTextHeader().contains(searchHeader));
    }

    @Then("User checks that amount of products in search page are {string}")
    public void checkThatAmountOfProductsInSearchPageAreAmountOfElements(final String amountOfElements) {
        searchPage = pageFactoryManager.getSearchPage();

        assertEquals(Integer.parseInt(amountOfElements) , searchPage.getAmountOfProducts());
    }

    @And("User makes search by keyword ‘searchWord’")
    public void makeSearchByKeyword() {
        homePage.searchByKeyword(SEARCH_WORD);
    }

    @And("User checks filter’s field visibility")
    public void userChecksFilterSFieldVisibility() {
    }

    @When("User clicks {string} filter button")
    public void userClicksSaleNewSeasonFilterButton() {
    }

    @And("User clicks {string} field")
    public void userClicksNewSeasonField() {
    }

    @And("User clicks {string} button")
    public void userClicksWomenButton() {
    }

    @And("User checks floor navigation menu visibility")
    public void userChecksFloorNavigationMenuVisibility() {
    }

    @When("User moves to {string} field")
    public void userMovesToSaleField() {
    }

    @Then("user checks that salePage header is {string}")
    public void userChecksThatSalePageHeaderIsSaleHeader() {
    }

    @And("User clicks wish list on first product")
    public void userClicksWishListOnFirstProduct() {
    }

    @Then("user checks that amount of products in wish list are {string}")
    public void userChecksThatAmountOfProductsInWishListAreAmountOfProducts() {
    }

    @And("User clicks on first product")
    public void userClicksOnFirstProduct() {
    }

    @And("User checks {string} button visibility")
    public void userChecksADDTOBAGButtonVisibility() {
    }

    @And("User checks size field visibility")
    public void userChecksSizeFieldVisibility() {
    }

    @And("User clicks size field")
    public void userClicksSizeField() {
    }

    @And("User clicks on first size field")
    public void userClicksOnFirstSizeField() {
    }

    @And("User clicks {string} button on product")
    public void userClicksADDTOBAGButtonOnProduct() {
    }

    @And("User moves to {string} button")
    public void userMovesToMYBAGButton() {
    }

    @Then("User checks that cart page header is {string}")
    public void userChecksThatCartPageHeaderIsCartHeader() {
    }

    @Then("user checks the {string}")
    public void userChecksTheMessage() {
    }

    @And("User checks account field visibility")
    public void userChecksAccountFieldVisibility() {
    }

    @And("User moves to account field")
    public void userMovesToAccountField() {
    }

    @When("User clicks {string} field on account popup")
    public void userClicksJoinFieldOnAccountPopup() {
    }

    @Then("User checks that the join page header contains {string}")
    public void userChecksThatTheJoinPageHeaderContainsJoinHeader() {
    }

    @And("Users checks email field visibility")
    public void usersChecksEmailFieldVisibility() {
    }

    @And("user checks password field visibility")
    public void userChecksPasswordFieldVisibility() {
    }

    @And("user checks {string} button visibility")
    public void userChecksSignInButtonVisibility() {
    }

    @When("user types email address by keyword {string}")
    public void userTypesEmailAddressByKeywordMailWord() {
    }

    @Then("user checks {string} visibility")
    public void userChecksErrorMessageVisibility() {
    }



    @After
    public void tearDown() {
        driver.close();
    }


}
