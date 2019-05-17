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
    Given Get operation to list all fraction in a profile "/profiles/{profileName}/fractions"
    And  Provide profile name "Profile100"


  Scenario:
    Given Get operation to get a single   fraction from fraction list "/profiles/fractions/{fractionId}"
    And I will Provide  fraction id "1"


  Scenario:
    Given  I will perform Delete operation on "/profiles"
    And    I will pass profile id "100"