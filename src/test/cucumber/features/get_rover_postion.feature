Feature: Get Rover Position
    Scenario: Get the position of the rover for given input
        Given I start my application
        When I provide "input1" as my input file
        Then I receive the output as in "output1" file
