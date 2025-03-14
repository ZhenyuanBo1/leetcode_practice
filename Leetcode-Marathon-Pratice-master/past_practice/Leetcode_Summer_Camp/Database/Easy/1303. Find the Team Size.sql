# Write your MySQL query statement below
with T as(
    select team_id, count(employee_id) as team_size
    from Employee
    group by team_id
)

select e.employee_id, T.team_size
from Employee e, T
where e.team_id = T.team_id;