Feature:Select company employees
  I as manager the company
  I want to select the information of employees
  To know your personal information

  Scenario Outline: Select company employee
    When Select the employee
      | id_employee | <id_employee> |
    Then personal information should be displayed
    Examples:
      | id_employee |
      | 4           |

  Scenario: Select company employees
    When Select the employees
    Then personal information should be displayed for all employees

