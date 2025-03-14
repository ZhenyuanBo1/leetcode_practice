# Write your MySQL query statement below

select distinct s.buyer_id
from Sales s, Product p
where s.product_id = p.product_id and p.product_name = 'S8' and s.buyer_id not in
(
    select distinct s1.buyer_id
    from Sales s1, Product p1
    where s1.product_id = p1.product_id and p1.product_name = 'iPhone'
)

