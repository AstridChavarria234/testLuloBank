Feature:Removal company employee
  I as manager the api-services
  I want to remove an employee from the api-services
  To release record

  Scenario Outline: Removal company employee
    When removal of the person is done
      | id_employee | <id_employee> |
    Then it should indicate that the deletion was successful
    Examples:
      | id_employee |
      | 719         |