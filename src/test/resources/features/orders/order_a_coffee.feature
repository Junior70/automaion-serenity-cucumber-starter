Feature: Order a coffee

  In order  to save time  when  I pick  up my  morning  coffee
  As  a coffee lover
  I want  to be  able  to order  my coffee   in advance

  @test1
  Scenario: Buyer orders a coffee when they are close to the coffee shop
    Given Junior is 100 meters from the coffee shop
    When Junior orders a large cappuccino
    Then Barry should receive the order
    And Barry should know that the order is Urgent

  @test2
  Scenario: Buyer orders a coffee when they are close to the coffee shop
    Given Junior is 300 meters from the coffee shop
    When Junior orders a large cappuccino
    Then Barry should receive the order
    And Barry should know that the order is Urgent


