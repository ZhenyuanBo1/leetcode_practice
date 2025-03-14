# Write your MySQL query statement below
select p.product_name as PRODUCT_NAME, sum(o.unit) as UNIT
from Products p, Orders o
where p.product_id = o.product_id and o.order_date between '2020-02-01' and '2020-02-29'
group by p.product_id
having unit >= 100