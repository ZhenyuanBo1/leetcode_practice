with T as
(
    select s.seller_id, sum(s.price) as total_price
    from Sales s
    group by s.seller_id
)

select T.seller_id
from T
where T.total_price = (select max(total_price) from T)