Feature: Test

  Background:
    Given user on homepage

  Scenario Outline: Product List
    Then set viewport <width> <height>
    When user move to product list
    Then user verifies the number of the item in the list
    Examples:
      | width | height |
      | 1440  | 900    |
      | 414   | 900    |

  Scenario Outline: Counter Badge
    Then set viewport <width> <height>
    Then user verifies counter the badge icon
    Examples:
      | width | height |
      | 1440  | 900    |
      | 414   | 900    |

  Scenario Outline:Clean Button
    Given user on homepage
    Then set viewport <width> <height>
    And user adds <items> into the cart
    Then user clicks on clean button
    Examples:
      | width | height | items |
      | 1440  | 900    | 18    |
      | 414   | 900    | 29    |

