Feature: Weather forecast

  Scenario: Weather forecast check for specific city
    Given city ID is: 52347
    When we are requesting weather forecast

    Then coordinates are:
      | latitude  | 39.31 |
      | longitude | -74.5 |

    And timezone information is:
      | timezone | America/New_York |
      | offset   | -18000           |

    And current weather data is:
      | time        | 1646318698 |
      | sunrise     | 1646306882 |
      | sunset      | 1646347929 |
      | temperature | 282.21     |
      | feeling     | 278.41     |
      | pressure    | 1014       |
      | humidity    | 65         |
      | dew         | 275.99     |
      | ultraviolet | 2.55       |
      | clouds      | 40         |
      | visibility  | 10000      |

    And current wind is:
      | speed   | 8.75  |
      | degrees | 360   |
      | gust    | 13.89 |

    And current weather condition Nr. 1 is:
      | id          | 802             |
      | main        | Clouds          |
      | description | scatteredclouds |
      | icon        | 03d             |
#
    And minutely data Nr. 1 are:
      | time          | 1646318700 |
      | precipitation | 0          |
#
    And hourly weather data Nr. 1 are:
      | time        | 1646316000 |
      | temperature | 281.94     |
      | feeling     | 278.49     |
      | pressure    | 1014       |
      | humidity    | 67         |
      | dew         | 276.16     |
      | ultraviolet | 1.49       |
      | clouds      | 52         |
      | visibility  | 10000      |
      | speed       | 7.16       |
      | degrees     | 313        |
      | gust        | 10.71      |

    And hourly weather condition Nr. 1 is:
      | id          | 803           |
      | main        | Clouds        |
      | description | brokenclouds |
      | icon        | 04d           |

    And probability of precipitation is:
      | pop | 0.03 |
#
    And day data Nr. 1 are:
      | time      | 1646326800 |
      | sunrise   | 1646306882 |
      | sunset    | 1646347929 |
      | moonrise  | 1646309880 |
      | moonset   | 1646352120 |
      | moonphase | 0.03       |

    And day temperature for day Nr. 1 is:
      | daytemp | 281.63 |
      | minimum | 271.72 |
      | maximum | 282.21 |
      | night   | 271.72 |
      | evening | 277.99 |
      | morning | 280.92 |

    And day feeling for day Nr. 1 is like:
      | dayfeel | 277.83 |
      | night   | 264.72 |
      | evening | 273.35 |
      | morning | 277.66 |

    And day air data for day Nr. 1 are:
      | pressure | 1016   |
      | humidity | 55     |
      | dew      | 273.12 |

    And day wind for day Nr. 1 is:
      | speed   | 9.29  |
      | degrees | 3     |
      | gust    | 16.48 |

    And day weather condition Nr. 1 is:
      | id          | 500       |
      | main        | Rain      |
      | description | lightrain |
      | icon        | 10d       |

    And day sky condition for day Nr. 1 is:
      | clouds      | 49   |
      | pop         | 0.25 |
      | rain        | 0.11 |
      | ultraviolet | 3.38 |


#
#  ...

    And alert Nr. 1 received:
      | sender      | NWSPhiladelphia-MountHolly(NewJersey,Delaware,SoutheasternPennsylvania)                                                                                                                                                                                                                                                                                                                                                                                                                             |
      | event       | SmallCraftAdvisory                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
      | start       | 1646344800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | end         | 1646380800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
      | description | ...SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHIS\nAFTERNOONTO3AMESTFRIDAY...\n*WHAT...Northwinds15to20ktwithgustsupto25ktandseas\n3to5ftexpected.\n*WHERE...CoastalwatersfromLittleEggInlettoGreatEgg\nInletNJout20nm,CoastalwatersfromGreatEggInletto\nCapeMayNJout20nmandCoastalwatersfromManasquanInlet\ntoLittleEggInletNJout20nm.\n*WHEN...From5PMthisafternoonto3AMESTFriday.\n*IMPACTS...Conditionswillbehazardoustosmallcraft.|
      | tags        |[]                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
    And tags for an alert Nr. 1 are:
      | Sunny  |
      | Clouds |

#    And alert Nr. 2 received:
#      | sender      |...SMALLCRAFTADVISORYREMAINSINEFFECTFROM5PMTHIS\nAFTERNOONTO3AMESTFRIDAY...\n*WHAT...Northwinds15to20ktwithgustsupto25ktandseas\n3to5ftexpected.\n*WHERE...CoastalwatersfromLittleEggInlettoGreatEgg\nInletNJout20nm,CoastalwatersfromGreatEggInletto\nCapeMayNJout20nmandCoastalwatersfromManasquanInlet\ntoLittleEggInletNJout20nm.\n*WHEN...From5PMthisafternoonto3AMESTFriday.\n*IMPACTS...Conditionswillbehazardoustosmallcraft.|
#      | event       | SmallCraftAdvisory                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
#      | start       | 1646344800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
#      | end         | 1646380800                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
#      | description | ...SMALL CRAFT ADVISORY REMAINS IN EFFECT FROM 5 PM THIS AFTERNOON TO 3 AM EST FRIDAY...WHAT...North winds 15 to 20 kt with gusts up to 25 kt and seas 3 to 5 ft expected. WHERE...Coastal waters from Little Egg Inlet to Great Egg  Inlet NJ out 20 nm, Coastal waters from Great Egg Inlet to Cape May NJ out 20 nm and Coastal waters from Manasquan Inlet  to Little Egg Inlet NJ out 20 nm. WHEN...From 5 PM this afternoon to 3 AM EST Friday. IMPACTS...Conditions will be hazardous to small craft. |
#      | tags        |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
#    And tags for an alert Nr. 2 are:
#      | Sunny  |
#      | Clouds |

#    Then latitude is 39.31
#    And longitude is -74.5
#    And timezone is "America/New_York"
#    And timezone offset is -18000
#    And current time is 1646318698
#    And current sunrise is at 1646306882
#    And current sunset is at 1646347929
#    And current temperature is 282.21  K
# ...