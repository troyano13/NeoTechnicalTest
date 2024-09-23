#Author: alexandraTroyanop@gmail.com
#Keywords Summary :cucumber, selenium, java, gradle


Feature: Email Processing

  Scenario Outline: Process and label emails, download attachments, and log out
    Given the bot is logged into the email page "<email>" and  "<password>"
    And log in correctly
    When the bot retrieves emails with the subject "Neostella"
    And it labels those emails as "processing"
    And the bot retrieves emails with the subject "-Neostella"
    And it labels those emails as "exceptions"
    Then the bot downloads the unread documents from the "processing" emails
    And saves the attachments to a shared folder with the current date
    And verifies that the inbox has no incoming emails "Neostella"
    And the bot finishes by logging out
    Examples:
      | email           | password |
      | est.XXXXXXXX.co | X1XXXXX@ |