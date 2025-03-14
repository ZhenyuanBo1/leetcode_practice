with T as
(
    select customer_number, count(order_number) num
    from Orders
    group by customer_number
)

select T.customer_number
from T
where T.num = (select max(num) from T);