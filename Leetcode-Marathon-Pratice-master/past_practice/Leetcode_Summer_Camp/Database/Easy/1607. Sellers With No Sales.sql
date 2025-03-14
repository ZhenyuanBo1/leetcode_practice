# Write your MySQL query statement below
select s1.seller_name
from Seller s1
where s1.seller_id not in (
    select distinct s.seller_id
    from Seller s, Orders o
    where s.seller_id = o.seller_id and o.sale_date >= '2020-01-01'
    )
order by s1.seller_name asc