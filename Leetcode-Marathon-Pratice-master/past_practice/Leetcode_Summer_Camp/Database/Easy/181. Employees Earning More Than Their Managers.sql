# Write your MySQL query statement below

SELECT E.Name as "Employee"
from Employee E
WHERE E.Salary > (SELECT E2.Salary FROM Employee E2 WHERE E2.id = E.ManagerId)