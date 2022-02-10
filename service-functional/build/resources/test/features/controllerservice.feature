Feature: the stocks are retrieved
  Scenario: client makes call to GET /stocks
    When the client calls /stocks
    Then the client receives status code of 200
#    And the client receives stocks