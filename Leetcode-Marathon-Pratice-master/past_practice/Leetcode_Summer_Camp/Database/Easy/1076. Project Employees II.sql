# Write your MySQL query statement below
with T as(
    select P.project_id, count(P.employee_id) as num
    from Project P, Employee E
    where P.project_id = E.employee_id
    group by P.project_id
    # having num = max(num)
)

select T.project_id
from T
where T.num = (select max(T.num) from T)