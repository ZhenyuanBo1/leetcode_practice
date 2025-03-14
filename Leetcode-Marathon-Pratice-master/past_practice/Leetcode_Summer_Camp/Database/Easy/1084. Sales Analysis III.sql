# Write your MySQL query statement below
select distinct p.product_id, p.product_name
from Product p, Sales s
where p.product_id = s.product_id and s.sale_date between '2019-01-01' and '2019-03-31' and p.product_id not in
(
    select distinct p1.product_id
    from Product p1, Sales s1
    where p1.product_id = s1.product_id and s1.sale_date not between '2019-01-01' and '2019-03-31'
)