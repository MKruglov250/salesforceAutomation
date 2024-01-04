Feature: create Account

  Background: login to site
    Given User logs in

  Scenario:
    When User Opens Account page
    When User Creates Account John Frost
    Then Account Title is John Frost