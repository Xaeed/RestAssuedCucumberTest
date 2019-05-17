Feature:
  verify different get and post methods for profiles

  Scenario:
    Given  Post  operation to create Profile "/profiles"
    And   Provide  meterId "100" and profileName "Profile100" to create profile

  Scenario:
    Given Get operation to get profile by id "/profiles"
    And Pass  meter id  "100"
    Then  I should see  meter id  and name from profiles content


  Scenario:
    Given Get operation to list  all "/profiles"
    Then i should see all meters and name


  Scenario:
    Given  POST operation to Create fraction "/profile/{meterId}/fractions"
    And   Provide meterId "100" month "MARCH" value "1.0"

  Scenario:
    Given Get operation to list all fraction in a profile "/profiles/{meterId}/fractions"
    And  Provide meterId Id "100"

  Scenario:
    Given Get operation to get a single   fraction from fraction list "/profiles/fractions/{fractionId}"
    And I will Provide  fraction id 1

  Scenario:
    Given  Post operation to create meterreadings "/meterreadings/list"
    And  Provide meterId 100 and timestamp "2019-02-06" month "MARCH" and volume 2000

  Scenario:
    Given  GET operation to list all "/meterreadings"
    Then   I should all meter reading data

  Scenario:
    Given  Get operation to get meterReadings By Id "/meterreadings"
    And   Provide meterreading Id to get required meterReading 13


  Scenario:
    Given  Delete operation on meterreadings to delete meterReading "meterreadings/meter/{id}/month/{Month}"
    And I will provide meter 100 and month "MARCH"


  Scenario:
    Given  I will perform Delete operation on "/profiles"
    And    I will pass profile id "100"