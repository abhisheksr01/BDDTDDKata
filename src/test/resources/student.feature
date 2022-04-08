Feature: Retrieve Student Information

  Scenario: When a name prefix is passed all the students information starting with that is returned
    Given Student enters name prefix "n"
    When The student makes a call to "http://localhost:9090/student/search/" get the details
    Then The API should return the student details and response code 200