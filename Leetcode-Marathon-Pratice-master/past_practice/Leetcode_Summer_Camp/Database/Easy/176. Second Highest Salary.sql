# Write your MySQL query statement below
select max(Salary) as "SecondHighestSalary"
from Employee
where Salary NOT IN (
    select max(Salary)
    from Employee
)