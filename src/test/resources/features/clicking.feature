Feature: Validate clicking in calculator

  # simplest scenario
  Scenario: Click on number button
    Given empty line
    When I click on number "8" button
    Then I expect on line "8"

  Scenario: Click on Submit button
    Given empty line
    When I click on number "8" button
      And I type "*"
      And I click on number "6" button
      And I submit
    Then I expect on line "48"