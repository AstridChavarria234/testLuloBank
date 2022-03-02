Feature:Add employee to company
  I as manager the company
  I want to add an employee to the company
  To have the record of the employee

  Scenario Outline: Add company employee
    When Add the employee
      | employee_name   | <employee_name>   |
      | employee_salary | <employee_salary> |
      | employee_age    | <employee_age>    |
      | profile_image   | <profile_image>   |
    Then personal information should be displayed of the added employee
    Examples:
      | employee_name | employee_salary | employee_age | profile_image       |
      | testName      | 433060          | 22           | lnms&tbm=isch&sa123 |


