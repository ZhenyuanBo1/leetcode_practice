# Write your MySQL query statement below
select c.customer_id CUSTOMER_ID, c.name NAME
from Customers c, Product p, Orders o
where c.customer_id = o.customer_id
    and p.product_id = o.product_id
    and o.order_date between '2020-06-01' and '2020-06-30'
    and c.customer_id IN (
        select c1.customer_id
        from Customers c1, Product p1, Orders o1
        where c1.customer_id = o1.customer_id
            and p1.product_id = o1.product_id
            and o1.order_date between '2020-07-01' and '2020-07-31'
        group by c1.customer_id
        having sum(o1.quantity * p1.price) >= 100

    )
group by c.customer_id
having sum(o.quantity * p.price) >= 100