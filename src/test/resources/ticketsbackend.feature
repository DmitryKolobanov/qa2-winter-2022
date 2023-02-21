Feature: Tickets reservation online

  Scenario: Successful ticket reservation

    Given flight_info
      | destination   | SFO        |
      | departure     | RIX        |
      | discount_code | Hackers    |
      | adults        | 2          |
      | kids          | 1          |
      | bags          | 2          |
      | flight_date   | 12-05-2018 |
      | seat          | 21         |

    And passenger_info is
      | first_name | Dimas |
      | last_name  | Kolob |

    And home page opened

    When we are selecting airports
    Then selected airports appears on the next page


    When we are filling in passenger registration form
    And requesting price

    Then passenger name and airports appears
    And price is 2140 EUR

    When we are pressing Book button
    And selecting seat

    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

#    When we are requesting reservations data
#    Then current reservation is in the list
#    And all reservation data are correct