# Write your MySQL query statement below
select distinct trim(lower(s.product_name)) as PRODUCT_NAME,
        DATE_FORMAT(sale_date, '%Y-%m' ) AS sale_date,
        count(s.sale_date) as TOTAL
from Sales s
group by 1,2
order by 1,2