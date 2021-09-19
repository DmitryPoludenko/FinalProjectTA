Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly


  Scenario Outline: Check that url contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that current url contains 'searchWord'

    Examples:
      | homePage              | searchWord |
      | https://www.asos.com/ | scirt      |

  Scenario Outline: Check item missing on search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keywordOfLack>'
    And User clicks search button
    And User checks that current url contains keyword
    Then User checks lack of products with '<searchHeader>'

    Examples:
      | homePage              | keywordOfLack | searchHeader                |
      | https://www.asos.com/ | idfjghgfg     | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check elements amount on search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that amount of products in search page are '<amountOfElements>'

    Examples:
      | homePage              | searchWord | amountOfElements |
      | https://www.asos.com/ | Scirt      | 72               |

  Scenario Outline: Check correctly working filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword ‘searchWord’
    And User clicks search button
    And User checks filter’s field visibility
    When User clicks '<SaleNewSeason>' filter button
    And User clicks 'NewSeason' field
    Then User checks that current url contains '<filterWord>'

    Examples:
      | homePage              | SaleNewSeason | filterWord |
      | https://www.asos.com/ | New Season    | new_season |

  Scenario Outline: Check correctly working floor navigation menu
    Given User opens '<homePage>' page
    And User clicks 'women' button
    And User checks floor navigation menu visibility
    When User moves to 'sale' field
    When User clicks '<bestOfSale>' button
    Then user checks that salePage header is '<saleHeader>'

    Examples:
      | homePage              | saleHeader   |
      | https://www.asos.com/ | Best of Sale |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks wish list on first product
    Then user checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | searchWord | amountOfProducts |
      | https://www.asos.com/ | Scirt      | 1                |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User checks 'ADD TO BAG' button visibility
    And User checks size field visibility
    And User clicks size field
    And User clicks on first size field
    And User clicks 'ADD TO BAG' button on product
    And User moves to 'MY BAG' button
    And User checks 'VIEW BAG' button visibility
    And User checks 'CHECKOUT' button visibility
    And User clicks 'VIEW BAG' button
    Then User checks that cart page header is '<cartHeader>'

    Examples:
      | homePage              | searchWord | cartHeader                        |
      | https://www.asos.com/ | Scirt      | Items are reserved for 60 minutes |


  Scenario Outline: Check the impossibility of adding to the cart without selecting a size
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User checks 'ADD TO BAG' button visibility
    And User clicks 'ADD TO BAG' button
    Then user checks the '<message>'

    Examples:
      | homePage              | searchWord | message                                                  |
      | https://www.asos.com/ | Scirt      | Please select from the available colour and size options |


  Scenario Outline: Check quick sign up using Join menu
    Given User opens '<homePage>' page
    And User checks account field visibility
    And User moves to account field
    When User clicks 'join' field on account popup
    Then User checks that the join page header contains '<joinHeader>'
    And User checks 'signUpViaGoogle' button visibility
    And User checks 'signUpViaApple' button visibility
    And User checks 'signUpViaFacebook' button visibility

    Examples:
      | homePage              | joinHeader     |
      | https://www.asos.com/ | is super quick |


  Scenario Outline: Check impossibility adding wrong email address in Sign in menu
    Given User opens '<homePage>' page
    And User checks account field visibility
    And User moves to account field
    And User clicks 'sign_in' field on account popup
    And Users checks email field visibility
    And user checks password field visibility
    And user checks 'signIn' button visibility
    When user types email address by keyword '<mailWord>'
    Then user checks '<errorMessage>' visibility

    Examples:
      | homePage              | mailWord  | errorMessage |
      | https://www.asos.com/ | idfjghgfg | Email fail!  |











