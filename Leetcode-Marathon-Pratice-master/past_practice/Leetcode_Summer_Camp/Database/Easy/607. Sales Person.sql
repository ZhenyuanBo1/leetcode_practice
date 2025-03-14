# Write your MySQL query statement below
select s1.name
from salesperson s1
where s1.sales_id not in(
    select s.sales_id
    from salesperson s, orders o, company c
    where  s.sales_id = o.sales_id and o.com_id = c.com_id  and c.name = 'RED'
)