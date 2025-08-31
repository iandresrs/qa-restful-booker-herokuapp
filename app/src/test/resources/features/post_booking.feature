Feature: Post booking
  Me as a quality analyst.
  I wish to use the post-booking service
  To validate the creation of a booking

  Background:
    Given I can consume the booking service

  @PostBooking
  Scenario Outline: Retrieve an existing booking
    When i validate the booking "<booking>" information
    Then the service responds with status code 200
    And the response contains the booking data provided from the data source "<booking>"

    Examples:
      | booking     |
      | goodBooking |
